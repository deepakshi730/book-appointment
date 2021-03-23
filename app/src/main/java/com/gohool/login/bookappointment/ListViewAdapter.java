package com.gohool.login.bookappointment;


import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {

    Context mcontext;
    LayoutInflater inflater;
    List<DoctorName> itemsModels;
    ArrayList<DoctorName> arrayList;

    public ListViewAdapter(Context context, List<DoctorName> itemsModels) {
        mcontext = context;
        this.itemsModels = itemsModels;
        inflater = LayoutInflater.from(context);
        this.arrayList = new ArrayList<DoctorName>();
        this.arrayList.addAll(itemsModels);
    }

    public  class ViewHolder{
        TextView name;
        ImageView img;
        TextView speciality;
    }

    @Override
    public int getCount() {
        return itemsModels.size();
    }

    @Override
    public Object getItem(int position) {
        return itemsModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.doctor_categories,null);

            holder.name = convertView.findViewById(R.id.doctor_name);
            holder.img = convertView.findViewById(R.id.doctor_image);
            holder.speciality = convertView.findViewById(R.id.doctor_speciality);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.name.setText(itemsModels.get(position).getName());
        holder.img.setImageResource(itemsModels.get(position).getImg());
        holder.speciality.setText(itemsModels.get(position).getSpeciality());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(itemsModels.get(position).getName().equals("G.R Singh"))
                {
                    Toast.makeText(mcontext, "G.R Singh", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(mcontext, Doctor01.class);
                    mcontext.startActivity(i);
                }
                if(itemsModels.get(position).getName().equals("Dinesh Sharma"))
                {
                    Toast.makeText(mcontext, "Dinesh Sharma", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(mcontext, Doctor2.class);
                    mcontext.startActivity(i);
                }
            }
        });

        return convertView;
    }

    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        itemsModels.clear();
        if(charText.length()==0){
            itemsModels.addAll(arrayList);
        }
        else {
            for(DoctorName itemsModel : arrayList){
                if(itemsModel.getName().toLowerCase(Locale.getDefault()).contains(charText)){
                    itemsModels.add(itemsModel);
                }
            }
        }
        notifyDataSetChanged();
    }
}
