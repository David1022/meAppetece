package com.appdesigndm.meappetece;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment implements View.OnClickListener {

    private TextView question;
    private int numNoClicks;
    private int numQuestion;
    private Button yesButton;
    private Button noButton;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_question, container, false);
        question = (TextView) view.findViewById(R.id.question_text);
        yesButton = (Button) view.findViewById(R.id.yes_button);
        noButton = (Button) view.findViewById(R.id.no_button);

        yesButton.setOnClickListener(this);
        noButton.setOnClickListener(this);

        numNoClicks = 0;
        numQuestion = 1;

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.yes_button:
                clickToYes1();
                break;
            case R.id.no_button:
                clickToNo1();
                break;
            default:
                break;
        }
    }

    private void clickToYes1() {
        numQuestion ++;
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (numQuestion) {
                    case 2:
                        showQuestion3();
                        break;
                    case 3:
                        showQuestion4();
                        break;
                    case 4:
                        showQuestion5();
                        break;
                    case 5:
                        showQuestion6();
                    default:
                        break;
                }
            }
        };
        // TODO: add dialog message
        if (numQuestion == 2) {
            if (numNoClicks <= 1) {
                builder.setMessage("Ostras!! Eso si que no me lo esperaba...que me dijeras que si a la primera..." +
                        "Ahora no se cómo seguir");
                builder.setPositiveButton("Siiii", listener);
            } else if ((numNoClicks > 1) && (numNoClicks < 3)) {
                builder.setMessage("Bueno, no ha sido a la primera pero yo se que en realidad me quieres");
                builder.setPositiveButton("Ya", listener);
            } else {
                builder.setMessage("Jolín carinyet!! Si empezamos asi...");
                builder.setPositiveButton("Vaaaleeee", listener);
            }
        } else {
            builder.setMessage("Miau");
            builder.setPositiveButton("Miau", listener);
        }
        builder.setCancelable(false);
        builder.show();
    }

    private void clickToNo1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        numNoClicks++;
        if (numQuestion == 1) {
            switch (numNoClicks) {
                // TODO: add dialog message
                case 1:
                    builder.setMessage("No esperaba menos ;P");
                    builder.setPositiveButton("Yaaa", null);
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
                            question.setText("Que siiiiiiiiii!!!!\nQue me quieres y muchoooooo!!!!");
                            yesButton.setText("Vaaaaleeeee");
                        }
                    });
                    break;
                default:
                    break;
            }
        } else {
            builder.setMessage("Miau");
            builder.setPositiveButton("Miau", null);
        }
        builder.setCancelable(false);
        builder.show();
    }

    // TODO: add action/s
    private void showQuestion2() {
        question.setText(Html.fromHtml(getResources().getString(R.string.question_two)));
    }

    private void showQuestion3() {
        question.setText(Html.fromHtml(getResources().getString(R.string.question_three)));
        noButton.setVisibility(View.VISIBLE);
    }

    private void showQuestion4() {
        question.setText(Html.fromHtml(getResources().getString(R.string.question_four)));
    }

    private void showQuestion5() {
        question.setText(Html.fromHtml(getResources().getString(R.string.question_five)));
    }

    private void showQuestion6() {
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new LoginFragment()).commit();
    }

}
