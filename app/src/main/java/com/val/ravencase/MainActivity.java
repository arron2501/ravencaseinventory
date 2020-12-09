package com.val.ravencase;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textTitle = (TextView)findViewById(R.id.textTitle);
        textTitle.setText("Dashboard");

        // kita set default nya Home Fragment
        loadFragment(new Fragment_Dashboard());

        // inisialisasi BottomNavigationView
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);

        // beri listener pada saat item/menu bottomnavigation terpilih
        bottomNav.setOnNavigationItemSelectedListener(this);

        toolbar = findViewById(R.id.baseToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.option_logout:
                startActivity(new Intent(MainActivity.this, Welcome.class));
                finish();
                break;
            case R.id.option_contact_us:
                startActivity(new Intent(MainActivity.this, ContactUsActivity.class));
            break;
        }
        return super.onOptionsItemSelected(item);
    }

    // method untuk load fragment yang sesuai
    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }   return false;
    }

    // method listener untuk logika pemilihan
    @SuppressLint("SetTextI18n")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        TextView textTitle = (TextView)findViewById(R.id.textTitle);
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.navigation_dashboard:
                fragment = new Fragment_Dashboard();
                textTitle.setText("Dashboard");
                break;
            case R.id.navigation_stock:
                fragment = new Fragment_Stock();
                textTitle.setText("In Stock");
                break;
            case R.id.navigation_production:
                fragment = new Fragment_Production();
                textTitle.setText("In Production");
                break;
            case R.id.navigation_packing:
                fragment = new Fragment_Packing();
                textTitle.setText("On Packing");
                break;
            case R.id.navigation_delivery:
                fragment = new Fragment_Delivery();
                textTitle.setText("On Delivery");
                break;
        }   return loadFragment(fragment);
    }
}