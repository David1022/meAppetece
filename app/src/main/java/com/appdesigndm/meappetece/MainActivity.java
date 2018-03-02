package com.appdesigndm.meappetece;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements Comunicator{

    private int mNumLogginAttempts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new PresentationFragment()).commit();
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
