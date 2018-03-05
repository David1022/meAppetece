package com.appdesigndm.meappetece;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class NextScapeFragment extends Fragment {

    private Context mContext;
    private Button buttonNextScape;
    private EditText editNextScape;

    private String textNextScape = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_next_scape, container, false);
        mContext = getContext();

        buttonNextScape = (Button) view.findViewById(R.id.button_next_scape);
        editNextScape = (EditText) view.findViewById(R.id.edit_text_next_scape);

        buttonNextScape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textNextScape = editNextScape.getText().toString();
                MeAppeteceApplication.nextScape = textNextScape;
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new NextTravelFragment()).commit();
            }
        });

        return view;
    }

}
