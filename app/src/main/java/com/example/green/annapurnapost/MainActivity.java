package com.example.green.annapurnapost;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    FragmentTransaction fragmentTransaction;
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
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.content_frame,new MainPageFragment());
        fragmentTransaction.commit();
        getSupportActionBar().setTitle("अन्नपूर्ण पोष्ट");
        actionBarDrawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.click_mainpage:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.content_frame,new MainPageFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("अन्नपूर्ण पोष्ट");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.click_samachar:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.content_frame,new SamacharFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("samchar पोष्ट");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                }
                return true;

            }
        });

    }
}
