package com.example.database;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.room.Database;

import java.util.ArrayList;

public class adapter extends BaseAdapter {

    viewmydata viewmydata;

    ArrayList id,name,contact,pass,email;


    public adapter(com.example.database.viewmydata viewmydata, ArrayList id, ArrayList name, ArrayList contact, ArrayList pass, ArrayList email) {
        this.viewmydata=viewmydata;
        this.id=id;
        this.name=name;
        this.contact=contact;
        this.pass=pass;
        this.email=email;
    }

    @Override
    public int getCount() {
        return id.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(viewmydata).inflate(R.layout.viewmydata_item,parent,false);


        TextView tid_txt=convertView.findViewById(R.id.id_txt);
        TextView tname_txt=convertView.findViewById(R.id.name_txt);
        TextView tcontact_text=convertView.findViewById(R.id.contact_text);
        TextView tpass_text=convertView.findViewById(R.id.pass_text);
        TextView temail_text=convertView.findViewById(R.id.email_text);



        tid_txt.setText(id.get(position).toString());
        tname_txt.setText(name.get(position).toString());
        tcontact_text.setText(contact.get(position).toString());
        tpass_text.setText(pass.get(position).toString());
        temail_text.setText(email.get(position).toString());

        Button button =convertView.findViewById(R.id.delete);

        database m = new database(viewmydata);
        button.setOnClickListener(v ->
        {
            m.deletedata(id.get(position).toString());
            Intent intent=new Intent(viewmydata,viewmydata.class);
            viewmydata.startActivity(intent);
            viewmydata.finish();
        });

        Button update=convertView.findViewById(R.id.update);
        update.setOnClickListener(v -> {
            int a=1;
            Intent intent =  new Intent(viewmydata,MainActivity.class);
            intent.putExtra("id",id.get(position).toString());
            intent.putExtra("a",a);
            intent.putExtra("name",name.get(position).toString());
            intent.putExtra("contact",contact.get(position).toString());
            intent.putExtra("pass",pass.get(position).toString());
            intent.putExtra("email",email.get(position).toString());
            viewmydata.startActivity(intent);
        });

        return convertView;
    }
}
