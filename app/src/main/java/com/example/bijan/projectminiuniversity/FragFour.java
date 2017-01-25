package com.example.bijan.projectminiuniversity;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragFour extends Fragment {

    EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7;
    Button button1, button2, button3;
    DetailsDatabase detailsDatabase;

    public FragFour() {
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

    public Dialog datePicker(){
        Dialog d = null;

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DATE);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                String date = +i+"-"+i1+1+"-"+i2;
                editText7.setText(date);
            }
        }, year, month, date);
        d = datePickerDialog;
        d.show();
        return  d;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frag_four, container, false);

        editText1 = (EditText) v.findViewById(R.id.edittex1);
        editText2 = (EditText) v.findViewById(R.id.edittex2);
        editText3 = (EditText) v.findViewById(R.id.edittex3);
        editText4 = (EditText) v.findViewById(R.id.edittex4);
        editText5 = (EditText) v.findViewById(R.id.edittex5);
        editText6 = (EditText) v.findViewById(R.id.edittex6);
        editText7 = (EditText) v.findViewById(R.id.edittex7);
        button1 = (Button) v.findViewById(R.id.but1);
        button2 = (Button) v.findViewById(R.id.but2);
        button3 = (Button) v.findViewById(R.id.but3);

        Bundle b = getArguments();
        if (b!=null) {
            String subject = b.getString("subject");
            editText5.setText(subject);
        }

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String no = editText1.getText().toString();
                String name = editText2.getText().toString();
                String mobile = editText3.getText().toString();
                String emailid = editText4.getText().toString();
                String subject = editText5.getText().toString();
                String description = editText6.getText().toString();
                String date = editText7.getText().toString();

                detailsDatabase.insertDetails(no, name, mobile, emailid, subject, description, date);

                editText1.setText("");
                editText2.setText("");
                editText3.setText("");
                editText4.setText("");
                editText5.setText("");
                editText6.setText("");
                editText7.setText("");

                editText1.requestFocus();

                Toast.makeText(getActivity(), "Values Inserted To The Database", Toast.LENGTH_SHORT).show();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.openDetails();

            }
        });

        return  v;
    }

}