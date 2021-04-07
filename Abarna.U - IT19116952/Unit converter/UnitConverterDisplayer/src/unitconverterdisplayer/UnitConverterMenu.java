package unitconverterdisplayer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import lengthconverter.LengthDisplayer;
import storageconverter.StorageDisplayer;
import energyconverter.EnergyDisplayer;
import tempconverter.TempDisplayer;

import speedconverter.SpeedDisplay;
import massconverter.MassDisplayer;
import timeconverter.TimeDisplayer;

public class UnitConverterMenu extends JFrame {
	
	private JPanel jpanel;
	private JButton tempBtn,energyBtn,lengthBtn,storageBtn,currencyBtn,speedBtn,MassBtn,Timebtn;
	private JLabel title; 
	private static boolean tempBtnOnclick = false;
	private static boolean energyBtnOnclick = false;
	private static boolean lengthBtnOnclick = false;
	private static boolean storageBtnOnclick = false;
	private static boolean speedBtnOnclick = false;
	private static boolean massBtnOnclick = false;
	private static boolean timeBtnOnClick = false;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UnitConverterMenu frame = new UnitConverterMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public UnitConverterMenu() {
		setResizable(false);
		setTitle("Unit Converter");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(80, 50, 550, 470);
		setLocationRelativeTo(null);
		jpanel = new JPanel();
		jpanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jpanel);
		jpanel.setLayout(null);
		jpanel.setVisible(true);

		title = new JLabel("Unit Converter");
		title.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		title.setBounds(180, 25, 175, 30);
		jpanel.add(title);
		
		tempBtn = new JButton("Temperature");
		tempBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tempBtn.setFocusable(false);
		tempBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tempBtnOnclick = ConverterDisplayerActivator.tempChecker();
				if (tempBtnOnclick == true) {
					TempDisplayer tempDisplayer = new TempDisplayer();
					tempDisplayer.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Temperature Service is not Started",
							"Error !", JOptionPane.OK_OPTION);
				}
			}
		});
		tempBtn.setBounds(50, 90, 200, 60);
		jpanel.add(tempBtn);
		
		energyBtn = new JButton("Energy");
		energyBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		energyBtn.setFocusable(false);
		energyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				energyBtnOnclick = ConverterDisplayerActivator.energyChecker();
				if (energyBtnOnclick == true) {
					EnergyDisplayer energyDisplayer = new EnergyDisplayer();
					energyDisplayer.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Energy Service is not Started",
							"Error !", JOptionPane.OK_OPTION);
				}
			}
		});
		energyBtn.setBounds(280, 90, 200, 60);
		jpanel.add(energyBtn);


		lengthBtn = new JButton("Length");
		lengthBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lengthBtn.setFocusable(false);
		lengthBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				lengthBtnOnclick = ConverterDisplayerActivator.lengthChecker();
				if (lengthBtnOnclick == true) {
					LengthDisplayer lengthDisplayer = new LengthDisplayer();
					lengthDisplayer.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Length Service is not Started",
							"Error !", JOptionPane.OK_OPTION);
				}
			}
		});

		lengthBtn.setBounds(50, 170, 200, 60);
		jpanel.add(lengthBtn);

		
		storageBtn = new JButton("storageBtn");
		storageBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		storageBtn.setFocusable(false);
		storageBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				storageBtnOnclick = ConverterDisplayerActivator.StorageChecker();
				if (storageBtnOnclick == true) {
					StorageDisplayer StorageDisplayer = new StorageDisplayer();
					StorageDisplayer.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Storage Service is not Started",
							"Error !", JOptionPane.OK_OPTION);
				}
			}
		});
		storageBtn.setBounds(280, 170, 200, 60);
		jpanel.add(storageBtn);
		
		currencyBtn = new JButton("Currency");
		currencyBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		currencyBtn.setFocusable(false);
		currencyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		currencyBtn.setBounds(50, 250, 200, 60);
		jpanel.add(currencyBtn);
		
		speedBtn = new JButton("Speed");
		speedBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		speedBtn.setFocusable(false);
		speedBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				speedBtnOnclick = ConverterDisplayerActivator.MassChecker();
				if (speedBtnOnclick == true) {
					SpeedDisplay SpeedDisplay = new SpeedDisplay();
					SpeedDisplay.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Mass Service is not Started",
							"Error !", JOptionPane.OK_OPTION);
				}
			}
		});
		speedBtn.setBounds(280, 250, 200, 60);
		jpanel.add(speedBtn);
		
		MassBtn = new JButton("Mass");
		MassBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		MassBtn.setFocusable(false);
		MassBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				massBtnOnclick = ConverterDisplayerActivator.MassChecker();
				if (massBtnOnclick == true) {
					MassDisplayer MassDisplayer = new MassDisplayer();
					MassDisplayer.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Mass Service is not Started",
							"Error !", JOptionPane.OK_OPTION);
				}
			}
		});
		MassBtn.setBounds(50, 330, 200, 60);
		jpanel.add(MassBtn);
		
		Timebtn = new JButton("Time");
		Timebtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Timebtn.setFocusable(false);
		Timebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timeBtnOnClick = ConverterDisplayerActivator.timeChecker();
				if (timeBtnOnClick == true) {
					TimeDisplayer TimeDisplayer = new TimeDisplayer();
					TimeDisplayer.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Time Service is not Started",
							"Error !", JOptionPane.OK_OPTION);
				}
				
			}
		});
		Timebtn.setBounds(280, 330, 200, 60);
		jpanel.add(Timebtn);
	}
	
}