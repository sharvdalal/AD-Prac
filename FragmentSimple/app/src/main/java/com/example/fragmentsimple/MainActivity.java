package com.example.fragmentsimple;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements PinkFragment.OnMessageSentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new BlueFragment())
                .commit();
    }

    @Override
    public void onMessageSent(String message) {
        BlueFragment blueFragment = (BlueFragment) getSupportFragmentManager().findFragmentById(R.id.container);
        if (blueFragment != null) {
            blueFragment.displayMessage(message);
        }
    }
}