package com.example.green.annapurnapost;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.id_toolbar);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        setSupportActionBar(toolbar);

        navigationView = (NavigationView)findViewById(R.id.navigation_view);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.draweropen,R.string.drawerclose);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        getSupportActionBar().setTitle("अन्नपूर्ण पोष्ट");
        actionBarDrawerToggle.syncState();

    }
}
