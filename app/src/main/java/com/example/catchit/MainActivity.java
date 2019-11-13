package com.example.catchit;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView work_list, camera;
    ViewPager viewPager;
    PageViewAdapter pageviewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        camera = findViewById(R.id.camera);
        work_list = findViewById(R.id.work_list);
        viewPager = findViewById(R.id.fragment_conta);
        pageviewAdapter = new PageViewAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pageviewAdapter);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }

        });
        work_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }

        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                onChangeTab(i);
            }

            private void onChangeTab(int i) {
                if (i == 0) {
                    camera.setTextSize(20);
                    camera.setTextColor(getColor(R.color.White));
                    work_list.setTextSize(25);
                    work_list.setTextColor(getColor(R.color.White));

                }
                if (i == 1) {
                    camera.setTextSize(25);
                    camera.setTextColor(getColor(R.color.White));
                    work_list.setTextSize(20);
                    work_list.setTextColor(getColor(R.color.White));
                }
            }
            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}


