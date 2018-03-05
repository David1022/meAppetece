package com.appdesigndm.meappetece;


import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
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
public class FirstDinnerFragment extends Fragment {

    private Context context;
    private Button buttonFirstDinner;
    private RadioGroup radioGroup;

    private int numFailedFirstDinner = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first_dinner, container, false);
        context = getContext();

        radioGroup = (RadioGroup) view.findViewById(R.id.radio_group_first_dinner);
        buttonFirstDinner = (Button) view.findViewById(R.id.button_first_dinner);

        buttonFirstDinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int checkedId = radioGroup.getCheckedRadioButtonId();
                if (checkedId == R.id.radio_button_viena) {
                    MeAppeteceApplication.numFailedFirstDinner = numFailedFirstDinner;
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, new BarcaMadridFragment()).commit();
                } else {
                    numFailedFirstDinner++;
                    showErrorDialog();
                }
            }
        });

        return view;
    }

    private void showErrorDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Cariño, esta no me la puedes fallar!")
                .setPositiveButton("Vale", null)
                .setCancelable(false)
                .show();
    }

}
