package com.gohool.login.bookappointment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class DoctorGRSingh extends AppCompatActivity {


    LinearLayout neha_request;
    RadioGroup request;
    RadioButton accept, reject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_g_r_singh);


        neha_request = (LinearLayout) findViewById(R.id.neha_request);
        request = (RadioGroup) findViewById(R.id.request);
        accept = (RadioButton) findViewById(R.id.accept);
        reject= (RadioButton) findViewById(R.id.reject);

        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), " Appointment Accepted", Toast.LENGTH_SHORT).show();
            }
        });
        reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), " Appointment Rejected", Toast.LENGTH_SHORT).show();
            }
        });

        neha_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Neha_Details.class);
                startActivity(i);
            }
        });

    }
}
