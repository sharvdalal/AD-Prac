package com.example.form;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
public class DisplayActivity extends AppCompatActivity {
    TextView textViewData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        textViewData = findViewById(R.id.Data);
        // Get data from Intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String gender = intent.getStringExtra("gender");
        String qualifications = intent.getStringExtra("qualifications");
        // Display the data
        textViewData.setText("Name: " + name + "\nGender: " + gender +
                "\nQualifications: " + qualifications);
    }
}