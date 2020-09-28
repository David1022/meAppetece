package com.appdesigndm.meappetece;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class PresentationFragment extends Fragment {

    private TextView text;
    private Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_presentation, container, false);

        text = (TextView) view.findViewById(R.id.presentation_text);
        button = (Button) view.findViewById(R.id.lets_play_button);

        text.setText(Html.fromHtml(getResources().getString(R.string.presentation_text)));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new LoginFragment()).commit();
            }
        });

        return view;
    }

}
