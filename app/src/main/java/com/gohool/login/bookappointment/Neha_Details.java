package com.gohool.login.bookappointment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import ru.dimorinny.floatingtextbutton.FloatingTextButton;

public class Neha_Details extends AppCompatActivity {

    RadioGroup request;
    RadioButton accept, reject;
    ImageView back_btn;
    FloatingTextButton call, msg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neha__details);

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

        back_btn = (ImageView) findViewById(R.id.back_btn);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Back", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), DoctorGRSingh.class);
                startActivity(i);

            }
        });

        call = findViewById(R.id.call);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Call", Toast.LENGTH_LONG).show();
                String phone = "8700847799";
                String s = "tel:" + phone;
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse(s));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);
            }
        });

        msg = findViewById(R.id.msg);
        msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Message",Toast.LENGTH_LONG).show();
                String phone="8700847799";
                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                intent1.putExtra("address",phone);
                intent1.putExtra("sms_body","Hi Doctor");
                intent1.setType("vnd.android-dir/mms-sms");
                startActivity(intent1);
            }
        });


    }
}
