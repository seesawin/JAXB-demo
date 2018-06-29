package tw.com.seesawin.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.apache.commons.lang3.time.DateUtils;

public class DateAdapter extends XmlAdapter<String, String> {
	
	@Override
	public String unmarshal(String dateStr) throws Exception {
		Date date = formatDate(dateStr,"yyyy-MM-dd");
		return transferDate(date, "MMM/dd/yyyy", Locale.ENGLISH);
	}

	@Override
	public String marshal(String date) throws Exception {
		return null;
	}
	
	public static Date formatDate(String strDate, String pattern) {
		Date d = null;
		try {
			d = DateUtils.parseDate(strDate, new String[]{pattern});
		}
		catch (Exception e) {}
		
		return d;
	}

	public static String transferDate(Date date, String pattern, Locale locale) {
		SimpleDateFormat df = new SimpleDateFormat(pattern, locale);
		String s = null;
		try {
			s = df.format(date);
		} catch (Exception e) {
		}

		return s;
	}

}
