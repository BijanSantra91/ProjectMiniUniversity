package com.example.bijan.projectminiuniversity;



import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragFive extends Fragment {

    EditText editText1, editText2;
    Button button1, button2;
    DetailsDatabase detailsDatabase;

    public FragFive() {
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
        View v=  inflater.inflate(R.layout.fragment_frag_five, container, false);
        editText1 = (EditText) v.findViewById(R.id.editte1);
        editText2 = (EditText) v.findViewById(R.id.editte2);
        button1 = (Button) v.findViewById(R.id.bu1);
        button2 = (Button) v.findViewById(R.id.bu2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText1.getText().toString().trim();
                if (name.isEmpty()){
                    Toast.makeText(getActivity(), "Please Enter Student Name", Toast.LENGTH_SHORT).show();
                }
                else {
                    MainActivity mainActivity = (MainActivity) getActivity();
                    mainActivity.passNameSearch(name);
                }
                editText1.setText("");
                editText2.setText("");
                editText1.requestFocus();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mobile = editText2.getText().toString().trim();
                if(mobile.isEmpty()){
                    Toast.makeText(getActivity(), "Please Enter Student Mobile Number", Toast.LENGTH_SHORT).show();
                }
                else {
                    MainActivity mainActivity = (MainActivity) getActivity();
                    mainActivity.passMobileSearch(mobile);
                }
                editText1.setText("");
                editText2.setText("");
                editText1.requestFocus();
            }
        });
        
        return v;
    }
}