package com.appdesigndm.meappetece;


import android.app.AlertDialog;
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
public class QuestionFragment extends Fragment implements View.OnClickListener {

    private int numAttemptsLogin = 0;
    private TextView question;
    private int numNoClicks;
    private Button yesButton;
    private Button noButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_question, container, false);
        question = (TextView) view.findViewById(R.id.question_text);
        yesButton = (Button) view.findViewById(R.id.yes_button);
        noButton = (Button) view.findViewById(R.id.no_button);

        yesButton.setOnClickListener(this);
        noButton.setOnClickListener(this);

        numAttemptsLogin = ((QuestionActivity) getActivity()).getNumLoginAttempts();
        numNoClicks = 0;

        showDialogByLoginAttempts();
        return view;
    }

    private void showDialogByLoginAttempts() {
        String message = "";
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        if (numAttemptsLogin == 1) {
            builder.setMessage(getResources().getString(R.string.welcome_text_one_attempt));
        } else if (numAttemptsLogin == 2) {
            builder.setMessage(getResources().getString(R.string.welcome_text_two_attempts));
        } else {
            builder.setMessage(getResources().getString(R.string.welcome_text_three_attempts));

        }
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                showNextQuestion();
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    private void showNextQuestion() {
        question.setText(Html.fromHtml(getResources().getString(R.string.question_two)));
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
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        if (numNoClicks == 1) {
            builder.setMessage("Ostras!! Eso si que no me lo esperaba...que me dijeras que si a la primera..." +
                    "Ahora no se cómo seguir");
            builder.setPositiveButton("Siiii", null);
        } else if ((numNoClicks > 1) && (numNoClicks < 4)) {
            builder.setMessage("Bueno, no ha sido a la primera pero yo se que en realidad me quieres");
            builder.setPositiveButton("Ya", null);
        } else {
            builder.setMessage("Jolín carinyet!! Si empezamos asi...");
            builder.setPositiveButton("Vaaaleeee", null);
        }
        builder.setCancelable(false);
        builder.show();
    }

    private void clickToNo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        numNoClicks++;
        switch (numNoClicks) {
            case 1:
                builder.setMessage("No esperaba menos ;P");
                builder.setPositiveButton("Yaaa", null);
                break;
            case 2:
                builder.setMessage("Venga va en serio");
                builder.setPositiveButton("Vale", null);
                break;
            case 3:
                builder.setMessage("Al final me enfadaré");
                builder.setPositiveButton("Ya estamos", null);
                break;
            case 4:
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
                        question.setText("Que siiiiiiiiii!!!!\nQue me quieres y muchoooooo!!!!");
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
