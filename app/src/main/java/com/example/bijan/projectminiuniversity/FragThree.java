package com.example.bijan.projectminiuniversity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragThree extends Fragment {


    Button button1, button2, button3, button4, button5, button6, button7, button8;

    public FragThree() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frag_three, container, false);

        button1 = (Button) v.findViewById(R.id.butt1);
        button2 = (Button) v.findViewById(R.id.butt2);
        button3 = (Button) v.findViewById(R.id.butt3);
        button4 = (Button) v.findViewById(R.id.butt4);
        button5 = (Button) v.findViewById(R.id.butt5);
        button6 = (Button) v.findViewById(R.id.butt6);
        button7 = (Button) v.findViewById(R.id.butt7);
        button8 = (Button) v.findViewById(R.id.butt8);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subject = "M.Tech";
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.putDetails(subject);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subject = "B.Tech";
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.putDetails(subject);

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subject = "MCA";
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.putDetails(subject);

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subject = "BCA";
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.putDetails(subject);

            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.viewDetails();

            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.searchDetails();

            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return v;
    }
}
