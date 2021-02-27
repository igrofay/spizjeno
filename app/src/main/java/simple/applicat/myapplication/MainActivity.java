package simple.applicat.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;


import com.google.android.material.bottomnavigation.BottomNavigationView;

import simple.applicat.myapplication.fragments.FragmentHome;
import simple.applicat.myapplication.fragments.FragmentProfile;
import simple.applicat.myapplication.fragments.FragmentSetting;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Fragment fragmentMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentMain =new FragmentHome() ;
        fragmentTransaction.replace(R.id.frameLayout, fragmentMain).commit();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            fragmentTransaction = fragmentManager.beginTransaction();
            switch (item.getItemId()){
                case R.id.home_button:
                    fragmentMain = new FragmentHome();
                    fragmentTransaction.replace(R.id.frameLayout,fragmentMain).commit();
                    break;
                case R.id.profile_buttom:
                    fragmentMain= new FragmentProfile();
                    fragmentTransaction.replace(R.id.frameLayout,fragmentMain).commit();
                    break;
                case R.id.setting_button:
                    fragmentMain = new FragmentSetting();
                    fragmentTransaction.replace(R.id.frameLayout,fragmentMain).commit();
                    break;
            }
            return true;
        });
    }

}