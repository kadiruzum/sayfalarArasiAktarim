package com.kadir.verisakla;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class calculator extends AppCompatActivity {

    EditText firstNumber;
    EditText secondNumber;
    TextView textView;
    TextView textViewIntent;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        firstNumber = findViewById(R.id.editTextTextPersonName);
        secondNumber = findViewById(R.id.editTextTextPersonName2);
        textView = findViewById(R.id.textView2);
        textViewIntent = findViewById(R.id.textView3);

        Intent intent = getIntent();
        String username = intent.getStringExtra("userAge");
        textViewIntent.setText("Your age: " + username);
    }

    @SuppressLint("SetTextI18n")
    public void topla(View view) {
        if(firstNumber.getText().toString().matches("") || secondNumber.getText().toString().matches("")) {
            textView.setText("Write number!");
        } else {
            int result = Integer.parseInt(firstNumber.getText().toString()) + Integer.parseInt(secondNumber.getText().toString());
            textView.setText("Result: "+ result);
        }
    }

    @SuppressLint("SetTextI18n")
    public void cikart(View view) {
        if(firstNumber.getText().toString().matches("") || secondNumber.getText().toString().matches("")) {
            textView.setText("Write number!");
        } else {
            int result = Integer.parseInt(firstNumber.getText().toString()) - Integer.parseInt(secondNumber.getText().toString());
            textView.setText("Result: "+ result);

        }
    }

    @SuppressLint("SetTextI18n")
    public void carp(View view) {
        if(firstNumber.getText().toString().matches("") || secondNumber.getText().toString().matches("")) {
            textView.setText("Write number!");
        } else {
            int result = Integer.parseInt(firstNumber.getText().toString()) * Integer.parseInt(secondNumber.getText().toString());
            textView.setText("Result: "+ result);

        }
    }

    @SuppressLint("SetTextI18n")
    public void bol(View view) {
        if(firstNumber.getText().toString().matches("") || secondNumber.getText().toString().matches("")) {
            textView.setText("Write number!");
        } else {
            int result = Integer.parseInt(firstNumber.getText().toString()) / Integer.parseInt(secondNumber.getText().toString());
            textView.setText("Result: "+ result);
        }
    }

    public void returnMainMenu(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}