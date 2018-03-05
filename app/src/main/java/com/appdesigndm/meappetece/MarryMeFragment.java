package com.appdesigndm.meappetece;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MarryMeFragment extends Fragment {

    private Context mContext;
    private TextView textMarryMe;
    private Button yesButton;
    private Button noButton;
    private int numFailedMarryMe = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_marry_me, container, false);
        mContext = getContext();

        textMarryMe = (TextView) view.findViewById(R.id.text_marry_me);
        yesButton = (Button) view.findViewById(R.id.yes_button);
        noButton = (Button) view.findViewById(R.id.no_button);

        textMarryMe.setText(Html.fromHtml(getResources().getString(R.string.do_you_marry_me)));
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickToYes();
            }
        });
        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickToNo();
            }
        });

        return view;
    }

    private void clickToYes() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setMessage("Ahora si, cariño, ya hemos acabado")
                .setPositiveButton("Te quiero", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        openFinalFragment();
                    }
                })
                .setCancelable(false)
                .show();
    }

    private void clickToNo() {
        numFailedMarryMe++;
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setMessage("Eso es mala leche, eh jajaja")
                .setPositiveButton("Venga en serio", null)
                .setCancelable(false)
                .show();
    }

    private void openFinalFragment() {
        MeAppeteceApplication.numFailedMarryMe = numFailedMarryMe;
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new UnlockFragment()).commit();
    }

}
