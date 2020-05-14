package com.example.openshop;

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
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private static final int HOME_FRAGMENT = 0;
    private static final int CART_FRAGMENT = 1;

    private AppBarConfiguration mAppBarConfiguration;
    private FrameLayout frameLayout;

    private static int currentFragment;

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
            myCart();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        navigationView = (NavigationView)findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        navigationView.setNavigationItemSelectedListener(this);
        //to make first item in navigation bar checked by default
        navigationView.getMenu().getItem(0).setChecked(true);

        frameLayout = findViewById(R.id.nav_host_fragment);

        //on create HomePage Fragment is set
        setFragment(new HomePageFragment(),HOME_FRAGMENT);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if(currentFragment == HOME_FRAGMENT){
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
            setFragment(new HomePageFragment(), HOME_FRAGMENT);

        }else if(id == R.id.nav_my_orders){

        }else if(id == R.id.nav_my_rewards){

        }else if(id == R.id.nav_my_cart){
            //System.out.println("AAAAA\n");
             myCart();

        }else if(id == R.id.nav_my_wishlist){

        }else if(id == R.id.nav_my_account){

        }else if(id == R.id.nav_signout){

        }
        DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    private void setFragment(Fragment fragment, int fragmentNo)
    {
        currentFragment = fragmentNo;
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }

    private void myCart() {

        invalidateOptionsMenu();
        setFragment(new MyCartFragment(),  CART_FRAGMENT);
        navigationView.getMenu().getItem(3).setChecked(true);
    }
}
