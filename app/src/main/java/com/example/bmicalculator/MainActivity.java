package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText editWeight ,editHeight,editHeightIn;
        Button btnCaculate;
        TextView txtResult;
        LinearLayout llMain;

        editWeight = findViewById(R.id.editWeight);
        editHeight = findViewById(R.id.editHeight);
        editHeightIn = findViewById(R.id.editHeightIn);
        btnCaculate = findViewById(R.id.btnCaculate);
        txtResult = findViewById(R.id.txtResult);
        llMain = findViewById(R.id.llMain);


        btnCaculate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int wt = Integer.parseInt(editWeight.getText().toString());
                int ft = Integer.parseInt(editHeight.getText().toString());
                int in = Integer.parseInt(editHeightIn.getText().toString());

                int totalIn = ft * 12 + in;

                double totalCm = totalIn * 2.23;

                double totalM = totalCm/100;

                double bmi = wt/(totalM*totalM);

                if(bmi > 25){
                    txtResult.setText("You are Overweight !");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorOW));
                }
                else if(bmi <18){
                    txtResult.setText("You are Underweight !");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorUW));
                }
                else {
                    txtResult.setText("You are Healthy !");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorH));
                }

            }
        });


    }
}