package com.example.openshop;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import static com.example.openshop.RegisterActivity.setSignUpFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private static final int HOME_FRAGMENT = 0;
    private static final int CART_FRAGMENT = 1;
    private static final int ORDERS_FRAGMENT = 2;
    private static final int WISHLIST_FRAGMENT = 3 ;
    private static final int ACCOUNT_FRAGMENT = 4;
    public static Boolean showCart = false;

    private AppBarConfiguration mAppBarConfiguration;
    private FrameLayout frameLayout;
    private ImageView actionBarLogo;

    private int currentFragment = -1;

    private NavigationView navigationView;
    //private DrawerLayout drawer;

    // For actions on items in MenuBar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.main_search_icon){
            //Code for search icon
            return true;

        }else if(id == R.id.main_notification_icon) {
            //code for notification icon
            return true;
        }else if(id == R.id.main_cart_icon) {
            //code for cart icon
            final Dialog signInDialog = new Dialog(MainActivity.this);
            signInDialog.setContentView(R.layout.sign_in_dialog);
            //when user click anywhere else on the screen this dialog should cancelled
            signInDialog.setCancelable(true);
            signInDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);

            Button dialogSignInBtn = signInDialog.findViewById(R.id.sign_in_dialog_btn);
            Button dialogSignUpBtn = signInDialog.findViewById(R.id.sign_up_dialog_btn);
            final Intent registerIntent = new Intent(MainActivity.this,RegisterActivity.class);

            dialogSignInBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    signInDialog.dismiss();
                    setSignUpFragment = false;
                    startActivity(registerIntent);
                }
            });

            dialogSignUpBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    signInDialog.dismiss();
                    setSignUpFragment = true;
                    startActivity(registerIntent);
                }
            });
            signInDialog.show();

           // gotoFragment("My Cart",new MyCartFragment(),CART_FRAGMENT);
            return true;
        }else if(id == android.R.id.home){
            if(showCart){
                showCart = false;
                finish();
                return true;
            }
        }


        return super.onOptionsItemSelected(item);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        actionBarLogo = findViewById(R.id.actionbar_logo);
        setSupportActionBar(toolbar);



        navigationView = (NavigationView)findViewById(R.id.nav_view);


        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navigationView, navController);

        navigationView.setNavigationItemSelectedListener(this);
        //to make first item in navigation bar checked by default
        navigationView.getMenu().getItem(0).setChecked(true);

        frameLayout = findViewById(R.id.nav_host_fragment);

        if(showCart){
            //drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            gotoFragment("My Cart",new MyCartFragment(),-2);
        }else{
            //on create HomePage Fragment is set
            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            // Passing each menu ID as a set of Ids because each
            // menu should be considered as top level destinations.
            mAppBarConfiguration = new AppBarConfiguration.Builder(
                    R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                    R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                    .setDrawerLayout(drawer)
                    .build();
            NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);

            setFragment(new HomePageFragment(),HOME_FRAGMENT);
        }


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            if(currentFragment == HOME_FRAGMENT){
                currentFragment = -1;
                super.onBackPressed();
            }else{
                if(showCart){
                    showCart=false;
                    finish();
                }else {
                    actionBarLogo.setVisibility(View.VISIBLE);
                    invalidateOptionsMenu();
                    setFragment(new HomePageFragment(), HOME_FRAGMENT);
                    navigationView.getMenu().getItem(0).setChecked(true);
                }

            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if(currentFragment == HOME_FRAGMENT){
            getSupportActionBar().setDisplayShowTitleEnabled(false);

            getMenuInflater().inflate(R.menu.main, menu);

        }
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        //Handle navigation view Item clicks here.

        int id = item.getItemId();

        item.setChecked(true);


        if(id == R.id.nav_open_shop){
            //Hiding title and showing logo
            actionBarLogo.setVisibility(View.VISIBLE);
            invalidateOptionsMenu();
            setFragment(new HomePageFragment(), HOME_FRAGMENT);

        }else if(id == R.id.nav_my_orders){
            gotoFragment("My Orders",new MyOrdersFragment(),ORDERS_FRAGMENT);
          }
//        else if(id == R.id.nav_my_rewards){
//
//        }
         else if(id == R.id.nav_my_cart){
            //System.out.println("AAAAA\n");
             gotoFragment("My Cart",new MyCartFragment(),CART_FRAGMENT);

        }else if(id == R.id.nav_my_wishlist){
            gotoFragment("My Wishlist",new MyWishlistFragment(),WISHLIST_FRAGMENT);

        }else if(id == R.id.nav_my_account){
             gotoFragment("My Account",new MyAccountFragment(),ACCOUNT_FRAGMENT);

        }else if(id == R.id.nav_signout){

        }
        DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    private void setFragment(Fragment fragment, int fragmentNo)
    {
        if(fragmentNo != currentFragment){
            currentFragment = fragmentNo;
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.fade_in,R.anim.fade_out);
            fragmentTransaction.replace(frameLayout.getId(),fragment);
            fragmentTransaction.commit();
        }
    }

    private void gotoFragment(String title,Fragment fragment,int fragmentNo) {
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(title);
        actionBarLogo.setVisibility(View.GONE);
        invalidateOptionsMenu();
        setFragment(fragment,  fragmentNo);

    }
}
