package ru.romanenko.main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

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

	//Methods checking input date with regular expressions
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
	
	//Methods for input text validation
		public static void ValidateInputDayText(ArrayList<String> textResultTFList) throws ParseException, java.text.ParseException{
			boolean dayValidation = InputTextValidator.checkDayTfWithRegExp(textResultTFList.get(0));
			if (dayValidation == true) {
				ValidateInputMonthText(textResultTFList);
			}
			else {
				JOptionPane.showMessageDialog(ApplicationFrame.contentPane, "Некорректно введен день", "Ошибка", JOptionPane.WARNING_MESSAGE);
			}
		}
		
		public static void ValidateInputMonthText(ArrayList<String> textResultTFList) throws ParseException, java.text.ParseException{
			boolean monthValidation = InputTextValidator.checkMonthTfWithRegExp(textResultTFList.get(1));
			if (monthValidation == true) {
				try {
					SimpleDateFormat df = new SimpleDateFormat("ddMM");
					df.setLenient(false);
					String inputDateDdMm = (textResultTFList.get(0)).concat(textResultTFList.get(1));
					java.util.Date dateDdMm = df.parse(inputDateDdMm);
					System.out.println(dateDdMm);
					ValidateInputYearText(textResultTFList);
				}
				catch (Exception e) {
					String day =  textResultTFList.get(0);
					String month = textResultTFList.get(1);
					System.out.println(day);
					System.out.println(month);
					if (day.equals("29") & month.equals("02")){
						JOptionPane.showMessageDialog(ApplicationFrame.contentPane, "<html><table width=350>" + "Указанный год не является високосным. Недопустимое сочетание дня и месяца: 29 февраля", "Ошибка", JOptionPane.WARNING_MESSAGE);
					}
						else if (day.equals("31") & Arrays.asList(new String[]{"02", "04", "06", "09",
			                        "11"}).contains(month)) {
							JOptionPane.showMessageDialog(ApplicationFrame.contentPane, "В указанном месяце не может быть 31-го числа", "Ошибка", JOptionPane.WARNING_MESSAGE);
							}						
						else {
							System.out.println("Неизвестная ошибка");
							}
					}
				}
			else {
				JOptionPane.showMessageDialog(ApplicationFrame.contentPane, "Некорректно введен месяц", "Ошибка", JOptionPane.WARNING_MESSAGE);
				}
			}
		
		public static void ValidateInputYearText(ArrayList<String> textResultTFList) throws ParseException, java.text.ParseException{
			boolean yearValidation = InputTextValidator.checkYearTfWithRegExp(textResultTFList.get(2));
			if (yearValidation == true) {
				ValidateInputHoursText(textResultTFList);
			}
			else {
				JOptionPane.showMessageDialog(ApplicationFrame.contentPane, "Некорректно введен год", "Ошибка", JOptionPane.WARNING_MESSAGE);
			}
		}
		
		public static void ValidateInputHoursText(ArrayList<String> textResultTFList) throws ParseException, java.text.ParseException{
			boolean hoursValidation = InputTextValidator.checkHoursTfWithRegExp(textResultTFList.get(3));
			if (hoursValidation == true) {
				ValidateInputMinutesText(textResultTFList);
			}
			else {
				JOptionPane.showMessageDialog(ApplicationFrame.contentPane, "Некорректно введен час", "Ошибка", JOptionPane.WARNING_MESSAGE);
			}
		}
		
		public static void ValidateInputMinutesText(ArrayList<String> textResultTFList) throws ParseException, java.text.ParseException{
			boolean minutesValidation = InputTextValidator.checkMinutesTfWithRegExp(textResultTFList.get(4));
			if (minutesValidation == true) {
				ValidateInputSecondsText(textResultTFList);
			}
			else {
				JOptionPane.showMessageDialog(ApplicationFrame.contentPane, "Некорректно введены минуты", "Ошибка", JOptionPane.WARNING_MESSAGE);
			}
		}
		
		public static void ValidateInputSecondsText(ArrayList<String> textResultTFList) throws ParseException, java.text.ParseException{
			boolean secondsValidation = InputTextValidator.checkSecondsTfWithRegExp(textResultTFList.get(5));
			if (secondsValidation == true) {
				ApplicationFrame.ConvertUsualDate(ApplicationFrame.GetInputDate(ApplicationFrame.createInputTextFieldsList()));
			}
			else {
				JOptionPane.showMessageDialog(ApplicationFrame.contentPane, "Некорректно введены секунды", "Ошибка", JOptionPane.WARNING_MESSAGE);
			}
		}
}
