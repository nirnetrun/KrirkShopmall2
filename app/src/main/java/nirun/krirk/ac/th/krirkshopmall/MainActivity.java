package nirun.krirk.ac.th.krirkshopmall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import nirun.krirk.ac.th.krirkshopmall.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.contentMainFrameFragment,new MainFragment()).commit();
        }
    }
}
