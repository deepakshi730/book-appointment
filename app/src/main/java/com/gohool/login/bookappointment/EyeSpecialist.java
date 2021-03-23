package com.gohool.login.bookappointment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class EyeSpecialist extends AppCompatActivity {

    CardView gr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eye_specialist);

        gr = (CardView) findViewById(R.id.gr_singh);
        gr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "G.R Singh", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), Doctor01.class);
                startActivity(i);
            }
        });

    }
}
