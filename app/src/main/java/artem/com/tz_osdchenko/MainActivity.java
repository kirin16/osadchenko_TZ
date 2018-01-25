package artem.com.tz_osdchenko;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMap();

        mActionBar = getSupportActionBar();

        if (mActionBar != null) {
            mActionBar.setTitle(Constants.CURRENT_DATE);
            mActionBar.setDisplayHomeAsUpEnabled(true);
            mActionBar.setElevation(0);
        }

        mTabLayout         = findViewById(R.id.tabs);
        mBtnPrevious       = findViewById(R.id.btnPrevious);
        mBtnNext           = findViewById(R.id.btnNext);
        mViewPager         = findViewById(R.id.mainPager);

        mViewPagerAdapter  = new ViewPagerAdapter(getSupportFragmentManager(), dataMap);

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
                                .show(getResources().getString(R.string.name_log)
                                );
                        setMenuItem(getResources().getString(R.string.send));
                        break;
                    case 1:
                        mViewPagerAdapter.getItem(mViewPager.getCurrentItem())
                                .show(getResources().getString(R.string.name_general)
                                );
                        setMenuItem(getResources().getString(R.string.add));
                        break;
                    case 2:
                        mViewPagerAdapter.getItem(mViewPager.getCurrentItem())
                                .show(getResources().getString(R.string.name_docs)
                                );
                        setMenuItem(getResources().getString(R.string.load));
                        break;
                    case 3:
                        mViewPagerAdapter.getItem(mViewPager.getCurrentItem())
                                .show(getResources().getString(R.string.name_dvir)
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
                                .show(getResources().getString(R.string.name_log)
                                );
                        setMenuItem(getResources().getString(R.string.send));
                        break;
                    case 1:
                        mViewPagerAdapter.getItem(mViewPager.getCurrentItem())
                                .show(getResources().getString(R.string.name_general)
                                );
                        setMenuItem(getResources().getString(R.string.add));
                        break;
                    case 2:
                        mViewPagerAdapter.getItem(mViewPager.getCurrentItem())
                                .show(getResources().getString(R.string.name_docs)
                                );
                        setMenuItem(getResources().getString(R.string.load));
                        break;
                    case 3:
                        mViewPagerAdapter.getItem(mViewPager.getCurrentItem())
                                .show(getResources().getString(R.string.name_dvir)
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.mMenu = menu;
        this.mMenu.add(getResources().getString(R.string.name_log));
        return super.onCreateOptionsMenu(menu);
    }

    private void setMenuItem(String menuTitle){
        mMenu.clear();
        mMenu.add(menuTitle);
    }

    private void initMap(){
        dataMap = new HashMap<>();
        for (int i =0; i<2; i++) {
            dataMap.put(i, new ProjectData(
                    getResources().getString(R.string.send),
                    getResources().getString(R.string.add) ,
                    getResources().getString(R.string.load),
                    getResources().getString(R.string.name_dvir))
            );
        }
    }

}
