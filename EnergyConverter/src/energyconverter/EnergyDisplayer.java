package energyconverter;

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

import energyconverter.*;

public class EnergyDisplayer extends JDialog {
	
	private JPanel jPannel;
	private JButton btn_Convert,btn_Clear;
	private JTextField input_box, output_box;
	public String units;
	public JComboBox dropdown;
	public JLabel title,input,output;
	private EnergyService energyCalc;
	public double inputValue, outputValue;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnergyDisplayer frame = new EnergyDisplayer();
					frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public EnergyDisplayer() {
		energyCalc = new EnergyCalculate();
		setResizable(false);
		setTitle("IT19116952 - Abarna.U");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 80, 750, 500);
		setLocationRelativeTo(null);
		jPannel = new JPanel();
		jPannel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jPannel);
		jPannel.setLayout(null);
		
		title = new JLabel("Energy Converter");
		title.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		title.setBounds(220, 20, 460, 40);
		jPannel.add(title);
		
		dropdown = new JComboBox();
		dropdown.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dropdown.setBounds(280, 85, 200, 40);
		jPannel.add(dropdown);
		
		dropdown.addItem(" Joule To Calorie");
		dropdown.addItem(" Joule To KiloJoule");
		dropdown.addItem(" Calorie To Joule");
		dropdown.addItem(" Calorie To KiloJoule");
		dropdown.addItem(" KiloJoule To Calorie");
		dropdown.addItem(" KiloJoule To Joule");


		input = new JLabel("Input");
		input.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		input.setBounds(160, 120, 60, 20);
		jPannel.add(input);
		
		output = new JLabel("Output");
		output.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		output.setBounds(510, 120, 60, 20);
		jPannel.add(output);
		
		input_box = new JTextField();
		input_box.setHorizontalAlignment(SwingConstants.CENTER);
		input_box.setFont(new Font("Tahoma", Font.BOLD, 20));
		input_box.setBounds(50, 160, 280, 140);
		input_box.setColumns(10);
		jPannel.add(input_box);

		output_box = new JTextField();
		output_box.setEditable(false);
		output_box.setBackground(Color.WHITE);
		output_box.setFont(new Font("Tahoma", Font.BOLD, 20));
		output_box.setHorizontalAlignment(SwingConstants.CENTER);
		output_box.setColumns(10);
		output_box.setBounds(400, 160,280, 140);
		jPannel.add(output_box);

		

		btn_Convert = new JButton("Convert");
		btn_Convert.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Convert.setBounds(140, 330, 100, 40);
		btn_Convert.setFocusable(false);
		jPannel.add(btn_Convert);

		btn_Clear = new JButton("Clear");
		btn_Clear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Clear.setBounds(490, 330, 100, 40);
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

					if (units.equalsIgnoreCase(" Joule To Calorie")) {
							outputValue = energyCalc.jouleToCalorie(inputValue);
						} 
					else if (units.equalsIgnoreCase(" Joule To KiloJoule")) {
							outputValue = energyCalc.jouleToKilojoule(inputValue);
						} 
					else if (units.equalsIgnoreCase(" Calorie To Joule")) {
						outputValue = energyCalc.calorieTojoule(inputValue);
					}
					else if (units.equalsIgnoreCase(" Calorie To KiloJoule")) {
						outputValue = energyCalc.calorieToKilojoule(inputValue);
					}
					else if (units.equalsIgnoreCase(" KiloJoule To Calorie")) {
						outputValue = energyCalc.kilojouleToCalorie(inputValue);
					}
					else if (units.equalsIgnoreCase(" KiloJoule To Joule")) {
						outputValue = energyCalc.kilojouleToJoule(inputValue);
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
