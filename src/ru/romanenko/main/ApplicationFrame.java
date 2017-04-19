package ru.romanenko.main;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.text.NumberFormat;

import javax.swing.border.TitledBorder;
//import javax.swing.text.NumberFormatter;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.SystemColor;

public class ApplicationFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	static JTextField dayTf;
	static JTextField monthTf;
	static JTextField yearTf;
	static JTextField hoursTf;
	static JTextField minutesTf;
	static JTextField secondsTf;
	
	private JLabel dayLabel;
	private JLabel monthLabel;
	private JLabel yearLabel;
	private JLabel hoursLabel;
	private JLabel minutesLabel;
	private JLabel secondsLabel;
	
	private JLabel unixtimestampLabel;
	private JLabel unixtimestampHexLabel;
	private JLabel countDaysLabel;
	private JLabel countDaysHexLabel;
	
	static JTextField unixdateTf;
	static JTextField unixTsHexTf;
	static JTextField countDaysTf;
	static JTextField countDaysHexTf;
	public static String inputDate;
	
	private JLabel inputDateLabel;
	//private JFormattedTextField formattedTextField;

	/**
	 * Create the frame.
	 */
	public ApplicationFrame() {
		super("Конвертер дат");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{60, 50, 20, 90, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		/* 
		 * Панель для ввода исходной даты. 
		 * Содержит лейблы и текстовые поля для ввода ДД-ММ-ГГГГ ЧЧ-ММ-СС
		 */
		
		JPanel inputDatePanel = new JPanel();
		inputDatePanel.setBorder(new TitledBorder(new LineBorder(new Color(109, 109, 109), 1, true), "\u0418\u0441\u0445\u043E\u0434\u043D\u0430\u044F \u0434\u0430\u0442\u0430", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_inputDatePanel = new GridBagConstraints();
		gbc_inputDatePanel.gridwidth = 9;
		gbc_inputDatePanel.insets = new Insets(0, 0, 5, 0);
		gbc_inputDatePanel.fill = GridBagConstraints.BOTH;
		gbc_inputDatePanel.gridx = 0;
		gbc_inputDatePanel.gridy = 0;
		contentPane.add(inputDatePanel, gbc_inputDatePanel);
		GridBagLayout gbl_inputDatePanel = new GridBagLayout();
		gbl_inputDatePanel.columnWidths = new int[]{120, 40, 40, 40, 40, 40, 40, 0};
		gbl_inputDatePanel.rowHeights = new int[]{14, 0, 0};
		gbl_inputDatePanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_inputDatePanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		inputDatePanel.setLayout(gbl_inputDatePanel);
		
		dayLabel = new JLabel("ДД");
		GridBagConstraints gbc_dayLabel = new GridBagConstraints();
		gbc_dayLabel.insets = new Insets(0, 0, 5, 5);
		gbc_dayLabel.gridx = 1;
		gbc_dayLabel.gridy = 0;
		inputDatePanel.add(dayLabel, gbc_dayLabel);
		
		monthLabel = new JLabel("\u041C\u041C");
		GridBagConstraints gbc_monthLabel = new GridBagConstraints();
		gbc_monthLabel.insets = new Insets(0, 0, 5, 5);
		gbc_monthLabel.gridx = 2;
		gbc_monthLabel.gridy = 0;
		inputDatePanel.add(monthLabel, gbc_monthLabel);
		
		yearLabel = new JLabel("\u0413\u0413\u0413\u0413");
		GridBagConstraints gbc_yearLabel = new GridBagConstraints();
		gbc_yearLabel.insets = new Insets(0, 0, 5, 5);
		gbc_yearLabel.gridx = 3;
		gbc_yearLabel.gridy = 0;
		inputDatePanel.add(yearLabel, gbc_yearLabel);
		
		hoursLabel = new JLabel("\u0427\u0427");
		GridBagConstraints gbc_hoursLabel = new GridBagConstraints();
		gbc_hoursLabel.insets = new Insets(0, 0, 5, 5);
		gbc_hoursLabel.gridx = 4;
		gbc_hoursLabel.gridy = 0;
		inputDatePanel.add(hoursLabel, gbc_hoursLabel);
		
		minutesLabel = new JLabel("\u041C\u041C");
		GridBagConstraints gbc_minutesLabel = new GridBagConstraints();
		gbc_minutesLabel.insets = new Insets(0, 0, 5, 5);
		gbc_minutesLabel.gridx = 5;
		gbc_minutesLabel.gridy = 0;
		inputDatePanel.add(minutesLabel, gbc_minutesLabel);
		
		secondsLabel = new JLabel("\u0421\u0421");
		GridBagConstraints gbc_secondsLabel = new GridBagConstraints();
		gbc_secondsLabel.insets = new Insets(0, 0, 5, 0);
		gbc_secondsLabel.gridx = 6;
		gbc_secondsLabel.gridy = 0;
		inputDatePanel.add(secondsLabel, gbc_secondsLabel);
		
		inputDateLabel = new JLabel("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0434\u0430\u0442\u0443:");
		GridBagConstraints gbc_inputDateLabel = new GridBagConstraints();
		gbc_inputDateLabel.insets = new Insets(0, 0, 0, 5);
		gbc_inputDateLabel.anchor = GridBagConstraints.NORTH;
		gbc_inputDateLabel.gridx = 0;
		gbc_inputDateLabel.gridy = 1;
		inputDatePanel.add(inputDateLabel, gbc_inputDateLabel);
		
		dayTf = new JTextField();
		GridBagConstraints gbc_dayTf = new GridBagConstraints();
		gbc_dayTf.fill = GridBagConstraints.HORIZONTAL;
		gbc_dayTf.insets = new Insets(0, 0, 0, 5);
		gbc_dayTf.gridx = 1;
		gbc_dayTf.gridy = 1;
		inputDatePanel.add(dayTf, gbc_dayTf);
		dayTf.setColumns(10);
		
		monthTf = new JTextField();
		GridBagConstraints gbc_monthTf = new GridBagConstraints();
		gbc_monthTf.fill = GridBagConstraints.HORIZONTAL;
		gbc_monthTf.insets = new Insets(0, 0, 0, 5);
		gbc_monthTf.gridx = 2;
		gbc_monthTf.gridy = 1;
		inputDatePanel.add(monthTf, gbc_monthTf);
		monthTf.setColumns(10);
		
		yearTf = new JTextField();
		GridBagConstraints gbc_yearTf = new GridBagConstraints();
		gbc_yearTf.fill = GridBagConstraints.HORIZONTAL;
		gbc_yearTf.insets = new Insets(0, 0, 0, 5);
		gbc_yearTf.gridx = 3;
		gbc_yearTf.gridy = 1;
		inputDatePanel.add(yearTf, gbc_yearTf);
		yearTf.setColumns(10);
		
		
		hoursTf = new JTextField();
		GridBagConstraints gbc_hoursTf = new GridBagConstraints();
		gbc_hoursTf.fill = GridBagConstraints.HORIZONTAL;
		gbc_hoursTf.insets = new Insets(0, 0, 0, 5);
		gbc_hoursTf.gridx = 4;
		gbc_hoursTf.gridy = 1;
		inputDatePanel.add(hoursTf, gbc_hoursTf);
		hoursTf.setColumns(10);
		
		minutesTf = new JTextField();
		GridBagConstraints gbc_minutesTf = new GridBagConstraints();
		gbc_minutesTf.insets = new Insets(0, 0, 0, 5);
		gbc_minutesTf.fill = GridBagConstraints.HORIZONTAL;
		gbc_minutesTf.gridx = 5;
		gbc_minutesTf.gridy = 1;
		inputDatePanel.add(minutesTf, gbc_minutesTf);
		minutesTf.setColumns(10);
		
		secondsTf = new JTextField();
		GridBagConstraints gbc_secondsTf = new GridBagConstraints();
		gbc_secondsTf.fill = GridBagConstraints.HORIZONTAL;
		gbc_secondsTf.gridx = 6;
		gbc_secondsTf.gridy = 1;
		inputDatePanel.add(secondsTf, gbc_secondsTf);
		secondsTf.setColumns(10);
		
		/*
		 * Панель для вывода полученной даты: unixtimestamp, unixtimestamp в HEX, количество дней
		 * с 1970 года, количество дней с 1970 года в HEX
		 */
		
		JPanel resultDatePanel = new JPanel();
		resultDatePanel.setBorder(new TitledBorder(new LineBorder(new Color(109, 109, 109)), "\u0420\u0435\u0437\u0443\u043B\u044C\u0442\u0430\u0442", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.desktop));
		GridBagConstraints gbc_resultDatePanel = new GridBagConstraints();
		gbc_resultDatePanel.insets = new Insets(0, 0, 5, 0);
		gbc_resultDatePanel.gridwidth = 9;
		gbc_resultDatePanel.gridheight = 2;
		gbc_resultDatePanel.fill = GridBagConstraints.BOTH;
		gbc_resultDatePanel.gridx = 0;
		gbc_resultDatePanel.gridy = 2;
		contentPane.add(resultDatePanel, gbc_resultDatePanel);
		GridBagLayout gbl_resultDatePanel = new GridBagLayout();
		gbl_resultDatePanel.columnWidths = new int[]{16, 16, 30, 14, 10, 1, 14, 30, 9, 72, 9, 86, 0};
		gbl_resultDatePanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_resultDatePanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_resultDatePanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		resultDatePanel.setLayout(gbl_resultDatePanel);
		
		
		
	/*	NumberFormat  format = NumberFormat.getInstance();
	    format.setParseIntegerOnly(true);

	    NumberFormatter formatter = new NumberFormatter(format);
	    formatter.setMinimum(1);
	    formatter.setMaximum(100);
	    formatter.setAllowsInvalid(false);
	    formatter.setOverwriteMode(true);  
	    
	    formattedTextField = new JFormattedTextField(formatter);
	    
	    formattedTextField.setColumns(5);
	    formattedTextField.setValue(1);
	    
		formattedTextField.setHorizontalAlignment(SwingConstants.TRAILING);
		formattedTextField.setText("\u041F\u043E\u043B\u0435 \u0432\u0432\u043E\u0434\u0430");
		formattedTextField.setColumns(3);
		formattedTextField.setBackground(SystemColor.controlHighlight);
		GridBagConstraints gbc_formattedTextField = new GridBagConstraints();
		gbc_formattedTextField.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextField.gridx = 3;
		gbc_formattedTextField.gridy = 1;
		resultDatePanel.add(formattedTextField, gbc_formattedTextField); */
		
		unixtimestampLabel = new JLabel("UnixTimeStamp");
		unixtimestampLabel.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_unixtimestampLabel = new GridBagConstraints();
		gbc_unixtimestampLabel.gridwidth = 4;
		gbc_unixtimestampLabel.anchor = GridBagConstraints.WEST;
		gbc_unixtimestampLabel.insets = new Insets(0, 0, 5, 5);
		gbc_unixtimestampLabel.gridx = 3;
		gbc_unixtimestampLabel.gridy = 2;
		resultDatePanel.add(unixtimestampLabel, gbc_unixtimestampLabel);
		
		unixdateTf = new JTextField();
		GridBagConstraints gbc_unixdateTf = new GridBagConstraints();
		gbc_unixdateTf.gridwidth = 3;
		gbc_unixdateTf.insets = new Insets(0, 0, 5, 5);
		gbc_unixdateTf.fill = GridBagConstraints.HORIZONTAL;
		gbc_unixdateTf.gridx = 8;
		gbc_unixdateTf.gridy = 2;
		resultDatePanel.add(unixdateTf, gbc_unixdateTf);
		unixdateTf.setColumns(10);
		unixdateTf.setEditable(false);
		
		unixtimestampHexLabel = new JLabel("UnixTimeStamp \u0432 HEX");
		unixtimestampHexLabel.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_unixtimestampHexLabel = new GridBagConstraints();
		gbc_unixtimestampHexLabel.gridwidth = 4;
		gbc_unixtimestampHexLabel.anchor = GridBagConstraints.WEST;
		gbc_unixtimestampHexLabel.insets = new Insets(0, 0, 5, 5);
		gbc_unixtimestampHexLabel.gridx = 3;
		gbc_unixtimestampHexLabel.gridy = 3;
		resultDatePanel.add(unixtimestampHexLabel, gbc_unixtimestampHexLabel);
		
		unixTsHexTf = new JTextField();
		GridBagConstraints gbc_unixTsHexTf = new GridBagConstraints();
		gbc_unixTsHexTf.gridwidth = 3;
		gbc_unixTsHexTf.insets = new Insets(0, 0, 5, 5);
		gbc_unixTsHexTf.fill = GridBagConstraints.HORIZONTAL;
		gbc_unixTsHexTf.gridx = 8;
		gbc_unixTsHexTf.gridy = 3;
		resultDatePanel.add(unixTsHexTf, gbc_unixTsHexTf);
		unixTsHexTf.setColumns(10);
		unixTsHexTf.setEditable(false);
		
		countDaysLabel = new JLabel("\u041A\u043E\u043B\u0438\u0447\u0435\u0441\u0442\u0432\u043E \u0434\u043D\u0435\u0439 \u0441 01.01.1970");
		countDaysLabel.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_countDaysLabel = new GridBagConstraints();
		gbc_countDaysLabel.gridwidth = 4;
		gbc_countDaysLabel.anchor = GridBagConstraints.WEST;
		gbc_countDaysLabel.insets = new Insets(0, 0, 5, 5);
		gbc_countDaysLabel.gridx = 3;
		gbc_countDaysLabel.gridy = 4;
		resultDatePanel.add(countDaysLabel, gbc_countDaysLabel);
		
		countDaysTf = new JTextField();
		GridBagConstraints gbc_countDaysTf = new GridBagConstraints();
		gbc_countDaysTf.gridwidth = 3;
		gbc_countDaysTf.insets = new Insets(0, 0, 5, 5);
		gbc_countDaysTf.fill = GridBagConstraints.HORIZONTAL;
		gbc_countDaysTf.gridx = 8;
		gbc_countDaysTf.gridy = 4;
		resultDatePanel.add(countDaysTf, gbc_countDaysTf);
		countDaysTf.setColumns(10);
		countDaysTf.setEditable(false);
		
		countDaysHexLabel = new JLabel("\u041A\u043E\u043B\u0438\u0447\u0435\u0441\u0442\u0432\u043E \u0434\u043D\u0435\u0439 \u0441 01.01.1970 \u0432 HEX");
		countDaysHexLabel.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_countDaysHexLabel = new GridBagConstraints();
		gbc_countDaysHexLabel.gridwidth = 4;
		gbc_countDaysHexLabel.anchor = GridBagConstraints.WEST;
		gbc_countDaysHexLabel.insets = new Insets(0, 0, 0, 5);
		gbc_countDaysHexLabel.gridx = 3;
		gbc_countDaysHexLabel.gridy = 5;
		resultDatePanel.add(countDaysHexLabel, gbc_countDaysHexLabel);
		
		countDaysHexTf = new JTextField();
		GridBagConstraints gbc_countDaysHexTf = new GridBagConstraints();
		gbc_countDaysHexTf.insets = new Insets(0, 0, 0, 5);
		gbc_countDaysHexTf.gridwidth = 3;
		gbc_countDaysHexTf.fill = GridBagConstraints.HORIZONTAL;
		gbc_countDaysHexTf.gridx = 8;
		gbc_countDaysHexTf.gridy = 5;
		resultDatePanel.add(countDaysHexTf, gbc_countDaysHexTf);
		countDaysHexTf.setColumns(10);
		countDaysHexTf.setEditable(false);
		
		/*
		 * Панель для кнопки "Перевести" 
		 */
		
		JPanel buttonPanel = new JPanel();
		GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
		gbc_buttonPanel.gridwidth = 9;
		gbc_buttonPanel.insets = new Insets(0, 0, 5, 0);
		gbc_buttonPanel.fill = GridBagConstraints.BOTH;
		gbc_buttonPanel.gridx = 0;
		gbc_buttonPanel.gridy = 1;
		contentPane.add(buttonPanel, gbc_buttonPanel);
		
		JButton convertButton = new JButton("Перевести");
		buttonPanel.add(convertButton);
		
		convertButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				inputDate = GetInputDate();
				try {
					ConvertHumanDate(inputDate);
				} catch (ParseException | java.text.ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			});
		
		
	}
	
	public static String GetInputDate() {
		
		String inputDate = "";
		String inputDay = ApplicationFrame.dayTf.getText();
		String inputMonth = ApplicationFrame.monthTf.getText();
		String inputYear = ApplicationFrame.yearTf.getText();
		String inputHours = ApplicationFrame.hoursTf.getText();
		String inputMinutes = ApplicationFrame.minutesTf.getText();
		String inputSeconds = ApplicationFrame.secondsTf.getText();
		inputDate = inputDay.concat("-").concat(inputMonth.concat("-").concat(inputYear).concat("-").concat(inputHours).concat("-").concat(inputMinutes).concat("-").concat(inputSeconds));
		return inputDate;
		
	}
	
	public static void ConvertHumanDate(String inputDate) throws ParseException, java.text.ParseException {
		
		ApplicationFrame.unixdateTf.setText(Long.toString(ConversionMethods.ToTimeStamp(inputDate)));
		ApplicationFrame.unixTsHexTf.setText(ConversionMethods.TimeStampToHex(ConversionMethods.ToTimeStamp(inputDate)));
		ApplicationFrame.countDaysTf.setText(Integer.toString(ConversionMethods.TimeStampToUnixDays(ConversionMethods.ToTimeStamp(inputDate))));
		ApplicationFrame.countDaysHexTf.setText(ConversionMethods.UnixDaysToHex(ConversionMethods.TimeStampToUnixDays(ConversionMethods.ToTimeStamp(inputDate))));
	
	}
	
}
