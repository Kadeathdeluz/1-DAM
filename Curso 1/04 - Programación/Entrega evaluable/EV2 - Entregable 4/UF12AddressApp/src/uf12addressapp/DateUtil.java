package uf12addressapp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author Roldán Sanchis Martínez
 */
public class DateUtil {

    private static final String PATRO_DATA = "dd.MM.yyyy";
    private static final DateTimeFormatter FORMATEJADOR_DATA = DateTimeFormatter.ofPattern(PATRO_DATA);

    /**
     * Torna la data en format de cadena o null en cas de no existir
     *
     * @param data
     * @return
     */
    public static String format(LocalDate data) {
        if (data == null) {
            return null;
        }
        return FORMATEJADOR_DATA.format(data);
    }

    /**
     * Torna la data en format de LocalDate o null en cas de no existir
     *
     * @param data
     * @return
     */
    public static LocalDate parse(String data) {
        //En cas de que la variable no siga una data vàlida
        try {
            return FORMATEJADOR_DATA.parse(data, LocalDate::from);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    /**
     * Comproba que la data és vàlida
     *
     * @param data
     * @return
     */
    public static boolean validDate(String data) {
        return DateUtil.parse(data) != null;
    }
}
