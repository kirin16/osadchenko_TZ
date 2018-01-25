package artem.com.tz_osdchenko.view.fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


/**
 * Created by artem on 24.01.2018.
 */

public class BaseFragment extends ListFragment {

    private String mText;

    public static BaseFragment newInstance(String text){
        BaseFragment baseFragment = new BaseFragment();

        Bundle args = new Bundle();
        args.putString("text", text);
        baseFragment.setArguments(args);

        return baseFragment;
    }

    private void readBundle(Bundle bundle) {
        if (bundle != null) {
            mText = bundle.getString("text");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        readBundle(getArguments());

        String[] data = new String[]
                {mText, mText, mText, mText, mText, mText, mText, mText, mText};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                inflater.getContext(), android.R.layout.simple_list_item_1,
                data);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);

    }


}
