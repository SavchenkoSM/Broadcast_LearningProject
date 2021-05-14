package com.example.closeactivitieswithbroadcast.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.closeactivitieswithbroadcast.R;

public class AuthorizationActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String LOGIN = "admin";
    private static final String PASSWORD = "admin";

    private Intent intent;

    private Button enterButton;
    private EditText loginEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

        enterButton = findViewById(R.id.enterButton);
        loginEditText = findViewById(R.id.loginEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        enterButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (loginEditText.getText().toString().equals(LOGIN)
                && passwordEditText.getText().toString().equals(PASSWORD)) {
            loginEditText.setText("");
            passwordEditText.setText("");

            intent = new Intent(AuthorizationActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        } else {
            loginEditText.setText("");
            passwordEditText.setText("");
        }
    }
}