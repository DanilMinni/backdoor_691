package com.example.ework;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import android.text.format.DateFormat;


public class Chat extends AppCompatActivity {
    private static int SIGN_IN_CODE=1;
    private RelativeLayout chat_layout;
    private FirebaseListAdapter<Massage> adapter;
    private FloatingActionButton sendBtn;
    private  String massage;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == SIGN_IN_CODE){
            if(resultCode==RESULT_OK){
                Snackbar.make(chat_layout, "Авторизация прошла успешно", Snackbar.LENGTH_LONG).show();
                displayAllMassages();
            }else{Snackbar.make(chat_layout, "Не удалось авторизироваться", Snackbar.LENGTH_LONG).show();
            finish();
            }

        }
    }

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_layout);

        chat_layout=findViewById(R.id.chat_layout);
        sendBtn=findViewById(R.id.btnSend);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText textField = findViewById(R.id.massageFild);

                if( textField.getText().toString() == "") return;
                FirebaseDatabase.getInstance().getReference().push().setValue(new Massage(FirebaseAuth.getInstance().getCurrentUser().getEmail(),textField.getText().toString()));
                textField.setText(massage);
            }
        });

        //не авторизован
        if(FirebaseAuth.getInstance().getCurrentUser() == null)
            startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().build(), SIGN_IN_CODE);
        else{
            Snackbar.make(chat_layout, "Авторизация прошла успешно", Snackbar.LENGTH_LONG).show();

        displayAllMassages();}
    }

    private void displayAllMassages() {
        ListView listOfMassages = findViewById(R.id.list_of_massages);
        adapter = new FirebaseListAdapter<Massage>(this,Massage.class,R.layout.list_item, FirebaseDatabase.getInstance().getReference()) {
            @Override
            protected void populateView(View v, Massage model, int position) {
                TextView mess_user,mess_time,mess_text;
                mess_user = v.findViewById(R.id.massage_user);
                mess_time = v.findViewById(R.id.massage_time);
                mess_text = v.findViewById(R.id.massage_text);

                mess_user.setText(model.getUserName());
                mess_text.setText(model.getTextMassage());
                mess_time.setText(DateFormat.format("dd-mm-yyyy HH:mm:ss", model.getMessageTime()));

            }
        };
        listOfMassages.setAdapter(adapter);
    }
}
