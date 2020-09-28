package com.appdesigndm.meappetece;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity implements Comunicator{

    private int mNumLogginAttempts;
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        MeAppeteceApplication.response = new ResponseModel();

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new PresentationFragment()).commit();
        mFirebaseAnalytics.setCurrentScreen(this, "main", null);
    }

    @Override
    public void setNumLoginAttempts(int numLoginAttempts) {
        mNumLogginAttempts = numLoginAttempts;
    }

    @Override
    public int getNumLoginAttempts() {
        return mNumLogginAttempts;
    }
}
