package edu.mum.lesson6;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import edu.mum.R;

public class MainActivity extends AppCompatActivity  implements ActionBar.TabListener {

    private final String FRAGMENT_HOME = "fragment_home";
    private final String FRAGMENT_ABOUT = "fragment_about";
    private final String FRAGMENT_WORK = "fragment_work";
    private final String FRAGMENT_CONTACT = "fragment_contact";

    private final Fragment fragmentHome = new HomeFragment();
    private final Fragment fragmentAbout = new AboutFragment();
    private final Fragment fragmentWork = new WorkFragment();
    private final Fragment fragmentContact = new ContactFragment();
    private static final int POSITION_HOME = 0;
    private static final int POSITION_WORK = 1;
    private static final int POSITION_CON = 2;
    private static final int POSITION_ME = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Curriculum Vitae");
        getSupportFragmentManager().beginTransaction().add(R.id.root, fragmentHome, FRAGMENT_HOME).commit();

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.addTab(actionBar.newTab().setText("home").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("work").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("contact").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("about me").setTabListener(this));
    }


    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        int position = tab.getPosition();
        switch (position) {
            case POSITION_HOME:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.root, fragmentHome, FRAGMENT_HOME)
                        .commit();
                break;
            case POSITION_WORK:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.root, fragmentWork, FRAGMENT_WORK)
                        .commit();
                break;
            case POSITION_CON:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.root, fragmentContact, FRAGMENT_CONTACT)
                        .commit();
                break;
            case POSITION_ME:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.root, fragmentAbout, FRAGMENT_ABOUT)
                        .commit();
                break;
        }
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
