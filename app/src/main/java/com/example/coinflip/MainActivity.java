package com.example.coinflip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    private ImageView coin;
    private Button fejBtn;
    private Button irasBtn;
    private TextView dobasok;
    private TextView vereseg;
    private TextView gyozelem;
    private Random rnd;
    private int tipp, dobas, nyeres, vesztes, fejIras; //fej 1, iras 2




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        fejBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tipp = 1;
                dobas++;
                dobasok.setText(String.valueOf(dobas));
                fejIras = rnd.nextInt(2);
                switch (fejIras)
                {
                    case 1:
                        coin.setImageResource(R.drawable.heads);
                        Toast.makeText(MainActivity.this, "Fej lett", Toast.LENGTH_SHORT).show();
                        nyeres++;
                        gyozelem.setText(String.valueOf(nyeres));
                        break;
                    case 2:
                        coin.setImageResource(R.drawable.tails);
                        vesztes++;
                        Toast.makeText(MainActivity.this, "Iras lett", Toast.LENGTH_SHORT).show();
                        vereseg.setText(String.valueOf(vesztes));
                        break;
                }
            }
        });

        irasBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tipp = 2;
                dobas++;
                fejIras = rnd.nextInt(2);
                switch (fejIras)
                {
                    case 1:
                        coin.setImageResource(R.drawable.heads);
                        vesztes++;
                        Toast.makeText(MainActivity.this, "Fej lett", Toast.LENGTH_SHORT).show();
                        vereseg.setText(String.valueOf(vesztes));
                        break;
                    case 2:
                        coin.setImageResource(R.drawable.tails);
                        Toast.makeText(MainActivity.this, "Iras lett", Toast.LENGTH_SHORT).show();
                        nyeres++;
                        gyozelem.setText(String.valueOf(nyeres));
                        break;
                }
            }
        });



    }

    private void init()
    {
        coin = findViewById(R.id.coin);
        fejBtn = findViewById(R.id.fej_btn);
        irasBtn = findViewById(R.id.iras_btn);
        dobasok = findViewById(R.id.dobasok);
        vereseg = findViewById(R.id.vereseg);
        gyozelem = findViewById(R.id.gyozelem);
        rnd = new Random();
        tipp = 0;
        dobas = 0;
        nyeres = 0;
        vesztes = 0;
    }
}