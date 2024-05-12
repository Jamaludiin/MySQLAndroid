package com.example.mysqlandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private Button btnAddRecord, btnDeleteRecord, btnViewRecord, btnUpdateRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddRecord = findViewById(R.id.btnAddRecord);
        btnDeleteRecord = findViewById(R.id.btnDeleteRecord);
        btnViewRecord = findViewById(R.id.btnViewRecord);
        btnUpdateRecord = findViewById(R.id.btnUpdateRecord);


        btnViewRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startViewRecord = new Intent(MainActivity.this, ViewRecordActivity.class);
                startActivity(startViewRecord);
            }
        });

        btnAddRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startAddActivity = new Intent(MainActivity.this, AddActivity.class);
                startActivity(startAddActivity);
            }
        });
    }
}