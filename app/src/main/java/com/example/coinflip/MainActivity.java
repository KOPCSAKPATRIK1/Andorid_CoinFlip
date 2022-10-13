package com.example.coinflip;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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
    private int dobas, nyeres, vesztes, fejIras; //fej 1, iras 2
    private AlertDialog.Builder builderVege;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        fejBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dobas++;
                fejIras = rnd.nextInt(2);
                if (fejIras == 1)
                {
                    coin.setImageResource(R.drawable.heads);
                    Toast.makeText(MainActivity.this, "Fej lett", Toast.LENGTH_SHORT).show();
                    nyeres++;
                    gyozelem.setText("Győzelem: " + String.valueOf(nyeres));
                    if (dobas == 5)
                    {
                        builderVege.setTitle("Vereség").create();
                        builderVege.show();
                    }
                    else if(nyeres == 3)
                    {
                        builderVege.setTitle("Győzelem").create();
                        builderVege.show();
                    }
                }
                else
                {
                    coin.setImageResource(R.drawable.tails);
                    vesztes++;
                    Toast.makeText(MainActivity.this, "Iras lett", Toast.LENGTH_SHORT).show();
                    vereseg.setText("Vereség: " + String.valueOf(vesztes));
                    if (dobas == 5)
                    {
                        builderVege.show();
                        builderVege.setTitle("Vereség").create();
                    }
                }
                dobasok.setText("Dobások: " + String.valueOf(dobas));
            }
        });

        irasBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dobas++;
                fejIras = rnd.nextInt(2);
                if (fejIras == 1)
                {
                    coin.setImageResource(R.drawable.heads);
                    Toast.makeText(MainActivity.this, "Fej lett", Toast.LENGTH_SHORT).show();
                    vesztes++;
                    vereseg.setText("Vereség: " + String.valueOf(vesztes));
                    if (dobas == 5)
                    {
                        builderVege.show();
                    }
                }
                else
                {
                    coin.setImageResource(R.drawable.tails);
                    nyeres++;
                    Toast.makeText(MainActivity.this, "Iras lett", Toast.LENGTH_SHORT).show();
                    gyozelem.setText("Győzelem: " + String.valueOf(nyeres));
                    if (dobas == 5)
                    {
                        builderVege.setTitle("Vereség").create();
                        builderVege.show();
                    }
                    else if(nyeres == 3)
                    {
                        builderVege.setTitle("Győzelem").create();
                        builderVege.show();
                    }
                }
                dobasok.setText("Dobások: " + String.valueOf(dobas));
            }
        });



    }

    private void ujJatek()
    {
        dobas = 0;
        nyeres = 0;
        vesztes = 0;
        gyozelem.setText("Győzelem: " + String.valueOf(nyeres));
        vereseg.setText("Vereség: " + String.valueOf(vesztes));
        dobasok.setText("Dobások: " + String.valueOf(dobas));
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
        dobas = 0;
        nyeres = 0;
        vesztes = 0;
        builderVege = new AlertDialog.Builder(MainActivity.this);
        builderVege.setCancelable(false)
                .setTitle("Jatek Vege")
                .setMessage("Uj Jatek?")
                .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ujJatek();
                    }
                }).create();
    }
}