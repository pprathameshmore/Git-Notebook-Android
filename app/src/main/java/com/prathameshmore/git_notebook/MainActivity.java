package com.prathameshmore.git_notebook;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.noodle.Noodle;
import com.prathameshmore.git_notebook.Fragments.Branching;
import com.prathameshmore.git_notebook.Fragments.GitBasics;
import com.prathameshmore.git_notebook.Fragments.GitHome;
import com.prathameshmore.git_notebook.Fragments.ResetTheFiles;
import com.prathameshmore.git_notebook.Fragments.ReviewHistory;
import com.prathameshmore.git_notebook.Fragments.SaveFragments;
import com.prathameshmore.git_notebook.Fragments.SynchronizeChanges;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Noodle noodle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Noodle NoSQL database
        noodle = Noodle.with(this).build();

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);


        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();

                switch (id) {
                    case R.id.menu_home:
                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        FragmentManager gitHomeFragmentManager = getSupportFragmentManager();
                        FragmentTransaction gitHomeFragmentTransaction = gitHomeFragmentManager.beginTransaction();
                        gitHomeFragmentTransaction.replace(R.id.fragmentParentView,new GitHome());
                        gitHomeFragmentTransaction.commit();
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.menu_basics:
                        Toast.makeText(MainActivity.this, "Git Basics", Toast.LENGTH_SHORT).show();
                        GitBasics gitBasics = new GitBasics();
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragmentParentView,gitBasics);
                        fragmentTransaction.commit();
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.menu_reset:
                        ResetTheFiles resetTheFiles = new ResetTheFiles();
                        FragmentManager resetTheFilesManager = getSupportFragmentManager();
                        FragmentTransaction resetTheFilesFragmentTransaction = resetTheFilesManager.beginTransaction();
                        resetTheFilesFragmentTransaction.replace(R.id.fragmentParentView,resetTheFiles);
                        resetTheFilesFragmentTransaction.commit();
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.menu_review:
                        FragmentManager reviewFragmentManager = getSupportFragmentManager();
                        FragmentTransaction reviewFragmentTransaction = reviewFragmentManager.beginTransaction();
                        reviewFragmentTransaction.replace(R.id.fragmentParentView,new ReviewHistory());
                        reviewFragmentTransaction.commit();
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.menu_branching:
                        FragmentManager branchingFragmentManager = getSupportFragmentManager();
                        FragmentTransaction branchingFragmentTransaction = branchingFragmentManager.beginTransaction();
                        branchingFragmentTransaction.replace(R.id.fragmentParentView,new Branching());
                        branchingFragmentTransaction.commit();
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.menu_sync:
                        FragmentManager syncFragmentManager = getSupportFragmentManager();
                        FragmentTransaction syncFragmentTransaction = syncFragmentManager.beginTransaction();
                        syncFragmentTransaction.replace(R.id.fragmentParentView,new SynchronizeChanges());
                        syncFragmentTransaction.commit();
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.menu_fragments:
                        FragmentManager fragmentsFragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragmentsFragmentTransaction = fragmentsFragmentManager.beginTransaction();
                        fragmentsFragmentTransaction.replace(R.id.fragmentParentView,new SaveFragments());
                        fragmentsFragmentTransaction.commit();
                        drawerLayout.closeDrawers();
                        break;

                    default:
                        return true;
                }
                return false;
            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
