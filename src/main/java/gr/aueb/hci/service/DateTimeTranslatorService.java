package gr.aueb.hci.service;

/**
 * Service responsible for translating given attributes into a beautified String (desired format).
 *
 *
 */
public class DateTimeTranslatorService {

    /**
     * Translates given constants into the preferred formatted string message.
     *
     * @param day Day of the week.
     * @param month Month of year.
     * @param dayMonth Day of month.
     * @param hour Current hour.
     * @param minute Current minute.
     * @param year Current year.
     * @return Formatted String message.
     */
    public String dateTimeTranslator( final String day, final String month, final int dayMonth, final int hour, final int minute,
            final int year ) {
        String translatedDay = "";
        switch ( day ) {
            case "MONDAY":
                translatedDay = "�������";
                break;

            case "TUESDAY":
                translatedDay = "�����";
                break;

            case "WEDNESDAY":
                translatedDay = "�������";
                break;

            case "THURSDAY":
                translatedDay = "������";
                break;

            case "FRIDAY":
                translatedDay = "���������";
                break;

            case "SATURDAY":
                translatedDay = "�������";
                break;

            case "SUNDAY":
                translatedDay = "�������";
                break;

            default:
                translatedDay = day;
                break;
        }

        String translatedMonth = "";
        switch ( month ) {
            case "JANUARY":
                translatedMonth = "����������";
                break;

            case "FEBRUARY":
                translatedMonth = "�����������";
                break;

            case "MARCH":
                translatedMonth = "�������";
                break;

            case "APRIL":
                translatedMonth = "��������";
                break;

            case "MAY":
                translatedMonth = "�����";
                break;

            case "JUNE":
                translatedMonth = "�������";
                break;

            case "JULY":
                translatedMonth = "�������";
                break;

            case "AUGUST":
                translatedMonth = "���������";
                break;

            case "SEPTEMBER":
                translatedMonth = "�����������";
                break;

            case "OCTOBER":
                translatedMonth = "���������";
                break;

            case "NOVEMBER":
                translatedMonth = "���������";
                break;

            case "DECEMBER":
                translatedMonth = "����������";
                break;

            default:
                translatedMonth = month;
                break;
        }
        return translatedDay + ", " + dayMonth + " " + translatedMonth + " " + year + " - " + formatDigits( hour ) + ":"
                + formatDigits( minute );
    }

    private String formatDigits( final int number ) {
        if ( String.valueOf( number ).length() == 1 ) {
            return "0" + number;
        }
        return String.valueOf( number );
    }
}
