package com.gohool.login.bookappointment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Calendar;

import ru.dimorinny.floatingtextbutton.FloatingTextButton;

public class Doctor2 extends AppCompatActivity {

    ImageView back_btn;

    RadioGroup time;
    Button book_appointment;

    EditText date;
    DatePickerDialog.OnDateSetListener setListener;

    int year;
    int month;
    int day;

    FloatingTextButton call, msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor2);

        back_btn = (ImageView) findViewById(R.id.back_btn);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Doctor2.this, "Back", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Doctor2.this, Doctor.class);
                startActivity(i);

            }
        });

        time = (RadioGroup)findViewById(R.id.time);



        date = (EditText) findViewById(R.id.date);
        Calendar calendar = Calendar.getInstance();
        final int y = calendar.get(Calendar.YEAR);
        final int m = calendar.get(Calendar.MONTH);
        final int d = calendar.get(Calendar.DAY_OF_MONTH);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        Doctor2.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month + 1;
                        String mydate = dayOfMonth + "/" + month + "/" + year;
                        date.setText(mydate);
                    }
                }, y, m, d);
                datePickerDialog.show();
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
                if (ActivityCompat.checkSelfPermission(Doctor2.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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



        book_appointment = (Button) findViewById(R.id.book_appointment);
        book_appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aDate= date.getText().toString();
                if(aDate.matches("") || time.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please Select Date and Time",Toast.LENGTH_LONG).show();
                }
                else
                {
                    int selectedId = time.getCheckedRadioButtonId();
                    RadioButton selectedRadioButton= (RadioButton)findViewById(selectedId);
                    Toast.makeText(getApplicationContext(), "Appointment Booked on "+aDate+" in "+selectedRadioButton.getText().toString(),Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(), Doctor01.class);
                    startActivity(i);
                }
            }
        });




    }


}

