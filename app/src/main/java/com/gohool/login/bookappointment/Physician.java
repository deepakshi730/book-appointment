package com.gohool.login.bookappointment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Physician extends AppCompatActivity {

CardView dinesh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physician);

        dinesh = (CardView) findViewById(R.id.dinesh_sharma);
        dinesh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Dinesh Sharma", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), Doctor2.class);
                startActivity(i);
            }
        });
    }
}
