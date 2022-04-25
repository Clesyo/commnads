package br.com.command.client.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public abstract class Utils {

	public static Date parse(String parseDate) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return sdf.parse(parseDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static String parse(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = sdf.format(date);
		return strDate;
	}

	public static String normalizeToQuery(String query) {
		String newQuery = StringUtils.stripAccents(query);
		newQuery = StringUtils.upperCase(newQuery);
		newQuery = StringUtils.deleteWhitespace(newQuery);

		StringBuilder ret = new StringBuilder();
		Matcher matches = Pattern.compile("[A-Z0-9]").matcher(newQuery);
		while (matches.find()) {
			ret.append(matches.group(0));
		}

		return ret.toString();
	}
}
