package unitconverterdisplayer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import energyconverter.EnergyDisplayer;
import tempconverter.TempDisplayer;

public class UnitConverterMenu extends JFrame {
	
	private JPanel jpanel;
	private JButton tempBtn,energyBtn,MassBtn,btn2,btn3,btn4,btn5,btn6;
	private JLabel title; 

	private static boolean tempBtnOnclick = false;
	private static boolean energyBtnOnclick = false;
	private static boolean MassBtnOnclick = false;


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


		MassBtn = new JButton("Mass");
		MassBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		MassBtn.setFocusable(false);
		MassBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		MassBtn.setBounds(50, 170, 200, 60);
		jpanel.add(MassBtn);
		
		btn2 = new JButton("btn2");
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn2.setFocusable(false);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btn2.setBounds(280, 170, 200, 60);
		jpanel.add(btn2);
		
		btn3 = new JButton("btn3");
		btn3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn3.setFocusable(false);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btn3.setBounds(50, 250, 200, 60);
		jpanel.add(btn3);
		
		btn4 = new JButton("btn2");
		btn4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn4.setFocusable(false);
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btn4.setBounds(280, 250, 200, 60);
		jpanel.add(btn4);
		
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