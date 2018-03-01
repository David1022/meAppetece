package com.appdesigndm.meappetece;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class NextTravelFragment extends Fragment {

    private Context mContext;
    private Button buttonNextTravel;
    private EditText editNextTravel;

    private String textNextTravel = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_next_travel, container, false);
        mContext = getContext();

        buttonNextTravel = (Button) view.findViewById(R.id.button_next_travel);
        editNextTravel = (EditText) view.findViewById(R.id.edit_text_next_travel);

        buttonNextTravel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textNextTravel = editNextTravel.getText().toString();
                Toast.makeText(mContext, textNextTravel, Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new LoveMeFragment()).commit();
            }
        });

        return view;
    }

}
