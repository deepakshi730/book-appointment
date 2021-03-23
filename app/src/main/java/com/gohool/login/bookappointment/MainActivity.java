package com.gohool.login.bookappointment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

    Button patient, doctor;
    CardView patient_cardview, doctor_cardview;

    Animation topAnimation, bottomAnimation, middleAnimation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        doctor = (Button) findViewById(R.id.doctor);
        patient = (Button) findViewById(R.id.patient);

        doctor_cardview = (CardView) findViewById(R.id.doctor_cardview);
        patient_cardview = (CardView) findViewById(R.id.patient_cardview);


        topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        middleAnimation = AnimationUtils.loadAnimation(this, R.anim.middle_animation);

        patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Doctor.class);
                startActivity(i);
            }
        });
        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   Intent i1 = new Intent(MainActivity.this, DoctorGRSingh.class);
                 startActivity(i1);
            }
        });


        doctor.setAnimation(middleAnimation);
        patient.setAnimation(bottomAnimation);
        doctor_cardview.setAnimation(topAnimation);
        patient_cardview.setAnimation(topAnimation);


        Thread mythread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(4000);// 3 second

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        });

        mythread.start();


    }

}

