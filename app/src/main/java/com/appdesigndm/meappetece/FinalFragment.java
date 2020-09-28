package com.appdesigndm.meappetece;


import android.app.ProgressDialog;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class FinalFragment extends Fragment {

    public static final String RESPONSE = "Response";
    private TextView textFinal;
    private Button buttonFinal;
    private ProgressDialog pd;

    private FirebaseDatabase database;
    private DatabaseReference myRef;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_final, container, false);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        textFinal = (TextView) view.findViewById(R.id.text_final);
        buttonFinal = (Button) view.findViewById(R.id.button_final);

        textFinal.setText(Html.fromHtml(getResources().getString(R.string.text_final)));
        buttonFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarDatos();
                getActivity().finish();
            }
        });

        return view;
    }

    private void enviarDatos() {
        Toast.makeText(getContext(), "Enviando datos...", Toast.LENGTH_SHORT).show();
        ResponseModel responseModel = MeAppeteceApplication.createResponse();
        myRef.child(RESPONSE).setValue(responseModel);
    }

    private void showProgressBar() {
        pd = new ProgressDialog(getContext());
        pd.setIndeterminate(true);
        pd.show();
    }

    private void hideProgressBar() {
        pd.dismiss();
    }

}
