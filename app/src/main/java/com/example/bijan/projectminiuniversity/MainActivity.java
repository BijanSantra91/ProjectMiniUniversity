package com.example.bijan.projectminiuniversity;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public void putDetails(String subject){
        Bundle bundle = new Bundle();
        FragFour fragFour = new FragFour();
        switch (subject) {
            case "M.Tech":
                bundle.putString("subject", subject);
                fragFour.setArguments(bundle);
                break;
            case "B.Tech":
                bundle.putString("subject", subject);
                fragFour.setArguments(bundle);
                break;
            case "MCA":
                bundle.putString("subject", subject);
                fragFour.setArguments(bundle);
                break;
            case "BCA":
                bundle.putString("subject", subject);
                fragFour.setArguments(bundle);
                break;
        }
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragFour);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void passNameSearch(String name){
        DialogNotify dialogNotify = new DialogNotify();
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        dialogNotify.setArguments(bundle);
        dialogNotify.show(getSupportFragmentManager(), null);
    }

    public void passMobileSearch(String mobile){
        DialogNotify dialogNotify = new DialogNotify();
        Bundle bundle = new Bundle();
        bundle.putString("mobile", mobile);
        dialogNotify.setArguments(bundle);
        dialogNotify.show(getSupportFragmentManager(), null);
    }

    public void register(){
        FragSiz fragSiz = new FragSiz();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragSiz);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void login(){
        FragTwo fragTwo = new FragTwo();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragTwo);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void openDetails(){
        FragThree fragThree = new FragThree();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragThree);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void viewDetails(){
        FragSeven fragSeven = new FragSeven();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragSeven);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void searchDetails(){
        FragFive fragFive = new FragFive();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragFive);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void emailSend(){
        FragEight fragEight = new FragEight();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragEight);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void smsSend(){
        SmsFragment smsFragment = new SmsFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, smsFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragOne fragOne = new FragOne();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, fragOne);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
