package artem.com.tz_osdchenko;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import artem.com.tz_osdchenko.adapter.ViewPagerAdapter;
import artem.com.tz_osdchenko.entity.ProjectData;
import artem.com.tz_osdchenko.utils.Constants;

public class MainActivity extends AppCompatActivity {

    private Button                    mBtnPrevious, mBtnNext;
    private ViewPager                 mViewPager;
    private ViewPagerAdapter          mViewPagerAdapter;
    private Map<Integer, ProjectData> dataMap;
    private TabLayout                 mTabLayout;
    private ActionBar                 mActionBar;
    private Menu                      mMenu;
    private TabLayout.Tab             mTabLog;
    private ArrayList<String>         arrayDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMap();

        mActionBar = getSupportActionBar();

        if (mActionBar != null) {
            mActionBar.setTitle(arrayDate.get(0));
            mActionBar.setDisplayHomeAsUpEnabled(true);
            mActionBar.setElevation(0);
        }

        mTabLayout         = findViewById(R.id.tabs);
        mBtnPrevious       = findViewById(R.id.btnPrevious);
        mBtnNext           = findViewById(R.id.btnNext);
        mViewPager         = findViewById(R.id.mainPager);

        mViewPagerAdapter  = new ViewPagerAdapter(getSupportFragmentManager(), dataMap);
        mTabLog            = mTabLayout.newTab().setText(R.string.name_log);

        mTabLayout.addTab(mTabLog);
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.name_general));
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.name_docs));
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.name_dvir));

        mTabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorPrimaryDark));

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (position > 0 || position < dataMap.size() - 1 ) {
                    mTabLog.select();
                    mActionBar.setTitle(arrayDate.get(position));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = mTabLayout.getSelectedTabPosition();
                switch (position){
                    case 0:
                        mViewPagerAdapter.getItem(mViewPager.getCurrentItem())
                                .show(dataMap.get(mViewPager.getCurrentItem()).getLog()
                                );
                        setMenuItem(getResources().getString(R.string.send));
                        break;
                    case 1:
                        mViewPagerAdapter.getItem(mViewPager.getCurrentItem())
                                .show(dataMap.get(mViewPager.getCurrentItem()).getGeneral()
                                );
                        setMenuItem(getResources().getString(R.string.add));
                        break;
                    case 2:
                        mViewPagerAdapter.getItem(mViewPager.getCurrentItem())
                                .show(dataMap.get(mViewPager.getCurrentItem()).getDocs()
                                );
                        setMenuItem(getResources().getString(R.string.load));
                        break;
                    case 3:
                        mViewPagerAdapter.getItem(mViewPager.getCurrentItem())
                                .show(dataMap.get(mViewPager.getCurrentItem()).getDvir()
                                );
                        mMenu.clear();
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
                                .show(dataMap.get(mViewPager.getCurrentItem()).getLog()
                                );
                        setMenuItem(getResources().getString(R.string.send));
                        break;
                    case 1:
                        mViewPagerAdapter.getItem(mViewPager.getCurrentItem())
                                .show(dataMap.get(mViewPager.getCurrentItem()).getGeneral()
                                );
                        setMenuItem(getResources().getString(R.string.add));
                        break;
                    case 2:
                        mViewPagerAdapter.getItem(mViewPager.getCurrentItem())
                                .show(dataMap.get(mViewPager.getCurrentItem()).getDocs()
                                );
                        setMenuItem(getResources().getString(R.string.load));
                        break;
                    case 3:
                        mViewPagerAdapter.getItem(mViewPager.getCurrentItem())
                                .show(dataMap.get(mViewPager.getCurrentItem()).getDvir()
                                );
                        mMenu.clear();
                        break;
                    default:
                        break;
                }
            }
        });
        
        mViewPager.setAdapter(mViewPagerAdapter);

        mBtnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mViewPager.getCurrentItem() > 0 ) {
                    mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1, true);
                    mActionBar.setTitle(arrayDate.get(mViewPager.getCurrentItem()));
                    mTabLog.select();
                }
            }
        });

        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mViewPager.getCurrentItem() < dataMap.size() - 1 ) {
                    mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1, true);
                    mActionBar.setTitle(arrayDate.get(mViewPager.getCurrentItem()));
                    mTabLog.select();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        mMenu = menu;
        mMenu.add(getResources().getString(R.string.name_log));
        return super.onCreateOptionsMenu(menu);
    }

    private void setMenuItem(String menuTitle){
        mMenu.clear();
        mMenu.add(menuTitle);
    }


    private void initMap(){
        dataMap   = new HashMap<>();
        arrayDate = new ArrayList<>();
        for (int i =0; i < Constants.DATA_COUNT; i++) {
            dataMap.put(i, new ProjectData(
                    getResources().getString(R.string.name_log),
                    getResources().getString(R.string.name_general) ,
                    getResources().getString(R.string.name_docs),
                    getResources().getString(R.string.name_dvir))
            );
            arrayDate.add((i+1)+ " day");
        }
    }

}
