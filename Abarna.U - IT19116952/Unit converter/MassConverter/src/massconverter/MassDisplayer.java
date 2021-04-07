package massconverter;

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

import massconverter.MassCalculate;
import massconverter.MassDisplayer;
import massconverter.MassService;

public class MassDisplayer extends JDialog  {
	
	private JPanel jPannel;
	private JButton btn_Convert,btn_Clear;
	private JTextField input_box, output_box;
	public String units;
	public JComboBox dropdown;
	public JLabel title,input,output;
	private MassService massCalc;
	public double inputValue, outputValue;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MassDisplayer frame = new MassDisplayer();
					frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public MassDisplayer() {
		massCalc = new MassCalculate();
		setResizable(false);
		setTitle("IT19159454 - Fernando P.P.A");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(80, 50, 600, 720);
		setLocationRelativeTo(null);
		jPannel = new JPanel();
		jPannel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jPannel);
		jPannel.setLayout(null);
		
		title = new JLabel("Mass Converter");
		title.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		title.setBounds(180, 20, 460, 40);
		jPannel.add(title);
		
		dropdown = new JComboBox();
		dropdown.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dropdown.setBounds(190, 85, 200, 40);
		jPannel.add(dropdown);
		
		dropdown.addItem(" Kilogram To Gram");
		dropdown.addItem(" Kilogram To Milligram");
		dropdown.addItem(" Gram To Milligram");
		dropdown.addItem(" Gram To Kilogram");
		dropdown.addItem(" Milligram To Gram");
		dropdown.addItem(" Milligram To Kilogram");


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

					if (units.equalsIgnoreCase(" Kilogram To Gram")) {
							outputValue = massCalc.kilogramToGram(inputValue);
						} 
					else if (units.equalsIgnoreCase(" kilogramToMilligram")) {
							outputValue = massCalc.kilogramToMilligram(inputValue);
						} 
					else if (units.equalsIgnoreCase(" Gram To Milligram")) {
						outputValue = massCalc.gramToMilligram(inputValue);
					}
					else if (units.equalsIgnoreCase(" Gram To Kilogram")) {
						outputValue = massCalc.gramToKilogram(inputValue);
					}
					else if (units.equalsIgnoreCase(" Milligram To Gram")) {
						outputValue = massCalc.milligramToGram(inputValue);
					}
					else if (units.equalsIgnoreCase(" Milligram To Kilogram")) {
						outputValue = massCalc.milligramToKilogram(inputValue);
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


