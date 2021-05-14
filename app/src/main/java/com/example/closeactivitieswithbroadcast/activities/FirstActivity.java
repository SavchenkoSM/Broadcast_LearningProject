package com.example.closeactivitieswithbroadcast.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.closeactivitieswithbroadcast.R;
import com.example.closeactivitieswithbroadcast.common.BroadcastReceiverWorker;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        new BroadcastReceiverWorker(this);
    }
}