package com.example.taruc.lab2project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Main extends AppCompatActivity {

    private EditText editTextWeight, editTextHeight;
    private TextView textViewResult;
    private ImageView imageViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Linking UI to program
        editTextWeight = (EditText)findViewById(R.id.editTextWeight);
        editTextHeight = (EditText)findViewById(R.id.editTextHeight);
        imageViewResult = (ImageView)findViewById(R.id.imageViewResult);
        textViewResult = (TextView)findViewById(R.id.bmiResult);

    }

    public void calculateBMI(View view)
    {
        double weight, height, bmi;
        weight = Double.parseDouble(editTextWeight.getText().toString());
        height = Double.parseDouble(editTextHeight.getText().toString());

        height = Math.pow((height/100),2);
        bmi = weight/height;
        bmi = Double.parseDouble(String.format("%.2f", bmi));
        if(bmi <= 18.5)
        {
            textViewResult.setText("You are under-weight! Your BMI result is "+bmi);
            imageViewResult.setImageResource(R.drawable.under);
        }
        else if(bmi >= 21)
        {
            textViewResult.setText("You are overweight! Your BMI result is "+bmi);
            imageViewResult.setImageResource(R.drawable.over);
        }
        else {
            textViewResult.setText("You are normal. Your BMI result is "+bmi);
            imageViewResult.setImageResource(R.drawable.normal);
        }
    }

    public void resetAll(View view)
    {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}
