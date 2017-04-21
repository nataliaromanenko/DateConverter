package ru.romanenko.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputTextValidator {
	
private static Pattern dayPattern;
private static Matcher dayMatcher;
private static Pattern monthPattern;
private static Matcher monthMatcher;
private static Pattern yearPattern;
private static Matcher yearMatcher;

private static Pattern hoursPattern;
private static Matcher hoursMatcher;
private static Pattern minutesPattern;
private static Matcher minutesMatcher;
private static Pattern secondsPattern;
private static Matcher secondsMatcher;

private static final String DAY_PATTERN = "(0[1-9]|[12][0-9]|3[01])";
private static final String MONTH_PATTERN = "(0[1-9]|1[012])";
private static final String YEAR_PATTERN = "(197\\d|198\\d|199\\d|20\\d\\d)";

private static final String HOURS_PATTERN = "(0[0-9]|[1][0-9]|2[0-3])";
private static final String MINUTES_PATTERN = "(0[0-9]|[012345][0-9])";
private static final String SECONDS_PATTERN = "(0[0-9]|[012345][0-9])";

	public static boolean checkDayTfWithRegExp(String inputDay) {
		dayPattern = Pattern.compile(DAY_PATTERN);
		dayMatcher = dayPattern.matcher(inputDay);
	    return dayMatcher.matches();
	}
	
	public static boolean checkMonthTfWithRegExp(String inputMonth) {
		monthPattern = Pattern.compile(MONTH_PATTERN);
		monthMatcher = monthPattern.matcher(inputMonth);
	    return monthMatcher.matches();
	}
	
	public static boolean checkYearTfWithRegExp(String inputYear) {
		yearPattern = Pattern.compile(YEAR_PATTERN);
		yearMatcher = yearPattern.matcher(inputYear);
	    return yearMatcher.matches();
	}
	
	public static boolean checkHoursTfWithRegExp(String inputHours) {
		hoursPattern = Pattern.compile(HOURS_PATTERN);
		hoursMatcher = hoursPattern.matcher(inputHours);
	    return hoursMatcher.matches();
	}
	
	public static boolean checkMinutesTfWithRegExp(String inputMinutes) {
		minutesPattern = Pattern.compile(MINUTES_PATTERN);
		minutesMatcher = minutesPattern.matcher(inputMinutes);
	    return minutesMatcher.matches();
	}
	
	public static boolean checkSecondsTfWithRegExp(String inputSeconds) {
		secondsPattern = Pattern.compile(SECONDS_PATTERN);
		secondsMatcher = secondsPattern.matcher(inputSeconds);
	    return secondsMatcher.matches();
	}
	
	
}
