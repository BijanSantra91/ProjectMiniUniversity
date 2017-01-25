package com.example.bijan.projectminiuniversity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class SmsFragment extends Fragment {

    EditText editText1, editText2;
    Button button1, button2;

    public SmsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_sms, container, false);

        editText1 = (EditText) v.findViewById(R.id.editt1);
        editText2 = (EditText) v.findViewById(R.id.editt2);
        button1 = (Button) v.findViewById(R.id.send);
        button2 = (Button) v.findViewById(R.id.close);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.searchDetails();
            }
        });

        return v;
    }

}
