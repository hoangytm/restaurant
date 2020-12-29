package hoangytm.restaurant.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author PhanHoang
 * 12/26/2020
 */
public class DateUtils {
    Calendar calendar;

    public DateUtils(Date date) {
        this.calendar = Calendar.getInstance();
        this.calendar.setTime(date);
    }

    public static DateUtils of(Date date) {
        return new DateUtils(date);
    }

    public static DateUtils of(Long time) {
        return new DateUtils(new Date(time));
    }

    public DateUtils addDate(int amount) {
        this.calendar.add(Calendar.DAY_OF_WEEK, amount);
        return this;
    }

    public DateUtils addMinutes(int amount) {
        this.calendar.add(Calendar.MINUTE, amount);
        return this;
    }

    public DateUtils truncDate() {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return this;
    }

    public String format(String format) {
        return new SimpleDateFormat(format).format(calendar.getTime());
    }

    public Date toDate() {
        return this.calendar.getTime();
    }
}
