package com.example.imccalculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bntCalculate = (Button) findViewById(R.id.bntCalculateId);

        bntCalculate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                EditText weightEditText = (EditText) findViewById(R.id.weight);
                EditText heightEditText = (EditText) findViewById(R.id.height);

                if(weightEditText.getText().length() == 0 || heightEditText.getText().length() == 0)
                    Toast.makeText(getApplicationContext(), "Por favor, preencha o campo vazio.", Toast.LENGTH_SHORT).show();
                else {

                    float weight = (Float) Float.parseFloat(weightEditText.getText().toString());
                    float height = (Float) Float.parseFloat(heightEditText.getText().toString());

                    if (weight == 0 || height == 0.0)
                        Toast.makeText(getApplicationContext(), "Por favor, insira valores válidos", Toast.LENGTH_SHORT).show();
                    else{

                        Intent intent = new Intent(getBaseContext(), ShowResultActivity.class);
                        intent.putExtra("WEIGHT", Float.toString(weight));
                        intent.putExtra("HEIGHT", Float.toString(height));
                        startActivity(intent);
                    }
                }
            }
        });
    }

}
