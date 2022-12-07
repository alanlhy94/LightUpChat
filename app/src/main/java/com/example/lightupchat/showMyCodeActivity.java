package com.example.lightupchat;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class showMyCodeActivity extends AppCompatActivity {

    TextView code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showmycode);

        code = findViewById(R.id.codeLable);
        code.setText(Integer.toString(AuthenticationActivity.getShowID()));


    }




}