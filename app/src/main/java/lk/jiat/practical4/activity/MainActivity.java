package lk.jiat.practical4.activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;

import lk.jiat.practical4.R;
import lk.jiat.practical4.adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private TabLayout tablayout;


    private ViewPager2 viewpager2;

    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tablayout = findViewById(R.id.toggle);
        viewpager2 = findViewById(R.id.view_pager);


        tablayout.addTab(tablayout.newTab().setText("Sign In"));
        tablayout.addTab(tablayout.newTab().setText("Sign Up"));


        FragmentManager fragmentManager = getSupportFragmentManager();
        adapter = new ViewPagerAdapter(fragmentManager,getLifecycle());
        viewpager2.setAdapter(adapter);

        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
            viewpager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewpager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                tablayout.selectTab(tablayout.getTabAt(position));
            }
        });

    }
}