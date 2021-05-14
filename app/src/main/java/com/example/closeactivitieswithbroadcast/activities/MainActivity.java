package com.example.closeactivitieswithbroadcast.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.closeactivitieswithbroadcast.R;
import com.example.closeactivitieswithbroadcast.common.BroadcastReceiverWorker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button goToFirstActivityButton, goToSecondActivityButton, goToThirdActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new BroadcastReceiverWorker(this);

        goToFirstActivityButton = findViewById(R.id.goToFirstActivityButton);
        goToSecondActivityButton = findViewById(R.id.goToSecondActivityButton);
        goToThirdActivityButton = findViewById(R.id.goToThirdActivityButton);

        goToFirstActivityButton.setOnClickListener(this);
        goToSecondActivityButton.setOnClickListener(this);
        goToThirdActivityButton.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.goToFirstActivityButton:
                startActivity(new Intent(MainActivity.this, FirstActivity.class));
                break;
            case R.id.goToSecondActivityButton:
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
                break;
            case R.id.goToThirdActivityButton:
                startActivity(new Intent(MainActivity.this, ThirdActivity.class));
                break;
        }
    }
}