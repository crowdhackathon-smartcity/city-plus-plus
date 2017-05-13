package dgounaris.dev.sch;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import dgounaris.dev.sch.layout.home_fragment;
import dgounaris.dev.sch.layout.map_fragment;
import dgounaris.dev.sch.layout.profile_fragment;

public class MainActivity extends AppCompatActivity {

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

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        // default fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framelayout, new home_fragment());
        transaction.commit();
    }

}
