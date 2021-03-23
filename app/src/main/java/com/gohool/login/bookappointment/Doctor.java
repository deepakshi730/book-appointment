package com.gohool.login.bookappointment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class Doctor extends AppCompatActivity {

    ListView listView;
    String[] name;
    int[] img;
    String[] speciality;
    ArrayList<DoctorName> arrayList = new ArrayList<DoctorName>();
    ListViewAdapter adapter;
    LinearLayout dentist, cardiologist, dermatologist, eyespecialist, physician;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);


        dentist = (LinearLayout) findViewById(R.id.dentist);
        cardiologist = (LinearLayout) findViewById(R.id.cardiologist);
        dermatologist = (LinearLayout) findViewById(R.id.dermatologist);
        eyespecialist = (LinearLayout) findViewById(R.id.eyespecilist);
        physician = (LinearLayout) findViewById(R.id.physician);

        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Doctor.this, Dentist.class);
                startActivity(i);
            }
        });

        cardiologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Doctor.this, Cardiologist.class);
                startActivity(i);
            }
        });

        dermatologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Doctor.this, Dermatologist.class);
                startActivity(i);
            }
        });

        eyespecialist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Doctor.this, EyeSpecialist.class);
                startActivity(i);
            }
        });

        physician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Doctor.this, Physician.class);
                startActivity(i);
            }
        });



        name = new String[]{"G.R Singh", "Seema Sharma", "Shashi Sharma","Suresh Singh", "Dinesh Sharma"};
        speciality = new String[]{"Eye Specialist","Dermatologist","Dentist","Cardiologist","Physician"};
        img = new int[]{R.drawable.male, R.drawable.female, R.drawable.female, R.drawable.male, R.drawable.male};


        listView = (ListView) findViewById(R.id.categories_listview);

        for (int i=0; i<name.length; i++)
        {
            DoctorName itemsModel = new DoctorName(name[i],img[i],speciality[i]);
            arrayList.add(itemsModel);
        }

        adapter = new ListViewAdapter(this, arrayList);
        listView.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem menuItem = menu.findItem(R.id.search_view);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(TextUtils.isEmpty(newText))
                {
                    adapter.filter("");
                    listView.clearTextFilter();
                }
                else {
                    adapter.filter(newText);
                }
                return true;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id =item.getItemId();
        if(id==R.id.search_view)
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
