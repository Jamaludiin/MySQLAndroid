package com.example.mysqlandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddActivity extends AppCompatActivity {
EditText edtextName, edtextDescription, edtextCategory;
Button btnInsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        edtextName = findViewById(R.id.edtextName);
        edtextDescription = findViewById(R.id.edtextDescription);
        edtextCategory = findViewById(R.id.edtextCategory);
        btnInsert = findViewById(R.id.btnInsert);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDtataBaseAgent myDB = new MyDtataBaseAgent(AddActivity.this);
                myDB.addProduct(edtextName.getText().toString().trim(),
                        edtextDescription.getText().toString().trim(),
                        edtextCategory.getText().toString().trim());
                finish(); // Finish the activity to return to MainActivity
            }
        });
    }
}