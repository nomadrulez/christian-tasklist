package com.supero.tasklist.utils;

/**
 * Created by christian.tusset on 12/03/2018.
 */

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DateUtils {
	private static final String nameClass = DateUtils.class.getName();
	private static final Logger log = Logger.getLogger(nameClass);

	public static String dateTimeToString(Date date) {
		return date.toLocaleString();
	}
	
	public static Date getCurrentDate() {
		Date currentDate = getCurrentDateWithTimeZone().getTime();
		return currentDate;
	}
	
	public static Calendar getCurrentDateWithTimeZone() {
		Date currentDate = new Date();
		Calendar calendar = new GregorianCalendar();
		Calendar calendarResult = new GregorianCalendar();

		TimeZone timeZone = TimeZone.getTimeZone("America/Sao_Paulo");

		if (timeZone != null) {

			try {
				calendar.setTime(currentDate);
				calendar.setTimeZone(timeZone);

				calendarResult.set(calendar.get(Calendar.YEAR),
						calendar.get(Calendar.MONTH),
						calendar.get(Calendar.DAY_OF_MONTH),
						calendar.get(Calendar.HOUR_OF_DAY),
						calendar.get(Calendar.MINUTE));

			} catch (Exception e) {
				log.logp(Level.SEVERE, nameClass, "getCurrentDateWithTimeZone",
						"Erro ao obter data com TimeZone.", e);
				return null;
			}
		}
		return calendarResult;
	}
}
