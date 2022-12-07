package com.example.lightupchat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.lightupchat.databinding.ActivityAuthenticationBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AuthenticationActivity extends AppCompatActivity {

    ActivityAuthenticationBinding binding;
    String name,email,password;
    DatabaseReference databaseReference;
    int randID, randPassword;
    static int showID=0;
    String mailDomain = "@lightupapp.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAuthenticationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseReference = FirebaseDatabase.getInstance().getReference("users");

        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //email=binding.textEmail.getText().toString();
                //password=binding.textPassword.getText().toString();



                //login();
                signUp();
            }
        });
        binding.signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                accountGenerate();

                //name=binding.textName.getText().toString();
                email=randID+mailDomain;
                password=Integer.toString(randPassword);


                binding.textEmail.setText(Integer.toString(randID));


            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(FirebaseAuth.getInstance().getCurrentUser()!=null){
            startActivity(new Intent(AuthenticationActivity.this, newConversationActivity.class));
            finish();
        }
    }

    public static int getShowID(){
        return showID;
    }
    private void accountGenerate(){
        RandomGenerate userID = new RandomGenerate();
        userID.generate();
        randID = userID.getRand();
        showID = randID;

        RandomGenerate userPassword = new RandomGenerate();
        userPassword.generate();
        randPassword = userPassword.getRand();

    }

    /*private void login(){
        FirebaseAuth
                .getInstance()
                .signInWithEmailAndPassword(email.trim(),password)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        startActivity(new Intent(AuthenticationActivity.this, MainActivity.class));
                        finish();
                    }
                });
    }*/

    private void signUp(){
        FirebaseAuth
                .getInstance()
                .createUserWithEmailAndPassword(email.trim(),password)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        //UserProfileChangeRequest userProfileChangeRequest = new UserProfileChangeRequest.Builder().setDisplayName(name).build();
                        //FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                        //firebaseUser.updateProfile(userProfileChangeRequest);
                        UserModel userModel = new UserModel(FirebaseAuth.getInstance().getUid(),name,email,password);
                        databaseReference.child(FirebaseAuth.getInstance().getUid()).setValue(userModel);
                        startActivity(new Intent(AuthenticationActivity.this, newConversationActivity.class));
                        finish();
                    }
                });
    }

    @Override
    protected void onStop(){
        super.onStop();
        FirebaseAuth.getInstance().signOut();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        FirebaseAuth.getInstance().signOut();
    }
}