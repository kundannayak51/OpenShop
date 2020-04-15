package com.example.openshop;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        firebaseAuth = FirebaseAuth.getInstance();
        //Show splash screen for three seconds then transfer to register activity
        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent registerIntent = new Intent(SplashActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
                finish();

            }
        }, SPLASH_TIME_OUT);*/
    }

    @Override
    protected void onStart() {
        super.onStart();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FirebaseUser currentUser = firebaseAuth.getCurrentUser();
                if(currentUser != null)
                {
                    Intent registerIntent = new Intent(SplashActivity.this, RegisterActivity.class);
                    startActivity(registerIntent);
                    finish();
                }
                else{
                    Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(mainIntent);
                    finish();
                }

            }
        }, SPLASH_TIME_OUT);
        /*if(currentUser == null)
        {
            Intent registerIntent = new Intent(SplashActivity.this, RegisterActivity.class);
            startActivity(registerIntent);
            finish();
        }
        else{
            Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(mainIntent);
            finish();
        }*/

    }
}
