package com.example.smarttravel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener{

    private EditText etEmail;
    private EditText etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getViews();
        btnLogin.setOnClickListener(this);
    }

    private void getViews() {
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassWord);
        btnLogin = findViewById(R.id.btnLogin);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:
                onLoginClicked();
                break;
        }
    }

    private void onLoginClicked() {
        String email = etEmail.getText().toString();
        String pass = etPassword.getText().toString();

        LoginManager loginManager = new LoginManager();
        boolean isLogged = loginManager.login(email, pass, this);

        String message = isLogged ? "Success" : "Failed";
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        if (isLogged) {
            Intent login = new Intent(this, SaveDestinatons.class);
            startActivity(login);
        }
    }
}