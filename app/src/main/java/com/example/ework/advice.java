package com.example.ework;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class advice extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


       setContentView(R.layout.advice_layout);

    }
        public void OnBackClick(View view)
        {setContentView(R.layout.advice_layout);}
        public void OnWashClick(View view)
        {
            setContentView(R.layout.list_advice);
            TextView wash_list = findViewById(R.id.wash_list);
            wash_list.setText(R.string.wash_book_list);

        }
        public void OnWorkClick(View view)
    {
        setContentView(R.layout.list_advice);
        TextView wash_list = findViewById(R.id.wash_list);
        wash_list.setText(R.string.work_book_list);

    }
    public void OnStateClick(View view)
    {
        setContentView(R.layout.list_advice);
        TextView wash_list = findViewById(R.id.wash_list);
        wash_list.setText(R.string.state_book_list);

    }
    public void OnPsyhoClick(View view)
    {
        setContentView(R.layout.list_advice);
        TextView wash_list = findViewById(R.id.wash_list);
        wash_list.setText(R.string.psyho_book_list);

    }
    }

