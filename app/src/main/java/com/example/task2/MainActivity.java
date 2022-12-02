package com.example.task2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView dollarTV, egpTV;
    EditText dollarEDT, egpEDT;
    Button convertBTN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dollarTV = findViewById(R.id.dollarValRV);
        egpTV = findViewById(R.id.egpValTV);
        dollarEDT = findViewById(R.id.dollarEDT);
        egpEDT = findViewById(R.id.egpEDT);
        convertBTN = findViewById(R.id.convertBTN);

        convertBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dollarEDT.getText().toString().equals("") && !(egpEDT.getText().toString().equals(""))){
                    int pound = Integer.parseInt(egpEDT.getText().toString());
                    Float convertedPound = convertEgpToDollar(pound);

                    egpTV.setText(String.valueOf(pound));
                    dollarTV.setText(String.valueOf(convertedPound));
                }
                else if (!(dollarEDT.getText().toString().equals("")) && (egpEDT.getText().toString().equals(""))) {
                    int dollar = Integer.parseInt(dollarEDT.getText().toString());
                    Float convertedDollar = convertDollarToPound(dollar);
                    egpTV.setText(String.valueOf(convertedDollar));
                    dollarTV.setText(String.valueOf(dollar));
                }
                else
                    Toast.makeText(MainActivity.this, "please a field to convert", Toast.LENGTH_SHORT).show();

            }


        });
    }

    private Float convertEgpToDollar(int pound){
        return pound / 25f;
    }

    private Float convertDollarToPound(int dollar){
        return dollar * 25f;
    }
}