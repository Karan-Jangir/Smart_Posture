package com.example.smartposture;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private NavController navController;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;

    public void fade(View view)
    {
        ImageView grey=findViewById(R.id.grey);
        ImageView green=findViewById(R.id.green);
        grey.animate().alpha(1f).setDuration(1000);
        green.animate().alpha(0f).setDuration(1000);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView=findViewById(R.id.bottomNavigationView);
        navController= Navigation.findNavController(this,R.id.frame_layout);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);

        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.navigation_view);
        toggle= new ActionBarDrawerToggle(this,drawerLayout,R.string.start,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

       switch (item.getItemId())
       {
           case R.id.navigation_home_side:
               Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
               break;
           case R.id.navigation_about_app:
               Intent intent = new Intent(MainActivity.this,About_App.class);
               startActivity(intent);
               break;
           case R.id.navigation_contact:
               Intent intent1 = new Intent(MainActivity.this,Contact_us.class);
               startActivity(intent1);
               break;
           case R.id.navigation_share:
               Toast.makeText(this, "Share ", Toast.LENGTH_SHORT).show();
               break;
       }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_menu,menu);
        MenuItem itemswitch =  menu.findItem(R.id.switch_action_bar);
        itemswitch.setActionView(R.layout.use_switch);
        final Switch sw=(Switch)menu.findItem(R.id.switch_action_bar).getActionView().findViewById(R.id.switch2);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    Toast.makeText(MainActivity.this, "Dark Mode", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return true;
    }
}