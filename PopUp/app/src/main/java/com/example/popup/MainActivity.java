package com.example.popup;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    TextView selectedTv;
    Button showMenuBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        selectedTv = findViewById(R.id.selectedTv);
        showMenuBtn = findViewById(R.id.showMenuBtn);


        PopupMenu popupMenu = new PopupMenu(
                this,
                showMenuBtn
        );

        popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                int id = menuItem.getItemId();


                if(id == R.id.menu_copy){
                    selectedTv.setText("Copy Clicked");
                }
                else if(id == R.id.menu_share){
                    selectedTv.setText("Share Clicked");
                }

                else if(id == R.id.menu_save){
                    selectedTv.setText("Save Clicked");
                }

                else if(id == R.id.menu_delete){

                    selectedTv.setText("Delete Clicked");

                }

                return false;
            }
        });

        showMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupMenu.show();
            }
        });

    }


}