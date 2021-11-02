package com.example.ework;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;


public class Chat extends AppCompatActivity {
    private static int SIGN_IN_CODE=1;
    private RelativeLayout chat_layout;
    private FirebaseListAdapter<Massage> adapter;

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

        //не авторизован
        if(FirebaseAuth.getInstance().getCurrentUser() == null)
            startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().build(), SIGN_IN_CODE);
        else{
            Snackbar.make(chat_layout, "Авторизация прошла успешно", Snackbar.LENGTH_LONG).show();

        displayAllMassages();}
    }

    private void displayAllMassages() {
        ListView listOfMassages = findViewById(R.id.list_of_massages);
    }
}
