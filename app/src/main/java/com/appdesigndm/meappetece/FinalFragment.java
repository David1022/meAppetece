package com.appdesigndm.meappetece;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FinalFragment extends Fragment {

    private TextView textFinal;
    private Button buttonFinal;
    private ProgressDialog pd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_final, container, false);

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
        showProgressBar();
        // TODO: Enviar datos
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(200);

                } catch (InterruptedException ie) {
                    // DO nothing
                }
                hideProgressBar();
            }
        }).start();

        Toast.makeText(getContext(), "Enviando datos...", Toast.LENGTH_SHORT).show();
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
