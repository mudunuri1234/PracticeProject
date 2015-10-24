package com.learning.android.project;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.learning.android.project.fragments.AssignmentsFragment;
import com.learning.android.project.fragments.ClassesFragment;
import com.learning.android.project.fragments.GradesFragment;
import com.learning.android.project.fragments.HomeFragment;
import com.learning.android.project.fragments.NotificationsFragment;
import com.learning.android.project.fragments.TestsFragment;


public class MainActivity extends AppCompatActivity implements DrawerFragment.FragmentDrawerListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        DrawerFragment drawerFragment = (DrawerFragment) getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        drawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        drawerFragment.setDrawerListener(this);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                title = getString(R.string.nav_item_home);
                break;
            case 1:
                fragment = new ClassesFragment();
                title = getString(R.string.nav_item_classes);
                break;
            case 2:
                fragment = new AssignmentsFragment();
                title = getString(R.string.nav_item_assignments);
                break;
            case 3:
                fragment = new TestsFragment();
                title = getString(R.string.nav_item_tests);
                break;
            case 4:
                fragment = new GradesFragment();
                title = getString(R.string.nav_item_grades);
                break;
            case 5:
                fragment = new NotificationsFragment();
                title = getString(R.string.nav_item_notifications);
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            // set the toolbar title
            getSupportActionBar().setTitle(title);
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        System.out.println("------- Inside onOptionsItemSelected --------");
        return MenuChoice(item);
    }

    private boolean MenuChoice(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
                Toast.makeText(this, "You clicked on Settings", Toast.LENGTH_LONG).show();
                return true;
        }

        if (id == R.id.item1) {
            Toast.makeText(this, "You clicked on Item 1", Toast.LENGTH_LONG).show();
            return true;
        }

        if (id == R.id.item2) {
            Toast.makeText(this, "You clicked on Item 2", Toast.LENGTH_LONG).show();
            return true;
        }

        if (id == R.id.item3) {
            Toast.makeText(this, "You clicked on Item 3", Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }

}
