package com.example.ework;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends Activity {
    private View gif_activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
    }
    public void OnAdviceClick(View view) {
        Intent i = new Intent(MainActivity.this,advice.class);
        startActivity(i);
        finish();
    }
}