package hoangytm.restaurant.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author PhanHoang 2/26/2020
 */
public class DateTimeUtils {


  public static Date addDate(Date date, int i) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.add(Calendar.DATE, i);
    return cal.getTime();
  }

  /**
   * Creates a new instance of DateTimeUtils
   */
  public DateTimeUtils() {
  }

  /**
   * chuyen tu dang yyyyMMdd ve dang MM/dd/yyyy
   *
   * @param isoDate
   * @return
   */
  public static Long convertIsoDateToTime(String isoDate) {
    try {

      Date date = convertStringToTime(isoDate, "yyyyMMdd");
      return date.getTime();
    } catch (Exception ex) {
      return 0L;
    }
  }

  public static String formatIsoDate(String isoDate) {
    Date tmp = new Date(convertIsoDateToTime(isoDate));
    return convertDateTimeToString("yyyy/MM/dd", tmp);
  }

  public static String getDDMMYYYYDate(String date) {
    return date.replace("/", "");
  }

  public static String createYYYYMMDD(String date) {
    String[] strs = date.split("/");
    String temp = "";
    for (int i = strs.length - 1; i >= 0; i--) {
      temp = temp + strs[i];
    }
    return temp;
  }

  public static Date convertStringToTime(String date, String pattern) {
    SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
    try {
      return dateFormat.parse(date);

    } catch (ParseException e) {
      System.out.println("Date ParseException, string value:" + date);
    }
    return null;
  }

  public static Date convertStringToDate(String date) throws Exception {
    //String pattern = "dd/MM/yyyy";
    String pattern = "yyyy-MM-dd";
    return convertStringToTime(date, pattern);
  }

  public static String convertDateToString(Date date) throws Exception {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    if (date == null) {
      return "";
    }
    try {
      return dateFormat.format(date);
    } catch (Exception e) {
      throw e;
    }
  }

  public static String getSysdate() throws Exception {
    Calendar calendar = Calendar.getInstance();
    return convertDateToString(calendar.getTime());
  }

  public static String getSysDateTime() throws Exception {
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    try {
      return dateFormat.format(calendar.getTime());
    } catch (Exception e) {
      throw e;
    }
  }

  public static String getSysDateTime(String pattern) throws Exception {
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
    try {
      return dateFormat.format(calendar.getTime());
    } catch (Exception e) {
      throw e;
    }
  }

  public static Date convertStringToDateTime(String date) throws Exception {
    String pattern = "dd/MM/yyyy HH:mm:ss";
    return convertStringToTime(date, pattern);
  }

  public static String convertDateTimeToString(Date date) throws Exception {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    try {
      return dateFormat.format(date);
    } catch (Exception e) {
      throw e;
    }
  }

  public static String convertDateTimeToFullString(Date date) throws Exception {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    try {
      return dateFormat.format(date);
    } catch (Exception e) {
      throw e;
    }
  }

  public static String convertHourToString(Date date) throws Exception {
    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    try {
      return dateFormat.format(date);
    } catch (Exception e) {
      throw e;
    }
  }

  public static String convertDateTimeToString(String pattern, Date date) {
    if (date == null || pattern == null) {
      return "";
    }
    SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
    return dateFormat.format(date);
  }

  public static java.sql.Date convertToSqlDate(Date utilDate) {
    return new java.sql.Date(utilDate.getTime());
  }

  public static String parseDate(int monthInput) {
    String dateReturn = "01/01/";
    Calendar cal = Calendar.getInstance();
    switch (monthInput) {
      case 1:
        dateReturn = "01/01/";
        break;
      case 2:
        dateReturn = "01/02/";
        break;
      case 3:
        dateReturn = "01/03/";
        break;
      case 4:
        dateReturn = "01/04/";
        break;
      case 5:
        dateReturn = "01/05/";
        break;
      case 6:
        dateReturn = "01/06/";
        break;
      case 7:
        dateReturn = "01/07/";
        break;
      case 8:
        dateReturn = "01/08/";
        break;
      case 9:
        dateReturn = "01/09/";
        break;
      case 10:
        dateReturn = "01/10/";
        break;
      case 11:
        dateReturn = "01/11/";
        break;
      case 12:
        dateReturn = "01/12/";
        break;
    }
    return dateReturn + cal.get(Calendar.YEAR);
  }

  public static Date getStartDate(Date fromDate) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(fromDate);
    cal.set(Calendar.HOUR_OF_DAY, 0);
    cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.SECOND, 0);
    cal.set(Calendar.MILLISECOND, 0);
    return cal.getTime();
  }

  public static Date getEndDate(Date toDate) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(toDate);
    cal.set(Calendar.HOUR_OF_DAY, 23);
    cal.set(Calendar.MINUTE, 59);
    cal.set(Calendar.SECOND, 59);
    cal.set(Calendar.MILLISECOND, 999);
    return cal.getTime();
  }

  public static Date addDate(Date dateAdd, int field, int amount) {

    Calendar cal = Calendar.getInstance();
    cal.setTime(dateAdd);

    cal.add(field, amount);

    return cal.getTime();

  }

  public static String convertDateTimeToMonthData(Date date) throws Exception {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
    try {
      return dateFormat.format(date);
    } catch (Exception e) {
      throw e;
    }
  }

  public static int getFullYearFromDate(Date date) throws Exception {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
    try {
      return Integer.parseInt(dateFormat.format(date));
    } catch (Exception e) {
      throw e;
    }
  }

}
