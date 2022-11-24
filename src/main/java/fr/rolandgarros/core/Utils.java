package fr.rolandgarros.core;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Utils {
    public static final DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
    public static final DateFormat dateFormatHTMLInput = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");

    public static String formatDuration(Timestamp start, Timestamp end) {
        if (end.before(start)) {
            throw new IllegalArgumentException("Start happens later than end.");
        }
        long seconds = (end.getTime() - start.getTime()) / 1_000L;
        return String.format("%d:%02d:%02d", seconds / 3600, (seconds % 3600) / 60, (seconds % 60));
    }
}
