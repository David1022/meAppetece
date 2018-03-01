package com.appdesigndm.meappetece;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Vector;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstKissDateFragment extends Fragment {

    public static final String CATORCE = "14/3/2015";
    public static final String QUINCE = "15/3/2015";
    private Context mContext;
    private TextView textDatePicker;
    private CalendarView datePicker;
    private Button buttonDatePicker;

    private int numAttemptsLogin = 0;
    private int numAttemptsFirstKissDate = 0;
    private String selectedDate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first_kiss_date, container, false);
        mContext = getContext();
        textDatePicker = (TextView) view.findViewById(R.id.text_date_picker);
        datePicker = (CalendarView) view.findViewById(R.id.date_picker);
        buttonDatePicker = (Button) view.findViewById(R.id.button_date_picker);

        setupDatePicker();
        buttonDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((selectedDate.equals(CATORCE)) || (selectedDate.equals(QUINCE))) {
                    openFirstDinnerFragment();
                } else {
                    showErrorDialog();
                }
            }
        });

        numAttemptsLogin = ((QuestionActivity) getActivity()).getNumLoginAttempts();

        showDialogByLoginAttempts();
        return view;
    }

    private void setupDatePicker() {
        datePicker.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                String mYear = ((Integer) year).toString();
                String mMonth = (((Integer) (month + 1)).toString());
                String mDay = ((Integer) day).toString();
                selectedDate = mDay + "/" + mMonth + "/" + mYear;
                if (selectedDate.equals(CATORCE)) {
                    Toast.makeText(mContext, "Técnicamente fue el 15 pero se acepta", Toast.LENGTH_SHORT).show();
                } else if (selectedDate.equals(QUINCE)) {
                    Toast.makeText(mContext, "Genial!", Toast.LENGTH_SHORT).show();
                } else {
                    numAttemptsFirstKissDate++;
                    showErrorDialog();
                }
            }
        });
    }

    private void showErrorDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setMessage("Piensa cariño...")
                .setPositiveButton("Aceptar", null)
                .setCancelable(false)
                .show();
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
                showData();
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    private void showData() {
        textDatePicker.setVisibility(View.VISIBLE);
        datePicker.setVisibility(View.VISIBLE);
        buttonDatePicker.setVisibility(View.VISIBLE);
    }

    private void openFirstDinnerFragment() {
        MeAppeteceApplication.numAttemptsFirstKissDate = numAttemptsFirstKissDate;
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new FirstDinnerFragment()).commit();
    }

}
