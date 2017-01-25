package com.example.bijan.projectminiuniversity;


import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragSeven extends Fragment {

    ListView listView;
    Cursor cursor;
    SimpleCursorAdapter simpleCursorAdapter;
    DetailsDatabase detailsDatabase;

    public FragSeven() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        detailsDatabase = new DetailsDatabase(getActivity());
        detailsDatabase.open();
    }

    @Override
    public void onDestroy() {
        detailsDatabase.close();
        super.onDestroy();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frag_seven, container, false);

        listView = (ListView) v.findViewById(R.id.listview);
        cursor = detailsDatabase.quaryDetails();

        simpleCursorAdapter = new SimpleCursorAdapter(getActivity(),
                R.layout.row,
                cursor,
                new String[]{"no", "name", "mobile", "emailid", "subject", "description", "date"},
                new int[]{R.id.textview1, R.id.textview2, R.id.textview3, R.id.textview4, R.id.textview5, R.id.textview6, R.id.textview7});

        listView.setAdapter(simpleCursorAdapter);

        return v;
    }

}
