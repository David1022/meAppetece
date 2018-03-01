package com.appdesigndm.meappetece;


import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class TravelsFragment extends Fragment {


    private Context mContext;
    private Button buttonTravels;
    private RadioGroup radioGroup;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_travels, container, false);
        mContext = getContext();

        radioGroup = (RadioGroup) view.findViewById(R.id.radio_group_travels);
        buttonTravels = (Button) view.findViewById(R.id.button_travels);

        buttonTravels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int checkedId = radioGroup.getCheckedRadioButtonId();
                    Toast.makeText(mContext, "xxxxx", Toast.LENGTH_SHORT).show();
//                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, new BarcaMadridFragment()).commit();
            }
        });

        return view;
    }

}
