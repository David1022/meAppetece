package com.appdesigndm.meappetece;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class QuestionActivity extends AppCompatActivity implements Comunicator{

    private int mNumLogginAttempts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

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
