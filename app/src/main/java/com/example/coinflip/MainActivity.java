package com.example.coinflip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private ImageView coin;
    private Button fejBtn;
    private Button irasBtn;
    private TextView dobasok;
    private TextView vereseg;
    private TextView gyozelem;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


    }

    private void init()
    {
        coin = findViewById(R.id.coin);
        fejBtn = findViewById(R.id.fej_btn);
        irasBtn = findViewById(R.id.iras_btn);
        dobasok = findViewById(R.id.dobasok);
        vereseg = findViewById(R.id.vereseg);
        gyozelem = findViewById(R.id.gyozelem);
    }
}