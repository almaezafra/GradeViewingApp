package gradeviewing.enrollmentsystem.com.gradeviewingapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import gradeviewing.enrollmentsystem.com.gradeviewingapp.Fragments.Grade;
import gradeviewing.enrollmentsystem.com.gradeviewingapp.Fragments.home;
import gradeviewing.enrollmentsystem.com.gradeviewingapp.Fragments.profile;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,profile.OnFragmentInteractionListener,home.OnFragmentInteractionListener,Grade.OnFragmentInteractionListener,Enlist.OnFragmentInteractionListener {

    private FragmentManager manager;
    private static FragmentTransaction transaction;
    private int currentFragment = 0;
    private int ctr = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

 /*       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        currentFragment = 0;
        Fragment frag = new home();
        transaction.replace(R.id.content_main, frag, "A");
        transaction.commit();


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
*/
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        transaction = manager.beginTransaction();
        Fragment frag = new Fragment();
        switch (id) {
            case R.id.nav_home:
                currentFragment = 0;
                frag = new home();
                transaction.replace(R.id.content_main, frag, "A");
                transaction.commit();
                break;
            case R.id.nav_profile:
                currentFragment = 1;
                frag = new profile();
                transaction.replace(R.id.content_main, frag, "A");
                transaction.commit();
                break;

            case R.id.nav_grades:
                currentFragment = 3;
                frag = new Grade();
                transaction.replace(R.id.content_main, frag, "A");
                transaction.commit();
                break;
            case R.id.nav_enlist:
                currentFragment = 4;
                frag = new Enlist();
                transaction.replace(R.id.content_main, frag, "A");
                transaction.commit();
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

