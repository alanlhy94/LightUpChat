package com.example.lightupchat;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class newConversationActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView;
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    EditText inputBox;
    Button submit;
    static String receiverID;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_conversation);

        setNavigationViewListener();

        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        inputBox = findViewById(R.id.codeInputBox);
        submit = findViewById(R.id.codeSubmitButton);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                receiverID = inputBox.getText().toString();
                startActivity(new Intent(newConversationActivity.this, ChatActivity.class));
            }
        });

    }

    public static String getReceiverID(){
        return receiverID;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {
//            case R.id.nav_message:


            case R.id.nav_home:
                startActivity(new Intent(newConversationActivity.this, MainActivity.class));
                break;


            case R.id.nav_logout:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(newConversationActivity.this, AuthenticationActivity.class));
                finish();
                break;

            case R.id.nav_code:
                startActivity(new Intent(newConversationActivity.this, showMyCodeActivity.class));
                break;
        }
        //close navigation drawer
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setNavigationViewListener() {
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }


    @Override
    protected void onDestroy(){
        super.onDestroy();
        FirebaseAuth.getInstance().signOut();
    }
}