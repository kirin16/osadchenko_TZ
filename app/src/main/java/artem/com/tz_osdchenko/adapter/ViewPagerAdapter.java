package artem.com.tz_osdchenko.adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.Map;

import artem.com.tz_osdchenko.entity.ProjectData;
import artem.com.tz_osdchenko.view.fragments.ContainerFragment;

/**
 * Created by artem on 24.01.2018.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private ContainerFragment         previousFragment, nextFragment;
    private Map<Integer, ProjectData> map;

    public ViewPagerAdapter(FragmentManager fm, Map<Integer, ProjectData> map) {
        super(fm);
        this.map = map;
        previousFragment = new ContainerFragment();
        nextFragment = new ContainerFragment();
    }

    @Override
    public ContainerFragment getItem(int position) {
        switch (position){
            case 0:
                return previousFragment;
            case 1:
                return nextFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return map.size();
    }
}
