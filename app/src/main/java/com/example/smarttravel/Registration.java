package com.example.smarttravel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registration extends AppCompatActivity implements View.OnClickListener {

    Button bRegister;
    EditText etEmail;
    EditText etName;
    EditText etAge;
    EditText etPassword;
    EditText etRepeatPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        getViews();
        bRegister.setOnClickListener(this);

    }

    private void getViews() {
        etEmail = findViewById(R.id.etEmail);
        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        etPassword = findViewById(R.id.etPassword);
        etRepeatPassword = findViewById(R.id.etRepeatPassword);
        bRegister = findViewById(R.id.bRegister);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bRegister:


                break;
        }
    }
}