package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText ename,econtact,epass,eemail;
    String id,name,pass,contact,email;
    TextView print;
    database m = new database(this);
    int a=0;

    database db =new database(this);
    Button submit,reset,viewdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ename=findViewById(R.id.name);
        econtact=findViewById(R.id.contact);
        epass=findViewById(R.id.pass);
        eemail=findViewById(R.id.email);
        print=findViewById(R.id.print);
        submit=findViewById(R.id.submit);
        reset=findViewById(R.id.reset);
        viewdata=findViewById(R.id.viewdata);



        a=getIntent().getIntExtra("a",0);
        if(a==1) {
            id = getIntent().getStringExtra("id");
            name = getIntent().getStringExtra("name");
            contact = getIntent().getStringExtra("contact");
            pass = getIntent().getStringExtra("pass");
            email = getIntent().getStringExtra("email");


            ename.setText(name);
            econtact.setText(contact);
            epass.setText(pass);
            eemail.setText(email);
        }
        submit.setOnClickListener(v -> {

            String name=ename.getText().toString();
            String contact=econtact.getText().toString();
            String pass=epass.getText().toString();
            String email=eemail.getText().toString();



            System.out.println("Name="+name);
            System.out.println("Contact="+contact);
            System.out.println("Password="+pass);
            System.out.println("Email="+email);

            if(a==1) {


                db.updatedata(id, name, contact, pass, email);
                Intent intent =  new Intent(MainActivity.this,viewmydata.class);
                startActivity(intent);

                ename.setText("");
                econtact.setText("");
                epass.setText("");
                eemail.setText("");
                print.setText("");

            }
            else
            {
                print.setText("Thank You!!!");
                m.insertdata(name, contact, pass, email);
                ename.setText("");
                econtact.setText("");
                epass.setText("");
                eemail.setText("");

            }

        });

        reset.setOnClickListener(v -> {

            ename.setText("");
            econtact.setText("");
            epass.setText("");
            eemail.setText("");
            print.setText("");
        });


        viewdata.setOnClickListener(v -> {
            Intent intent =  new Intent(MainActivity.this,viewmydata.class);
            startActivity(intent);
        });


    }
}