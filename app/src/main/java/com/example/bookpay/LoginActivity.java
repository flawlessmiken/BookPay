package com.example.bookpay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText mEmail, mPassword;
    Button login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        final Intent openIntent = new Intent(LoginActivity.this, FirstAct.class);

        mEmail = (EditText)findViewById(R.id.email);
        mPassword = (EditText)findViewById(R.id.password);
        login_button = (Button) findViewById(R.id.btn_login);



        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifyUser(openIntent);
            }
        });


    }

    private void verifyUser(Intent intent) {

        String email = mEmail.getText().toString().trim();
        String password = mPassword.getText().toString().trim();

        if (!(email.isEmpty() || (password.isEmpty()))) {

            if (email.equals("droidsmike@gmail.com") && password.equals("mmepay")) {
                startActivity(intent);
            }
            else{
                Toast.makeText(this, "wrong Email or Password", Toast.LENGTH_SHORT).show();
            }

        }
        else{
            Toast.makeText(this, "Enter Email and Password", Toast.LENGTH_SHORT).show();
        }
    }
}
