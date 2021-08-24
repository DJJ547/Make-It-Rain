package com.example.makeitrain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private Button makeItRain;
    private Button showInfo;
    private TextView moneyValue;
    private int moneyCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        makeItRain = findViewById(R.id.buttonMakeItRain);
        showInfo = findViewById(R.id.buttonShowInfo);
        moneyValue = findViewById(R.id.moneyValue);

//        makeItRain.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d("mainActivity", "onClick: Make it rain");
//            }
//        });

        //we also can use lambda expression
        //makeItRain.setOnClickListener(view -> Log.d("mainActivity", "onClick: Make it rain"));
    }

    public void showMoney(View view) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();

        moneyCounter += 1000;
        //moneyValue.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.red));
        if(moneyCounter < 10000) {
            moneyValue.setTextColor(Color.RED);
        }else if(moneyCounter <20000) {
            moneyValue.setTextColor(Color.BLUE);
        }else if(moneyCounter <20000) {
            moneyValue.setTextColor(Color.GREEN);
        }else if(moneyCounter <30000) {
            moneyValue.setTextColor(Color.CYAN);
        }else{
            moneyValue.setTextColor(Color.WHITE);
        }

        moneyValue.setText(String.valueOf(numberFormat.format(moneyCounter)));
        Log.d("MIR", "onClick: Make it rain" + moneyCounter);
    }

    public void showInfo(View view) {
        //Toast.makeText(MainActivity.this, R.string.app_info, Toast.LENGTH_SHORT).show();
        Snackbar.make(moneyValue, R.string.app_info, Snackbar.LENGTH_LONG)
                .setAction("More", view1 -> {
                    Log.d("Snack", "showInfo: Snackbar More");
                })
                .show();
    }
}