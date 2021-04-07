package timeconverter;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import timeconverter.TimeCalculate;
import timeconverter.TimeDisplayer;
import timeconverter.TimeService;


public class TimeDisplayer extends JDialog {
	
	private JPanel jPannel;
	private JButton btn_Convert,btn_Clear;
	private JTextField input_box, output_box;
	public String units;
	public JComboBox dropdown;
	public JLabel title,input,output;
	private TimeService timeCalc;
	public double inputValue, outputValue;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimeDisplayer frame = new TimeDisplayer();
					frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TimeDisplayer() {
		timeCalc = new TimeCalculate();
		setResizable(false);
		setTitle("IT19159454 - Fernando P.P.A");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(80, 50, 600, 720);
		setLocationRelativeTo(null);
		jPannel = new JPanel();
		jPannel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jPannel);
		jPannel.setLayout(null);
		
		title = new JLabel("Time Converter");
		title.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		title.setBounds(180, 20, 460, 40);
		jPannel.add(title);
		
		dropdown = new JComboBox();
		dropdown.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dropdown.setBounds(190, 85, 200, 40);
		jPannel.add(dropdown);
		
		dropdown.addItem(" Hour To Minute");
		dropdown.addItem(" Hour To Second");
		dropdown.addItem(" Minute To Second");
		dropdown.addItem(" Minute To Hour");
		dropdown.addItem(" Second To Minute");
		dropdown.addItem(" Second To Hour");


		input = new JLabel("Input");
		input.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		input.setBounds(260, 150, 60, 20);
		jPannel.add(input);
		
		output = new JLabel("Output");
		output.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		output.setBounds(260, 420, 60, 20);
		jPannel.add(output);
		
		input_box = new JTextField();
		input_box.setHorizontalAlignment(SwingConstants.CENTER);
		input_box.setFont(new Font("Tahoma", Font.BOLD, 20));
		input_box.setBounds(150, 180, 280, 140);
		input_box.setColumns(10);
		jPannel.add(input_box);

		output_box = new JTextField();
		output_box.setEditable(false);
		output_box.setBackground(Color.WHITE);
		output_box.setFont(new Font("Tahoma", Font.BOLD, 20));
		output_box.setHorizontalAlignment(SwingConstants.CENTER);
		output_box.setColumns(10);
		output_box.setBounds(150, 450, 280, 140);
		jPannel.add(output_box);

		

		btn_Convert = new JButton("Convert");
		btn_Convert.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Convert.setBounds(240, 350, 100, 40);
		btn_Convert.setFocusable(false);
		jPannel.add(btn_Convert);

		btn_Clear = new JButton("Clear");
		btn_Clear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Clear.setBounds(240, 620, 100, 40);
		btn_Clear.setFocusable(false);
		jPannel.add(btn_Clear);
		
		btn_Clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				input_box.setText("");
				output_box.setText("");
			}
		});

		btn_Convert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				units = String.valueOf(dropdown.getSelectedItem());

				String input_text_value = input_box.getText();

			
				String PATTERN = "^[+-]?([0-9]*[.])?[0-9]+$";
				Pattern pat = Pattern.compile(PATTERN);
				Matcher match = pat.matcher(input_text_value);

				boolean result = !match.matches();

				if (input_text_value.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Input Field is Empty", "Empty Field Alert", JOptionPane.OK_OPTION);

				} else if (result) {
					JOptionPane.showMessageDialog(null, "Input Valid Numbers Only ", "Alert", JOptionPane.OK_OPTION);

				} else if (input_text_value.length() > 10) {
					JOptionPane.showMessageDialog(null, "Input Value is Too High", "Alert", JOptionPane.OK_OPTION);
					output_box.setText(" ");

				} else {
					inputValue = Double.parseDouble(input_box.getText());

					if (units.equalsIgnoreCase(" Hour To Minute")) {
							outputValue = timeCalc.hourToMinute(inputValue);
						} 
					else if (units.equalsIgnoreCase(" Hour To Second")) {
							outputValue = timeCalc.hourToSecond(inputValue);
						} 
					else if (units.equalsIgnoreCase(" Minute To Second")) {
						outputValue = timeCalc.minuteToSecond(inputValue);
					}
					else if (units.equalsIgnoreCase(" Minute To Hour")) {
						outputValue = timeCalc.minuteToHour(inputValue);
					}
					else if (units.equalsIgnoreCase(" Second To Minute")) {
						outputValue = timeCalc.secondToMinute(inputValue);
					}
					else if (units.equalsIgnoreCase(" Second To Hour")) {
						outputValue = timeCalc.secondToHour(inputValue);
					}
				}

				if (!input_text_value.isEmpty() && input_text_value.length() <= 10 ) {

					outputValue = Math.round(outputValue * 100) / 100.0;
					String fieldValue2 = String.valueOf(outputValue);

					if (fieldValue2.length() <= 10) {
						DecimalFormat df = new DecimalFormat("#.##");
						output_box.setText(df.format(outputValue));

					} else if (fieldValue2.length() > 10) {
						DecimalFormat df = new DecimalFormat("#.##E0");
						df.setMaximumFractionDigits(2);
						output_box.setText(df.format(outputValue));
					}
				}
			
			}
		});
	}
}


