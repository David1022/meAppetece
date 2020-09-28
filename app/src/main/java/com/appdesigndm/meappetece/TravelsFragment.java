package com.appdesigndm.meappetece;


import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
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
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_travels, container, false);
        mContext = getContext();

        radioGroup = (RadioGroup) view.findViewById(R.id.radio_group_travels);
        buttonTravels = (Button) view.findViewById(R.id.button_travels);

        buttonTravels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedTravel = "";
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.radio_button_menorca:
                        selectedTravel = "Menorca";
                        break;
                    case R.id.radio_button_praga:
                        selectedTravel = "Praga";
                        break;
                    case R.id.radio_button_roses:
                        selectedTravel = "Roses";
                        break;
                    case R.id.radio_button_san_sebastian:
                        selectedTravel = "San Sebastián";
                        break;
                    case R.id.radio_button_londres:
                        selectedTravel = "Londres";
                        break;
                    case R.id.radio_button_brujas:
                        selectedTravel = "Brujas";
                        break;
                    case R.id.radio_button_andorra:
                        selectedTravel = "Andorra";
                        break;
                    case R.id.radio_button_boi_taull:
                        selectedTravel = "Boí-Taüll";
                        break;
                    case R.id.radio_button_tenerife:
                        selectedTravel = "Tenerife";
                        break;
                    default:
                        Toast.makeText(mContext, "Selecciona un viaje", Toast.LENGTH_SHORT).show();
                        return;
                }
                MeAppeteceApplication.bestTravel = selectedTravel;
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new NextScapeFragment()).commit();
            }
        });

        return view;
    }

}
