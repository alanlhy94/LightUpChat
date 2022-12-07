package com.example.lightupchat;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class showMyCodeActivity extends AppCompatActivity {

    TextView code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showmycode);

        code = findViewById(R.id.codeLable);
        code.setText(AuthenticationActivity.getShowID());


    }


}