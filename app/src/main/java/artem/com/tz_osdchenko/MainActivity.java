package artem.com.tz_osdchenko;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;
import java.util.Map;

import artem.com.tz_osdchenko.adapter.ViewPagerAdapter;
import artem.com.tz_osdchenko.entity.ProjectData;

public class MainActivity extends AppCompatActivity {

    private Button                    mBtnPrevious, mBtnNext;
    private ViewPager                 mViewPager;
    private ViewPagerAdapter          mViewPagerAdapter;
    private Map<Integer, ProjectData> dataMap;
    private TabLayout                 mTabLayout;
    private ActionBar                 mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMap();

        mActionBar = getSupportActionBar();

        if (mActionBar != null) {
            mActionBar.setTitle("CURRENT_DATA");
            mActionBar.setDisplayHomeAsUpEnabled(true);
            mActionBar.setElevation(0);
        }

        mTabLayout = findViewById(R.id.tabs);
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.name_log));
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.name_general));
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.name_docs));
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.name_dvir));
        mTabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorPrimaryDark));

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = mTabLayout.getSelectedTabPosition();
                switch (position){
                    case 0:
                        mViewPagerAdapter.getItem(mViewPager.getCurrentItem())
                                .show(getResources().getString(R.string.name_log),
                                        dataMap.get(mViewPager.getCurrentItem()).getSend());
                        break;
                    case 1:
                        mViewPagerAdapter.getItem(mViewPager.getCurrentItem())
                                .show(getResources().getString(R.string.name_general),
                                        dataMap.get(mViewPager.getCurrentItem()).getAdd());
                        break;
                    case 2:
                        mViewPagerAdapter.getItem(mViewPager.getCurrentItem())
                                .show(getResources().getString(R.string.name_docs),
                                        dataMap.get(mViewPager.getCurrentItem()).getDocs());
                        break;
                    case 3:
                        mViewPagerAdapter.getItem(mViewPager.getCurrentItem())
                                .show(getResources().getString(R.string.name_dvir),
                                        dataMap.get(mViewPager.getCurrentItem()).getDvir());
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                int position = mTabLayout.getSelectedTabPosition();
                switch (position){
                    case 0:
                        mViewPagerAdapter.getItem(mViewPager.getCurrentItem())
                                .show(getResources().getString(R.string.name_log),
                                        dataMap.get(mViewPager.getCurrentItem()).getSend());
                        break;
                    case 1:
                        mViewPagerAdapter.getItem(mViewPager.getCurrentItem())
                                .show(getResources().getString(R.string.name_general),
                                        dataMap.get(mViewPager.getCurrentItem()).getAdd());
                        break;
                    case 2:
                        mViewPagerAdapter.getItem(mViewPager.getCurrentItem())
                                .show(getResources().getString(R.string.name_docs),
                                        dataMap.get(mViewPager.getCurrentItem()).getDocs());
                        break;
                    case 3:
                        mViewPagerAdapter.getItem(mViewPager.getCurrentItem())
                                .show(getResources().getString(R.string.name_dvir),
                                        dataMap.get(mViewPager.getCurrentItem()).getDvir());
                        break;
                    default:
                        break;
                }
            }
        });

        mBtnPrevious       = findViewById(R.id.btnPrevious);
        mBtnNext           = findViewById(R.id.btnNext);

        mViewPager         = findViewById(R.id.mainPager);
        mViewPagerAdapter  = new ViewPagerAdapter(getSupportFragmentManager(), dataMap);
        
        mViewPager.setAdapter(mViewPagerAdapter);

        mBtnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mViewPager.getCurrentItem() > 0 ) {
                    mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1, true);
                }
            }
        });

        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mViewPager.getCurrentItem() < dataMap.size() ) {
                    mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1, true);
                }
            }
        });

    }

    private void initMap(){
        dataMap = new HashMap<>();
        for (int i =0; i<2; i++) {
            dataMap.put(i, new ProjectData(getResources().getString(R.string.send), getResources().getString(R.string.add),
                    getResources().getString(R.string.load), getResources().getString(R.string.name_dvir)));
        }
    }

}
