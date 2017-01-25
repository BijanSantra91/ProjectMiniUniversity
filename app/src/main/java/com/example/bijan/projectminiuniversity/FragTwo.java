package com.example.bijan.projectminiuniversity;


import android.content.SharedPreferences;
import android.os.Bundle;
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
public class FragTwo extends Fragment {

    EditText editText1, editText2, editText3;
    Button button1,button2;

    public FragTwo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frag_two, container, false);

        editText1 = (EditText) v.findViewById(R.id.edittext1);
        editText2 = (EditText) v.findViewById(R.id.edittext2);
        editText3 = (EditText) v.findViewById(R.id.edittext3);
        button1 = (Button) v.findViewById(R.id.butto1);
        button2 = (Button) v.findViewById(R.id.butto2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editText1.getText().toString();
                String password = editText2.getText().toString();

                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("credential", 0);
                String shusername = sharedPreferences.getString("Ename", null);
                String shpassword = sharedPreferences.getString("Password", null);

                if ((username.equals(shusername))&&(password.equals(shpassword))){
                    MainActivity mainActivity = (MainActivity) getActivity();
                    mainActivity.openDetails();
                }
                else{
                    Toast.makeText(getActivity(), "UserName and Password are Wrong" +
                            "Provide Correct UserName and Password", Toast.LENGTH_SHORT).show();
                    editText1.setText("");
                    editText2.setText("");
                    editText1.requestFocus();
                }
                editText1.setText("");
                editText2.setText("");
                editText1.requestFocus();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editText3.getText().toString();
            }
        });

        return v;
    }

}
