package com.appdesigndm.meappetece;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class BarcaMadridFragment extends Fragment {

    private Context mContext;
    private Button buttonBarca;
    private Button buttonMadrid;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_barca_madrid, container, false);
        mContext = getContext();

        buttonBarca = (Button) view.findViewById(R.id.button_barca);
        buttonMadrid = (Button) view.findViewById(R.id.button_madrid);

        buttonBarca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MeAppeteceApplication.barcaMadrid = "Barça";
                showDialog();
            }
        });
        buttonMadrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MeAppeteceApplication.barcaMadrid = "Madrid";
                showDialog();
            }
        });

        return view;
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setMessage("Que noooooo, que no entraremos en polémica precisamente hoy...")
                .setPositiveButton("jajajaja", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        openTravelsFragment();
                    }
                })
                .setCancelable(false)
                .show();
    }

    private void openTravelsFragment() {
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new TravelsFragment()).commit();
    }

}
