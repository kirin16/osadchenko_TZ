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

    private String mText;

    public static ContainerFragment newInstance(String text){
        ContainerFragment containerFragment = new ContainerFragment();

        Bundle args = new Bundle();
        args.putString("text", text);
        containerFragment.setArguments(args);

        return containerFragment;
    }

    private void readBundle(Bundle bundle) {
        if (bundle != null) {
            mText = bundle.getString("text");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_container, container, false);
        readBundle(getArguments());
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
        ft.replace(R.id.container, BaseFragment.newInstance(mText));
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

}
