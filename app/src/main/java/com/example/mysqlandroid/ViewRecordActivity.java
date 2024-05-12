package com.example.mysqlandroid;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewRecordActivity extends AppCompatActivity {

    private RecyclerView recyclerView1;
    private Button btnAdd;

    MyDtataBaseAgent DBMS;
    ArrayList<String> prid, prname, prdescription,prcategory;

    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_record);

        recyclerView1 = findViewById(R.id.recyclerView1);
        //btnAdd = findViewById(R.id.btnAdd);

        DBMS = new MyDtataBaseAgent(ViewRecordActivity.this);
        //DBMS = new MyDtataBaseAgent(MainActivity.this);

        prid = new ArrayList<>();
        prname = new ArrayList<>();
        prdescription = new ArrayList<>();
        prcategory = new ArrayList<>();
        storeDataInArrays();

        customAdapter = new CustomAdapter(ViewRecordActivity.this,prid,prname,prdescription,prcategory);
        recyclerView1.setAdapter(customAdapter);
        recyclerView1.setLayoutManager(new LinearLayoutManager(ViewRecordActivity.this));

        /*btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }

        });*/

    }

    //OUTSIDE METHODS DECLARED
    void storeDataInArrays(){
        Cursor cursor = DBMS.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(ViewRecordActivity.this, "Record Not Found", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                prid.add(cursor.getString(0));
                prname.add(cursor.getString(1));
                prdescription.add(cursor.getString(2));
                prcategory.add(cursor.getString(3));

            }
        }
    }
}