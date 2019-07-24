package com.example.bookpay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FirstAct extends AppCompatActivity {

    private Button mButtonMme540;
    private Button mButtonMme545;
    private Button mButtonMme552;
    private Button mButtonMme582;
    private  Button mButtonItdefenceFee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        setUpViews();


    }

    private void setUpViews(){
        mButtonMme540 = (Button)findViewById(R.id.button_mme540);
        mButtonMme545 = (Button)findViewById(R.id.button_mme545);
        mButtonMme552= (Button)findViewById(R.id.button_mme552);
        mButtonMme582 = (Button)findViewById(R.id.button_mme582);
        mButtonItdefenceFee = (Button)findViewById(R.id.button_it_def);






        mButtonMme540.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivityWithList(mButtonMme540.getTag().toString());
            }
        });

        mButtonMme545.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivityWithList(mButtonMme545.getTag().toString());
            }
        });

        mButtonMme552.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivityWithList(mButtonMme552.getTag().toString());
            }
        });
        mButtonMme582.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivityWithList(mButtonMme582.getTag().toString());
            }
        });

        mButtonItdefenceFee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivityWithList(mButtonItdefenceFee.getTag().toString());
            }
        });
    }


    private void openMainActivityWithList(String courseTag){
        Intent intent = new Intent(FirstAct.this,MainActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT,courseTag);
        startActivity(intent);
    }
}
