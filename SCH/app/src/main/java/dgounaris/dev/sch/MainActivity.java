package dgounaris.dev.sch;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import dgounaris.dev.sch.DBHelper.MyDBHelper;
import dgounaris.dev.sch.People.Person;
import dgounaris.dev.sch.layout.home_fragment;
import dgounaris.dev.sch.layout.map_fragment;
import dgounaris.dev.sch.layout.profile_fragment;

public class MainActivity extends AppCompatActivity {

    Person activeperson = null;
    MyDBHelper databaseHelper;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment mainFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mainFragment = home_fragment.newInstance();
                    break;
                case R.id.navigation_dashboard:
                    mainFragment = profile_fragment.newInstance();
                    break;
                case R.id.navigation_notifications:
                    mainFragment = map_fragment.newInstance();
                    break;
            }
            Bundle bundle = new Bundle();
            bundle.putSerializable("person", activeperson);
            mainFragment.setArguments(bundle);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.framelayout, mainFragment);
            transaction.commit();
            return true;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper = new MyDBHelper(getApplicationContext());
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        // default fragment
        Fragment default_fragment = new home_fragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("activeperson", activeperson);
        default_fragment.setArguments(bundle);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framelayout, default_fragment);
        transaction.commit();

        activeperson = databaseHelper.getPerson(1);
    }

    public int connectPersonBin() {
        int myid = -1;

        return myid;
    }

}
