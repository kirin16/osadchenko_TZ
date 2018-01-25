package artem.com.tz_osdchenko.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import artem.com.tz_osdchenko.R;

/**
 * Created by artem on 24.01.2018.
 */

public class ContainerFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.container, container, false);
        setStartTab();
        return view;
    }

    public void show(String text) {
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        ft.replace(R.id.container, BaseFragment.newInstance(text));
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

    public void setStartTab() {
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        ft.replace(R.id.container, BaseFragment.newInstance(getResources().getString(R.string.name_log)));
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

}
