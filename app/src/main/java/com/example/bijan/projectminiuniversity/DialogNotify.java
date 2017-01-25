package com.example.bijan.projectminiuniversity;


import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DialogNotify extends DialogFragment {

    ListView dialoglist;
    DetailsDatabase detailsDatabase;
    String name, mobile;
    Cursor cursor;
    SimpleCursorAdapter simpleCursorAdapter;

    public DialogNotify() {
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


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = null;
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setIcon(R.drawable.ic_dehaze_white_48pt_3x);
        builder.setTitle("Details of Student");

        Bundle bundle = getArguments();
        name = bundle.getString("name");
        mobile = bundle.getString("mobile");

        View v = getActivity().getLayoutInflater().inflate(R.layout.fragment_dialog_notify, null);

        dialoglist = (ListView) v.findViewById(R.id.dialoglist);

        if (name!=null){

            cursor = detailsDatabase.quaryDetailss(name);

            if (cursor==null){
                Toast.makeText(getActivity(), "Please Enter Valid Name", Toast.LENGTH_SHORT).show();
            }
            else {
                simpleCursorAdapter = new SimpleCursorAdapter(getActivity(),
                        R.layout.row,
                        cursor,
                        new String[]{"no", "name", "mobile", "emailid", "subject", "description", "date"},
                        new int[]{R.id.textview1, R.id.textview2, R.id.textview3, R.id.textview4, R.id.textview5, R.id.textview6, R.id.textview7});

                dialoglist.setAdapter(simpleCursorAdapter);
            }
        }

        else if (mobile!=null){

            cursor = detailsDatabase.quaryDetailsss(mobile);

            if (cursor==null){
                Toast.makeText(getActivity(), "Please Enter Valid Mobile No", Toast.LENGTH_SHORT).show();
            }
            else {
                simpleCursorAdapter = new SimpleCursorAdapter(getActivity(),
                        R.layout.row,
                        cursor,
                        new String[]{"no", "name", "mobile", "emailid", "subject", "description", "date"},
                        new int[]{R.id.textview1, R.id.textview2, R.id.textview3, R.id.textview4, R.id.textview5, R.id.textview6, R.id.textview7});

                dialoglist.setAdapter(simpleCursorAdapter);
            }
        }

        builder.setView(v);

        builder.setPositiveButton("SMS", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.smsSend();
            }
        });

        builder.setNegativeButton("EMAIL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.emailSend();
            }
        });

        dialog = builder.create();

        return dialog;
    }
}
