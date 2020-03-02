package com.example.rcc65;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // declare all elements from the xml
    Button btn_login;
    EditText edusername, edpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // creates activity in memory
        setContentView(R.layout.activity_main); // java and xml connected

        // connect btn_login here to the other one
        // here searches in the activity main connected in the
        btn_login = findViewById(R.id.btn_login);
        edusername = findViewById(R.id.ed_username);
        edpassword = findViewById(R.id.ed_password);

        // when I click the button >> do stuff
        // click method
        // when I click you > listen
        // create on click listner >> write code inside the listner
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // code that happens when you fire the event
                // Intent class to route
                // implicit (app to another appication) and explicit (app to app)
                // here we try the explicit one
                // <our page>.this , <other page>.class
                // package context >> shows on its own
                if(edusername.getText().toString().isEmpty()){
                    edusername.setError("Enter Username");
                }else if(edpassword.getText().toString().isEmpty()){
                    edpassword.setError("Enter password");
                }else{
                    Intent go = new Intent(MainActivity.this, SecondActivity.class);
                    // bundle is for the sending data to the next activity (second activity)
                    // we send data in a key, value data-structure
                    Bundle bndl = new Bundle();
                    // put the data in the bundle
                    bndl.putString("username", edusername.getText().toString());
                    bndl.putString("password", edpassword.getText().toString());
                    // move the data with Intent go
                    go.putExtras(bndl);
                    // start the process
                    startActivity(go);
                }

            }
        });

    }
}
