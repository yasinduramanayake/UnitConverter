package lengthconverter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class LengthDisplayer extends JDialog {
	private JPanel jPannel;
	private JButton btn_Convert,btn_Clear;
	private JTextField input_box, output_box;
	public String units,units2;
	public JComboBox LengthDisplayer;
	public JComboBox dropdown,dropdown2;
	public JLabel title,input,output;
	private LengthService LenghtConvert;
	public double inputLength, outputLength;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LengthDisplayer frame = new LengthDisplayer();
					frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public LengthDisplayer() {
		LenghtConvert = (LengthService) new LengthCalculater();
		setResizable(false);
		setTitle("IT191164304 - Yasindu Ramanayke");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(80, 50, 750, 500);
		setLocationRelativeTo(null);
		jPannel = new JPanel();
		jPannel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jPannel);
		jPannel.setLayout(null);
		
		title = new JLabel("Length Converter");
		title.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		title.setBounds(260, 10, 460, 40);
		jPannel.add(title);
		
		dropdown = new JComboBox();
		dropdown.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dropdown.setBounds(60, 120, 250, 40);
		jPannel.add(dropdown);
		
		dropdown.addItem("Centimetre");
		dropdown.addItem("Metre");
		dropdown.addItem("Inch");
	
		
		input = new JLabel("Input");
		input.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		input.setBounds(160, 80, 60, 20);
		jPannel.add(input);
		
			
		output = new JLabel("Output");
		output.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		output.setBounds(510, 80, 60, 20);
		jPannel.add(output);
		
		input_box = new JTextField();
		input_box.setHorizontalAlignment(SwingConstants.CENTER);
		input_box.setFont(new Font("Times New Roman", Font.BOLD, 20));
		input_box.setBounds(50, 160, 280, 140);
		
		
		input_box.setColumns(10);
		jPannel.add(input_box);
		
		
		dropdown2 = new JComboBox();
		dropdown2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dropdown2.setBounds(420, 120, 250, 40);
		jPannel.add(dropdown2);
		
		dropdown2.addItem("Centimetre");
		dropdown2.addItem("Metre");
		dropdown2.addItem("Inch");
		

		output_box = new JTextField();
		output_box.setEditable(false);
		output_box.setBackground(Color.white);
		output_box.setFont(new Font("Times New Roman", Font.BOLD, 20));
		output_box.setHorizontalAlignment(SwingConstants.CENTER);
		output_box.setBounds(400, 160,280, 140);		
		output_box.setColumns(10);	
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
				units2 = String.valueOf(dropdown2.getSelectedItem());

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
					inputLength = Double.parseDouble(input_box.getText());

					if ((units.equalsIgnoreCase("Centimetre")) && (units2.equalsIgnoreCase("Inch"))) {
							outputLength = LenghtConvert.CentimetreToInch(inputLength);
						} 
					else if ((units.equalsIgnoreCase("Centimetre")) && (units2.equalsIgnoreCase("Metre"))) {
							outputLength = LenghtConvert.CentimetreToMetre(inputLength);
						}  
					else if ((units.equalsIgnoreCase("Inch")) && (units2.equalsIgnoreCase("Centimetre")))  {
						outputLength = LenghtConvert.InchToCentimetre(inputLength);
					}
					else if ((units.equalsIgnoreCase("Inch")) && (units2.equalsIgnoreCase("Metre")))  {
						outputLength = LenghtConvert.InchToMetre(inputLength);
					}
					else if ((units.equalsIgnoreCase("Metre")) && (units2.equalsIgnoreCase("Centimetre"))) {
						outputLength = LenghtConvert.MetreToCentimetre(inputLength);
					}
					else if ((units.equalsIgnoreCase("Metre")) && (units.equalsIgnoreCase("Inch"))){
						outputLength = LenghtConvert.MetreToInch(inputLength);
					}
				}

				if (!input_text_value.isEmpty() && input_text_value.length() <= 5 ) {

					outputLength = Math.round(outputLength * 100) / 100.0;
					String fieldValue2 = String.valueOf(outputLength);

					if (fieldValue2.length() <= 5) {
						DecimalFormat df = new DecimalFormat("#.##");
						output_box.setText(df.format(outputLength));

					} else if (fieldValue2.length() > 5) {
						DecimalFormat df = new DecimalFormat("#.##E0");
						df.setMaximumFractionDigits(2);
						output_box.setText(df.format(outputLength));
					}
				}
			
			}
		});
	}

}
