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
public class LoveMeFragment extends Fragment implements View.OnClickListener {

    private Context mContext;
    private TextView textLoveMe;
    private int numFaliedLoveMe;
    private Button yesButton;
    private Button noButton;


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_love_me, container, false);
        mContext = getContext();

        textLoveMe = (TextView) view.findViewById(R.id.text_love_me);
        yesButton = (Button) view.findViewById(R.id.yes_button);
        noButton = (Button) view.findViewById(R.id.no_button);

        textLoveMe.setText(Html.fromHtml(getResources().getString(R.string.do_you_love_me)));
        yesButton.setOnClickListener(this);
        noButton.setOnClickListener(this);

        numFaliedLoveMe = 0;

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.yes_button:
                clickToYes();
                break;
            case R.id.no_button:
                clickToNo();
                break;
            default:
                break;
        }
    }

    private void clickToYes() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MeAppeteceApplication.numFailedLoveMe = numFaliedLoveMe;
//                MeAppeteceApplication.response.setNumFailedLoveMe(numFaliedLoveMe);
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new MarryMeFragment()).commit();
            }
        };
        if (numFaliedLoveMe <= 1) {
            builder.setMessage("Ostras!! Eso si que no me lo esperaba...que me dijeras que SI a la primera..." +
                    "Ahora no se cómo seguir");
            builder.setPositiveButton("Seguir", listener);
        } else if ((numFaliedLoveMe > 1) && (numFaliedLoveMe < 3)) {
            builder.setMessage("Bueno, no ha sido a la primera pero no pasa nada ...yo se que me quieres");
            builder.setPositiveButton("Ya", listener);
        } else {
            builder.setMessage("Jolín carinyet!! Si vamos asi...");
            builder.setPositiveButton("Vaaaleeee", listener);
        }
        builder.setPositiveButton("Continua va", listener);
        builder.setCancelable(false);
        builder.show();
    }

    private void clickToNo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        numFaliedLoveMe++;
        switch (numFaliedLoveMe) {
            case 1:
                builder.setMessage("No esperaba menos ;P");
                builder.setPositiveButton("Volver a intentar", null);
                break;
            case 2:
                builder.setMessage("Venga va en serio");
                builder.setPositiveButton("Vale", null);
                break;
            case 3:
                noButton.setVisibility(View.GONE);
                builder.setMessage("Bueno, como yo se que SI me quieres seguimos...a ver qué contestas ahora jaja");
                builder.setPositiveButton("Vaaaaaleeeeee", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        yesButton.setText("Que siiiiii");
                    }
                });
                builder.setNegativeButton("Que noooooooo!!!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        textLoveMe.setText("Que siiiiiiiiii!!!!\nQue me quieres y muchoooooo!!!!");
                        yesButton.setText("Vaaaaleeeee");
                    }
                });
                break;
            default:
                break;
        }
        builder.setCancelable(false);
        builder.show();
    }

}
