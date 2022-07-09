package com.kadir.verisakla;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText getAge;
    TextView textView;
    SharedPreferences sharedPreferences;
    String userAge;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getAge = findViewById(R.id.getAge);
        textView = findViewById(R.id.textView);

        sharedPreferences = this.getSharedPreferences("com.kadir.verisakla", Context.MODE_PRIVATE);

        Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();

        int storedAge = sharedPreferences.getInt("storedAge", 0);

        if(storedAge == 0) {
            textView.setText("Your age: ");
        } else {
            textView.setText("Your age: " + storedAge);
        }

    }

    @SuppressLint("SetTextI18n")
    public void button(View view) {
        if (getAge.getText().toString().matches("")) {
            textView.setText("Error!");
        } else {
            int userAge = Integer.parseInt(getAge.getText().toString());
            textView.setText("Your age:" + userAge);

            sharedPreferences.edit().putInt("storedAge", userAge).apply();
        }
    }

    public void saveButton(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("Save");
        alert.setMessage("Are you sure?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //save
                Toast.makeText(MainActivity.this, "Saved!", Toast.LENGTH_SHORT).show();

            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // we can use getApplicationContext instead of MainActivity.this
                Toast.makeText(MainActivity.this, "not saved!!", Toast.LENGTH_SHORT).show();
            }
        });

        alert.show();
    }

    public void changeScreen(View view) {
        Intent intent = new Intent(getApplicationContext(), calculator.class);
        userAge = getAge.getText().toString();
        intent.putExtra("userAge", userAge);

        startActivity(intent);
    }
}


