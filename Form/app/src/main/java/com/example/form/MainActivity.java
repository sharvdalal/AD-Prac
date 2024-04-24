package com.example.form;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    EditText editTextName;
    RadioGroup radioGroupGender;
    CheckBox checkBoxQualification1, checkBoxQualification2, checkBoxQualification3;
    Button buttonSubmit;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName = findViewById(R.id.editTextName);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        checkBoxQualification1 = findViewById(R.id.checkBoxQualification1);
        checkBoxQualification2 = findViewById(R.id.checkBoxQualification2);
        checkBoxQualification3 = findViewById(R.id.checkBoxQualification3);
    }
    public void handleSubmitButtonClick(View V) {
        // Retrieve user input
        String name = editTextName.getText().toString();
        // Get selected gender
        int genderId = radioGroupGender.getCheckedRadioButtonId();
        RadioButton selectedGender = findViewById(genderId);
        String gender = selectedGender.getText().toString();
        // Get qualifications
        String qualifications = "";
        if (checkBoxQualification1.isChecked()) {
            qualifications = qualifications + "Bachelor's ";
        }
        if (checkBoxQualification2.isChecked()) {
            qualifications = qualifications + "Master's ";
        }
        if (checkBoxQualification3.isChecked()) {
            qualifications = qualifications + "PhD ";
        }
        // Create an intent to pass data to DisplayActivity
        Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("gender", gender);
        intent.putExtra("qualifications", qualifications.toString());
        // Start DisplayActivity
        startActivity(intent);
    }
}