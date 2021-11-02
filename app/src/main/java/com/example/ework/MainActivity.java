package com.example.ework;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends Activity {
    private View gif_activity;
    private TextView item_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

    }
public void OnChatClick(View v){
        Intent i =new Intent(MainActivity.this,Chat.class);
        startActivity(i);
        finish();
}




}