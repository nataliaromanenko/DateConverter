package ru.romanenko.main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JSeparator;
import javax.swing.border.TitledBorder;

public class DateConverterFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JTextField dayTf;
	static JTextField monthTf;
	static JTextField yearTf;
	static JTextField hoursTf;
	static JTextField minutesTf;
	static JTextField secondsTf;
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
	JLabel inputDateLabel;
	private JLabel label;
	private JLabel label_1;
	private JSeparator separator;

	/**
	 * Create the frame.
	 */
	public DateConverterFrame() {
		super("Конвертер дат");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 477);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "\u041A\u043E\u043D\u0432\u0435\u0440\u0442\u0435\u0440 \u0434\u0430\u0442", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 50, 50, 50, 50, 50, 50, 50, 50, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		label = new JLabel("\u0418\u0441\u0445\u043E\u0434\u043D\u0430\u044F \u0434\u0430\u0442\u0430:");
		label.setBackground(SystemColor.scrollbar);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.gridwidth = 8;
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 1;
		gbc_label.gridy = 1;
		contentPane.add(label, gbc_label);
		
		JLabel dayLabel = new JLabel("ДД");
		GridBagConstraints gbc_dayLabel = new GridBagConstraints();
		gbc_dayLabel.insets = new Insets(0, 0, 5, 5);
		gbc_dayLabel.gridx = 3;
		gbc_dayLabel.gridy = 3;
		contentPane.add(dayLabel, gbc_dayLabel);
		
		monthLabel = new JLabel("\u041C\u041C");
		GridBagConstraints gbc_monthLabel = new GridBagConstraints();
		gbc_monthLabel.insets = new Insets(0, 0, 5, 5);
		gbc_monthLabel.gridx = 4;
		gbc_monthLabel.gridy = 3;
		contentPane.add(monthLabel, gbc_monthLabel);
		
		yearLabel = new JLabel("\u0413\u0413\u0413\u0413");
		GridBagConstraints gbc_yearLabel = new GridBagConstraints();
		gbc_yearLabel.insets = new Insets(0, 0, 5, 5);
		gbc_yearLabel.gridx = 5;
		gbc_yearLabel.gridy = 3;
		contentPane.add(yearLabel, gbc_yearLabel);
		
		hoursLabel = new JLabel("\u0427\u0427");
		GridBagConstraints gbc_hoursLabel = new GridBagConstraints();
		gbc_hoursLabel.insets = new Insets(0, 0, 5, 5);
		gbc_hoursLabel.gridx = 6;
		gbc_hoursLabel.gridy = 3;
		contentPane.add(hoursLabel, gbc_hoursLabel);
		
		minutesLabel = new JLabel("\u041C\u041C");
		GridBagConstraints gbc_minutesLabel = new GridBagConstraints();
		gbc_minutesLabel.insets = new Insets(0, 0, 5, 5);
		gbc_minutesLabel.gridx = 7;
		gbc_minutesLabel.gridy = 3;
		contentPane.add(minutesLabel, gbc_minutesLabel);
		
		secondsLabel = new JLabel("\u0421\u0421");
		GridBagConstraints gbc_secondsLabel = new GridBagConstraints();
		gbc_secondsLabel.insets = new Insets(0, 0, 5, 0);
		gbc_secondsLabel.gridx = 8;
		gbc_secondsLabel.gridy = 3;
		contentPane.add(secondsLabel, gbc_secondsLabel);
		
		inputDateLabel = new JLabel("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0434\u0430\u0442\u0443:");
		GridBagConstraints gbc_inputDateLabel = new GridBagConstraints();
		gbc_inputDateLabel.gridwidth = 2;
		gbc_inputDateLabel.insets = new Insets(0, 0, 5, 5);
		gbc_inputDateLabel.anchor = GridBagConstraints.WEST;
		gbc_inputDateLabel.gridx = 1;
		gbc_inputDateLabel.gridy = 4;
		contentPane.add(inputDateLabel, gbc_inputDateLabel);
		
		dayTf = new JTextField();
		GridBagConstraints gbc_dayTf = new GridBagConstraints();
		gbc_dayTf.insets = new Insets(0, 0, 5, 5);
		gbc_dayTf.fill = GridBagConstraints.HORIZONTAL;
		gbc_dayTf.gridx = 3;
		gbc_dayTf.gridy = 4;
		contentPane.add(dayTf, gbc_dayTf);
		dayTf.setColumns(10);
		
		monthTf = new JTextField();
		GridBagConstraints gbc_monthTf = new GridBagConstraints();
		gbc_monthTf.insets = new Insets(0, 0, 5, 5);
		gbc_monthTf.fill = GridBagConstraints.HORIZONTAL;
		gbc_monthTf.gridx = 4;
		gbc_monthTf.gridy = 4;
		contentPane.add(monthTf, gbc_monthTf);
		monthTf.setColumns(10);
		
		yearTf = new JTextField();
		GridBagConstraints gbc_yearTf = new GridBagConstraints();
		gbc_yearTf.insets = new Insets(0, 0, 5, 5);
		gbc_yearTf.fill = GridBagConstraints.HORIZONTAL;
		gbc_yearTf.gridx = 5;
		gbc_yearTf.gridy = 4;
		contentPane.add(yearTf, gbc_yearTf);
		yearTf.setColumns(10);
		
		
		hoursTf = new JTextField();
		GridBagConstraints gbc_hoursTf = new GridBagConstraints();
		gbc_hoursTf.insets = new Insets(0, 0, 5, 5);
		gbc_hoursTf.fill = GridBagConstraints.HORIZONTAL;
		gbc_hoursTf.gridx = 6;
		gbc_hoursTf.gridy = 4;
		contentPane.add(hoursTf, gbc_hoursTf);
		hoursTf.setColumns(10);
		
		minutesTf = new JTextField();
		GridBagConstraints gbc_minutesTf = new GridBagConstraints();
		gbc_minutesTf.insets = new Insets(0, 0, 5, 5);
		gbc_minutesTf.fill = GridBagConstraints.HORIZONTAL;
		gbc_minutesTf.gridx = 7;
		gbc_minutesTf.gridy = 4;
		contentPane.add(minutesTf, gbc_minutesTf);
		minutesTf.setColumns(10);
		
		secondsTf = new JTextField();
		GridBagConstraints gbc_secondsTf = new GridBagConstraints();
		gbc_secondsTf.insets = new Insets(0, 0, 5, 0);
		gbc_secondsTf.fill = GridBagConstraints.HORIZONTAL;
		gbc_secondsTf.gridx = 8;
		gbc_secondsTf.gridy = 4;
		contentPane.add(secondsTf, gbc_secondsTf);
		secondsTf.setColumns(10);
		
		separator = new JSeparator();
		separator.setForeground(SystemColor.controlDkShadow);
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridwidth = 8;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 1;
		gbc_separator.gridy = 5;
		contentPane.add(separator, gbc_separator);
		
		JButton convertButton = new JButton("Перевести");
		GridBagConstraints gbc_convertButton = new GridBagConstraints();
		gbc_convertButton.gridwidth = 8;
		gbc_convertButton.insets = new Insets(0, 0, 5, 0);
		gbc_convertButton.gridx = 1;
		gbc_convertButton.gridy = 6;
		contentPane.add(convertButton, gbc_convertButton);
		
		
		
		label_1 = new JLabel("\u0420\u0435\u0437\u0443\u043B\u044C\u0442\u0430\u0442:");
		label_1.setBackground(SystemColor.scrollbar);
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.WEST;
		gbc_label_1.gridwidth = 8;
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 7;
		contentPane.add(label_1, gbc_label_1);
		
		unixtimestampLabel = new JLabel("UnixTimeStamp");
		unixtimestampLabel.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_unixtimestampLabel = new GridBagConstraints();
		gbc_unixtimestampLabel.gridwidth = 5;
		gbc_unixtimestampLabel.anchor = GridBagConstraints.WEST;
		gbc_unixtimestampLabel.insets = new Insets(0, 0, 5, 5);
		gbc_unixtimestampLabel.gridx = 1;
		gbc_unixtimestampLabel.gridy = 8;
		contentPane.add(unixtimestampLabel, gbc_unixtimestampLabel);
		
		unixdateTf = new JTextField();
		GridBagConstraints gbc_unixdateTf = new GridBagConstraints();
		gbc_unixdateTf.gridwidth = 3;
		gbc_unixdateTf.insets = new Insets(0, 0, 5, 0);
		gbc_unixdateTf.fill = GridBagConstraints.HORIZONTAL;
		gbc_unixdateTf.gridx = 6;
		gbc_unixdateTf.gridy = 8;
		contentPane.add(unixdateTf, gbc_unixdateTf);
		unixdateTf.setColumns(10);
		unixdateTf.setEditable(false);
		
		unixtimestampHexLabel = new JLabel("UnixTimeStamp \u0432 HEX");
		unixtimestampHexLabel.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_unixtimestampHexLabel = new GridBagConstraints();
		gbc_unixtimestampHexLabel.gridwidth = 5;
		gbc_unixtimestampHexLabel.anchor = GridBagConstraints.WEST;
		gbc_unixtimestampHexLabel.insets = new Insets(0, 0, 5, 5);
		gbc_unixtimestampHexLabel.gridx = 1;
		gbc_unixtimestampHexLabel.gridy = 9;
		contentPane.add(unixtimestampHexLabel, gbc_unixtimestampHexLabel);
		
		unixTsHexTf = new JTextField();
		GridBagConstraints gbc_unixTsHexTf = new GridBagConstraints();
		gbc_unixTsHexTf.gridwidth = 3;
		gbc_unixTsHexTf.insets = new Insets(0, 0, 5, 0);
		gbc_unixTsHexTf.fill = GridBagConstraints.HORIZONTAL;
		gbc_unixTsHexTf.gridx = 6;
		gbc_unixTsHexTf.gridy = 9;
		contentPane.add(unixTsHexTf, gbc_unixTsHexTf);
		unixTsHexTf.setColumns(10);
		unixTsHexTf.setEditable(false);
		
		countDaysLabel = new JLabel("\u041A\u043E\u043B\u0438\u0447\u0435\u0441\u0442\u0432\u043E \u0434\u043D\u0435\u0439 \u0441 01.01.1970");
		countDaysLabel.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_countDaysLabel = new GridBagConstraints();
		gbc_countDaysLabel.gridwidth = 5;
		gbc_countDaysLabel.anchor = GridBagConstraints.WEST;
		gbc_countDaysLabel.insets = new Insets(0, 0, 5, 5);
		gbc_countDaysLabel.gridx = 1;
		gbc_countDaysLabel.gridy = 10;
		contentPane.add(countDaysLabel, gbc_countDaysLabel);
		
		countDaysTf = new JTextField();
		GridBagConstraints gbc_countDaysTf = new GridBagConstraints();
		gbc_countDaysTf.gridwidth = 3;
		gbc_countDaysTf.insets = new Insets(0, 0, 5, 0);
		gbc_countDaysTf.fill = GridBagConstraints.HORIZONTAL;
		gbc_countDaysTf.gridx = 6;
		gbc_countDaysTf.gridy = 10;
		contentPane.add(countDaysTf, gbc_countDaysTf);
		countDaysTf.setColumns(10);
		countDaysTf.setEditable(false);
		
		countDaysHexLabel = new JLabel("\u041A\u043E\u043B\u0438\u0447\u0435\u0441\u0442\u0432\u043E \u0434\u043D\u0435\u0439 \u0441 01.01.1970 \u0432 HEX");
		countDaysHexLabel.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_countDaysHexLabel = new GridBagConstraints();
		gbc_countDaysHexLabel.gridwidth = 5;
		gbc_countDaysHexLabel.anchor = GridBagConstraints.WEST;
		gbc_countDaysHexLabel.insets = new Insets(0, 0, 5, 5);
		gbc_countDaysHexLabel.gridx = 1;
		gbc_countDaysHexLabel.gridy = 11;
		contentPane.add(countDaysHexLabel, gbc_countDaysHexLabel);
		
		countDaysHexTf = new JTextField();
		GridBagConstraints gbc_countDaysHexTf = new GridBagConstraints();
		gbc_countDaysHexTf.insets = new Insets(0, 0, 5, 0);
		gbc_countDaysHexTf.gridwidth = 3;
		gbc_countDaysHexTf.fill = GridBagConstraints.HORIZONTAL;
		gbc_countDaysHexTf.gridx = 6;
		gbc_countDaysHexTf.gridy = 11;
		contentPane.add(countDaysHexTf, gbc_countDaysHexTf);
		countDaysHexTf.setColumns(10);
		countDaysHexTf.setEditable(false);
		}
	}
