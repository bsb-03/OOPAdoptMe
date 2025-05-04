package com.benaiden.maven.oop_adoptme_jar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddPet = new JButton("Add Pet");
		btnAddPet.setBounds(10, 227, 89, 23);
		contentPane.add(btnAddPet);
		
		JButton btnAdoptPet = new JButton("Adopt Pet");
		btnAdoptPet.setBounds(109, 227, 89, 23);
		contentPane.add(btnAdoptPet);
		
		JButton btnRemovePet = new JButton("Remove Pet");
		btnRemovePet.setBounds(208, 227, 106, 23);
		contentPane.add(btnRemovePet);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(324, 227, 100, 23);
		contentPane.add(btnSubmit);
	}
}
