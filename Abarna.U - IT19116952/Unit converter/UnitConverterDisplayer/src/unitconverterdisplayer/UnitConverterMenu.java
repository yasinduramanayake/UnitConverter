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


public class UnitConverterMenu extends JFrame {
	
	private JPanel jpanel;
	private JButton tempBtn,energyBtn,lengthBtn,storageBtn,currencyBtn,speedBtn,btn5,btn6;
	private JLabel title; 

	private static boolean tempBtnOnclick = false;
	private static boolean energyBtnOnclick = false;
	private static boolean lengthBtnOnclick = false;
	private static boolean storageBtnOnclick = false;
	private static boolean speedBtnOnclick = false;


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
				
			}
		});
		speedBtn.setBounds(280, 250, 200, 60);
		jpanel.add(speedBtn);
		
		btn5 = new JButton("btn3");
		btn5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn5.setFocusable(false);
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btn5.setBounds(50, 330, 200, 60);
		jpanel.add(btn5);
		
		btn6 = new JButton("btn2");
		btn6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn6.setFocusable(false);
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btn6.setBounds(280, 330, 200, 60);
		jpanel.add(btn6);
	}
	
}