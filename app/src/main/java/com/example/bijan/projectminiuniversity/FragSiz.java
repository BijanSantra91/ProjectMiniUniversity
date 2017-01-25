package com.example.bijan.projectminiuniversity;


import android.content.SharedPreferences;
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
public class FragSiz extends Fragment {

    EditText editText1, editText2, editText3, editText4, editText5, editText6;
    Button button1, button2;

    public FragSiz() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frag_siz, container, false);

        editText1 = (EditText) v.findViewById(R.id.editt1);
        editText2 = (EditText) v.findViewById(R.id.editt2);
        editText3 = (EditText) v.findViewById(R.id.editt3);
        editText4 = (EditText) v.findViewById(R.id.editt4);
        editText5 = (EditText) v.findViewById(R.id.editt5);
        editText6 = (EditText) v.findViewById(R.id.editt6);

        button1 = (Button) v.findViewById(R.id.b1);
        button2 = (Button) v.findViewById(R.id.b2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("credential", 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                String Eno = editText1.getText().toString();
                String Ename = editText2.getText().toString();
                String Email = editText3.getText().toString();
                String Password = editText4.getText().toString();
                String Confirm = editText5.getText().toString();
                String PwHint = editText6.getText().toString();

                editor.putString("Eno", Eno);
                editor.putString("Ename", Ename);
                editor.putString("Email", Email);
                editor.putString("Password", Password);
                editor.putString("Confirm", Confirm);
                editor.putString("PwHint", PwHint);
                editor.commit();

                editText1.setText("");
                editText2.setText("");
                editText3.setText("");
                editText4.setText("");
                editText5.setText("");
                editText6.setText("");
                editText1.requestFocus();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.login();
            }
        });
        
        return v;
    }

}
