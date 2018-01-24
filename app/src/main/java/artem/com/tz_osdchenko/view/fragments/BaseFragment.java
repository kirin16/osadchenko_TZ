package artem.com.tz_osdchenko.view.fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


/**
 * Created by artem on 24.01.2018.
 */

public class BaseFragment extends ListFragment {

    private String    mText, mMenuText;
    private ActionBar mActionBar;
    private MenuItem  menuItem;

    public static BaseFragment newInstance(String text, String menuText){
        BaseFragment questFragment = new BaseFragment();

        Bundle args = new Bundle();
        args.putString("text", text);
        args.putString("menuText", menuText);
        questFragment.setArguments(args);

        return questFragment;
    }

    private void readBundle(Bundle bundle) {
        if (bundle != null) {
            mText     = bundle.getString("text");
            mMenuText = bundle.getString("menuText");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        readBundle(getArguments());

        setHasOptionsMenu(true);

        String[] data = new String[]{mText, mText, mText, mText, mText, mText, mText, mText, mText};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                inflater.getContext(), android.R.layout.simple_list_item_1,
                data);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menuItem = menu.add(mText);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
