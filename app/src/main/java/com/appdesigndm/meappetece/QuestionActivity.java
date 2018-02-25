package com.appdesigndm.meappetece;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class QuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new PresentationFragment()).commit();
    }
}
