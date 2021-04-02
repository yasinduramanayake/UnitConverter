package storageconverter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class StorageDisplayer extends JDialog {
	private JPanel jPannel;
	private JButton btn_Convert,btn_Clear;
	private JTextField input_box, output_box;
	public String units,units2;
	public JComboBox StorageDisplayer;
	public JComboBox dropdown1,dropdown2;
	public JLabel title,input,output;
	private StorageService StorageConvert;
	public double inputStorage, outputStorage;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StorageDisplayer frame = new StorageDisplayer();
					frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public StorageDisplayer() {
		StorageConvert = (StorageService) new StorageCalculater();
		setResizable(false);
		setTitle("IT191164304 - Yasindu Ramanayke");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(80, 50, 750, 500);
		setLocationRelativeTo(null);
		jPannel = new JPanel();
		jPannel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jPannel);
		jPannel.setLayout(null);
		
		title = new JLabel("Storage Converter");
		title.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		title.setBounds(260, 10, 460, 40);
		jPannel.add(title);
		
		dropdown1 = new JComboBox();
		dropdown1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dropdown1.setBounds(60, 120, 250, 40);
		jPannel.add(dropdown1);
		
		dropdown1.addItem("Bits");
		dropdown1.addItem("Bytes");
		dropdown1.addItem("KiloBytes");
	
		
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
		
		dropdown2.addItem("Bits");
		dropdown2.addItem("Bytes");
		dropdown2.addItem("KiloBytes");
		

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
				units = String.valueOf(dropdown1.getSelectedItem());
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
					inputStorage = Double.parseDouble(input_box.getText());

					if ((units.equalsIgnoreCase("Bits")) && (units2.equalsIgnoreCase("Bytes"))) {
							outputStorage = StorageConvert.BitToByte(inputStorage);
						} 
					else if ((units.equalsIgnoreCase("Bits")) && (units2.equalsIgnoreCase("KiloBytes"))) {
							outputStorage = StorageConvert.BitToKiloBytes(inputStorage);
						}  
					else if ((units.equalsIgnoreCase("Bytes")) && (units2.equalsIgnoreCase("Bits")))  {
						outputStorage = StorageConvert.BytesToBits(inputStorage);
					}
					else if ((units.equalsIgnoreCase("Bytes")) && (units2.equalsIgnoreCase("KiloBytes")))  {
						outputStorage = StorageConvert.BytesToKiloBytes(inputStorage);
					}
					else if ((units.equalsIgnoreCase("KiloBytes")) && (units2.equalsIgnoreCase("Bits"))) {
						outputStorage = StorageConvert.KiloBytesToBits(inputStorage);
					}
					else if ((units.equalsIgnoreCase("KiloBytes")) && (units2.equalsIgnoreCase("Bytes"))){
						outputStorage = StorageConvert.KiloBytesToBytes(inputStorage);
					}
				}

				if (!input_text_value.isEmpty() && input_text_value.length() <= 5 ) {

					outputStorage = Math.round(outputStorage * 100) / 100.0;
					String fieldValue2 = String.valueOf(outputStorage);

					if (fieldValue2.length() <= 5) {
						DecimalFormat df = new DecimalFormat("#.##");
						output_box.setText(df.format(outputStorage));

					} else if (fieldValue2.length() > 5) {
						DecimalFormat df = new DecimalFormat("#.##E0");
						df.setMaximumFractionDigits(2);
						output_box.setText(df.format(outputStorage));
					}
				}
			
			}
		});
	}

}
