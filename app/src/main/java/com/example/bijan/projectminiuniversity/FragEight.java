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
public class FragEight extends Fragment {

    EditText editText1, editText2, editText3;
    Button button1, button2;

    public FragEight() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frag_eight, container, false);

        editText1 = (EditText) v.findViewById(R.id.edit1);
        editText2 = (EditText) v.findViewById(R.id.edit2);
        editText3 = (EditText) v.findViewById(R.id.edit3);
        button1 = (Button) v.findViewById(R.id.buttonn1);
        button2 = (Button) v.findViewById(R.id.buttonn2);

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