package com.aadev.tortilleriakino;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.aadev.tortilleriakino.Fragments.DebtsFragment;
import com.aadev.tortilleriakino.Fragments.DeliveredFragment;
import com.aadev.tortilleriakino.Fragments.SellFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.inflateMenu(R.menu.bottom_nav_menu);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.nav_host_fragment, new SellFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = new SellFragment();

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    selectedFragment = new SellFragment();
                    break;
                case R.id.navigation_dashboard:
                    selectedFragment = new DebtsFragment();
                    break;
                case R.id.navigation_delivered:
                    selectedFragment = new DeliveredFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, selectedFragment).commit();
            return true;
        }
    };

    public void signOut(View view) {
        mAuth.signOut();
        Intent login = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(login);
        finish();
    }
}
