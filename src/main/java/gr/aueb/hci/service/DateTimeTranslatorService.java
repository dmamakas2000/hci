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
                translatedDay = "Δευτέρα";
                break;

            case "TUESDAY":
                translatedDay = "Τρίτη";
                break;

            case "WEDNESDAY":
                translatedDay = "Τετάρτη";
                break;

            case "THURSDAY":
                translatedDay = "Πέμπτη";
                break;

            case "FRIDAY":
                translatedDay = "Παρασκευή";
                break;

            case "SATURDAY":
                translatedDay = "Σάββατο";
                break;

            case "SUNDAY":
                translatedDay = "Κυριακή";
                break;

            default:
                translatedDay = day;
                break;
        }

        String translatedMonth = "";
        switch ( month ) {
            case "JANUARY":
                translatedMonth = "Ιανουαρίου";
                break;

            case "FEBRUARY":
                translatedMonth = "Φεβρουαρίου";
                break;

            case "MARCH":
                translatedMonth = "Μαρτίου";
                break;

            case "APRIL":
                translatedMonth = "Απριλίου";
                break;

            case "MAY":
                translatedMonth = "Μαΐου";
                break;

            case "JUNE":
                translatedMonth = "Ιουνίου";
                break;

            case "JULY":
                translatedMonth = "Ιουλίου";
                break;

            case "AUGUST":
                translatedMonth = "Αυγούστου";
                break;

            case "SEPTEMBER":
                translatedMonth = "Σεπτεμβρίου";
                break;

            case "OCTOBER":
                translatedMonth = "Οκτωβρίου";
                break;

            case "NOVEMBER":
                translatedMonth = "Νοεμβρίου";
                break;

            case "DECEMBER":
                translatedMonth = "Δεκεμβρίου";
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
