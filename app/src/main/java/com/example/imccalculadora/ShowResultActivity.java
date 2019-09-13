package com.example.imccalculadora;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;

public class ShowResultActivity extends AppCompatActivity {
    private static DecimalFormat df = new DecimalFormat("0.00");
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_name);


        Button btnVoltar = findViewById(R.id.btnVoltar);
        TextView resultTextView = (TextView) findViewById(R.id.result);

        float weight = (Float) Float.parseFloat(getIntent().getStringExtra("WEIGHT"));
        float height = (Float) Float.parseFloat(getIntent().getStringExtra("HEIGHT"));

        float result = weight / (height * height);

        if (result < 18.5) {
            resultTextView.setText("Seu IMC é " + df.format(result) + ". Está abaixo do peso!");
        } else if (result > 18.6 && result < 24.9) {
            resultTextView.setText("Seu IMC é " + df.format(result) + ". Está com o peso ideal.");
        } else if (result > 25.0 && result < 29.9) {
            resultTextView.setText("Seu IMC é " + df.format(result) + ". Está levemente acima do peso.");
        } else if (result > 30.0 && result < 34.9) {
            resultTextView.setText("Seu IMC é " + df.format(result) + ". Está com obesidade grau I.");
        } else if (result > 35.0 && result < 39.9) {
            resultTextView.setText("Seu IMC é " + df.format(result) + ". Está com obesidade grau II (severa).");
        } else {
            resultTextView.setText("Seu IMC é " + df.format(result) + ". Está com obesidade III (mórbida).");
        }
        btnVoltar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);


            }
        });

    }
}
