package com.appdesigndm.meappetece;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WelcomeFragment extends Fragment {

    private int numAttemptsLogin = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);
        numAttemptsLogin = ((QuestionActivity) getActivity()).getNumLoginAttempts();
        TextView text = (TextView) view.findViewById(R.id.welcome_text);
        text.setText("Intentos: " + numAttemptsLogin);
        return view;
    }

}
