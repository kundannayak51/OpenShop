package com.example.openshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.FrameLayout;

public class RegisterActivity extends AppCompatActivity {

    private FrameLayout frameLayout;

    protected static boolean onResetPasswordFragment = false;
    protected static boolean onSignUpFragment = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //getting ID of frameLayout in of design part
        frameLayout = findViewById(R.id.register_frameLaayout);

        //function to set fragment into the layout
        setDefaultFragment(new SigninFragment());
    }
    private void setDefaultFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }

    //Customizing Back Button


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK);
        {
            if(onResetPasswordFragment || onSignUpFragment) {
                onSignUpFragment = false;
                onResetPasswordFragment = false;
                setFragment(new SigninFragment());
                return false;
            }
        }
        return super.onKeyDown(keyCode,event);
    }

    private void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        //Adding slide animation
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left,R.anim.slideout_from_right);

        fragmentTransaction.replace(frameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }

}
