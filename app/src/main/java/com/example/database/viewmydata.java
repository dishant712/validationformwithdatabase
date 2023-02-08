package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class viewmydata extends AppCompatActivity
{

    database m =new database(this);

    ListView listView;
    Button update;
    ArrayList id,name,contact,pass,email;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewmydata);

            listView=findViewById(R.id.list);





            id=getIntent().getIntegerArrayListExtra("id");
            name=getIntent().getStringArrayListExtra("name");
            contact=getIntent().getStringArrayListExtra("contact");
            pass=getIntent().getStringArrayListExtra("pass");
            email=getIntent().getStringArrayListExtra("email");

            id=new ArrayList();
            name= new ArrayList();
            contact= new ArrayList();
            pass= new ArrayList();
            email= new ArrayList();

            Cursor c=m.getdata();
            while (c.moveToNext())
            {
                id.add(c.getInt(0));
                name.add(c.getString(1));
                contact.add(c.getString(2));
                pass.add(c.getString(3));
                email.add(c.getString(4));

            }


            adapter adapter=new adapter(this,id,name,contact,pass,email);
            listView.setAdapter(adapter);

     }
    }
