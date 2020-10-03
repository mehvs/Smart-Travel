package com.example.smarttravel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button bsignUp;
    Button bsingIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getViews();
        setOnClickListeners();
    }

    private void getViews() {
        bsignUp = findViewById(R.id.bsignUp);
        bsingIn = findViewById(R.id.bsignIn);

    }

    private void setOnClickListeners() {
        bsignUp.setOnClickListener(v -> {

            Intent registration = new Intent(this, Registration.class);
            startActivity(registration);
        });

        bsingIn.setOnClickListener(v -> {
            Intent login = new Intent(this, Login.class);
            startActivity(login);
        });
    }

}