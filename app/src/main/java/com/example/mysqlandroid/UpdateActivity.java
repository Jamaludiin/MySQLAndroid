package com.example.mysqlandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class UpdateActivity extends AppCompatActivity {

    EditText edtextName2, edtextDescription2, edtextCategory2;
    Button btnUpdate;
    String prd_id, prd_name, prd_description, prd_category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        edtextName2 = findViewById(R.id.edtextName2);
        edtextDescription2 = findViewById(R.id.edtextDescription2);
        edtextCategory2 = findViewById(R.id.edtextCategory2);
        btnUpdate = findViewById(R.id.btnUpdate);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyDtataBaseAgent myDBMS = new MyDtataBaseAgent(UpdateActivity.this);

                // Retrieve updated values from EditText fields
                String updatedName = edtextName2.getText().toString().trim();
                String updatedDescription = edtextDescription2.getText().toString().trim();
                String updatedCategory = edtextCategory2.getText().toString().trim();

                // Call updateRecord method with updated values
                myDBMS.updateRecord(prd_id, updatedName, updatedDescription, updatedCategory);
            }
        });

        getAndSetIntentData();


    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("prd_id") && getIntent().hasExtra("prd_name")
                && getIntent().hasExtra("prd_description") && getIntent().hasExtra("prd_category")){
            // get the data from intent
            prd_id = getIntent().getStringExtra("prd_id");
            prd_name = getIntent().getStringExtra("prd_name");
            prd_description = getIntent().getStringExtra("prd_description");
            prd_category = getIntent().getStringExtra("prd_category");

            // set the data to the intent
            edtextName2.setText(prd_name);
            edtextDescription2.setText(prd_description);
            edtextCategory2.setText(prd_category);

        }else {
            Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
        }
    }
}