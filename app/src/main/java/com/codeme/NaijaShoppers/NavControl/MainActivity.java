package com.codeme.NaijaShoppers.NavControl;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.codeme.NaijaShoppers.AboutUs;
import com.codeme.NaijaShoppers.AllBrands;
import com.codeme.NaijaShoppers.AllVendors;
import com.codeme.NaijaShoppers.Blogs;
import com.codeme.NaijaShoppers.Contact;
import com.codeme.NaijaShoppers.FeaturedProducts;
import com.codeme.NaijaShoppers.HomeFragment;
import com.codeme.NaijaShoppers.HowToPostFreeAds;
import com.codeme.NaijaShoppers.LatestProducts;
import com.codeme.NaijaShoppers.R;
import com.codeme.NaijaShoppers.Categories;
import com.codeme.NaijaShoppers.StoreLocator;
import com.codeme.NaijaShoppers.TodaysDeal;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FragmentManager mManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //calls home fragment
        mManager.beginTransaction().replace(R.id.cont_Frame, new HomeFragment()).commit();
    }

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Are you sure you want to exit?");
        builder.setCancelable(true);
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }




    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            mManager.beginTransaction().replace(R.id.cont_Frame, new HomeFragment()).commit();
            getSupportActionBar().setTitle(R.string.app_name);
        } else if (id == R.id.nav_categories) {
            mManager.beginTransaction().replace(R.id.cont_Frame, new Categories()).commit();
            getSupportActionBar().setTitle("All Categories");
        } else if (id == R.id.nav_featured_products) {
            mManager.beginTransaction().replace(R.id.cont_Frame, new FeaturedProducts()).commit();
            getSupportActionBar().setTitle("Featured Products");
        } else if (id == R.id.nav_todays_deal) {
            mManager.beginTransaction().replace(R.id.cont_Frame, new TodaysDeal()).commit();
            getSupportActionBar().setTitle("Todays Deal");
        } else if (id == R.id.nav_all_brands) {
            mManager.beginTransaction().replace(R.id.cont_Frame, new AllBrands()).commit();
            getSupportActionBar().setTitle("All Brands");
        } else if (id == R.id.nav_all_vendors) {
            mManager.beginTransaction().replace(R.id.cont_Frame, new AllVendors()).commit();
            getSupportActionBar().setTitle("All Vendors");
        } else if (id == R.id.nav_blogs) {
            mManager.beginTransaction().replace(R.id.cont_Frame, new Blogs()).commit();
            getSupportActionBar().setTitle("Blogs");
        } else if (id == R.id.nav_store_locator) {
            mManager.beginTransaction().replace(R.id.cont_Frame, new StoreLocator()).commit();
            getSupportActionBar().setTitle("Store Locator");
        } else if (id == R.id.nav_contact) {
            mManager.beginTransaction().replace(R.id.cont_Frame, new Contact()).commit();
            getSupportActionBar().setTitle("Contact");
        } else if (id == R.id.nav_latest_products) {
            mManager.beginTransaction().replace(R.id.cont_Frame, new LatestProducts()).commit();
            getSupportActionBar().setTitle("Latest Products");
        } else if (id == R.id.nav_aboutus) {
            mManager.beginTransaction().replace(R.id.cont_Frame, new AboutUs()).commit();
            getSupportActionBar().setTitle("About Us");
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
