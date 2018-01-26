package artem.com.tz_osdchenko.adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import artem.com.tz_osdchenko.entity.ProjectData;
import artem.com.tz_osdchenko.view.fragments.ContainerFragment;

/**
 * Created by artem on 24.01.2018.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private Map<Integer, ProjectData> map;
    private List<ContainerFragment>   fragmentList = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm, Map<Integer, ProjectData> map) {
        super(fm);
        this.map = map;
        for (int i = 0; i<map.size(); i++){
            fragmentList.add(ContainerFragment.newInstance(map.get(i).getLog()));
        }
    }

    @Override
    public ContainerFragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return map.size();
    }
}
