package com.appdesigndm.meappetece;

import android.app.Application;

public class MeAppeteceApplication extends Application {

    public static ResponseModel response = new ResponseModel();

    public static Integer numFailedLogin = 0;
    public static Integer numAttemptsFirstKissDate = 0;
    public static Integer numFailedFirstDinner = 0;
    public static String barcaMadrid = "";
    public static String bestTravel = "";
    public static String nextScape = "";
    public static String nextTravel = "";
    public static Integer numFailedLoveMe = 0;
    public static Integer numFailedMarryMe = 0;

    public static String makeString() {
        String respuesta =  "{Num. fallos login: " + numFailedLogin.toString() + ", \n" +
                "Num. fallos primer beso: " + numAttemptsFirstKissDate.toString() + ", \n" +
                "Num. fallos primera cena: " + numFailedFirstDinner.toString() + ", \n" +
                "Barça o Madrid: " + barcaMadrid +  ", \n" +
                "El mejor viaje: " + bestTravel +  ", \n" +
                "La próxima escapada: " + nextScape +  ", \n" +
                "El próximo viaje: " + nextTravel +  ", \n" +
                "Num. fallos 'me quieres': " + numFailedLoveMe.toString() + ", \n" +
                "Num. fallos 'quieres casarte conmigo': " + numFailedMarryMe.toString() + "}";

        return respuesta;
        }
}
