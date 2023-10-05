package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class Validations {

    public static boolean validardate(String data) {
        //método de validação da data no formato "dd/MM/yyyy"
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        try {
            Date date = sdf.parse(data);
            if (data.equals(sdf.format(date))) {
                return true; // A data é válida
            } else {
                return false; // A data foi interpretada como válida, mas não é um formato válido (por exemplo, "32/01/2022")
            }
        } catch (ParseException e) {
            return false; // A data é inválida
        }
    }

    public  static boolean validarhour (String a ) {
        //método de validação do horário no formato "HH:mm"
        DateTimeFormatter f = DateTimeFormatter.ofPattern("HH:mm");

        try {
            LocalTime.parse(a,f);
            return true; // A hora é válida
        } catch (DateTimeParseException e) {
            return false; // A hora é inválida
        }

    }
}
