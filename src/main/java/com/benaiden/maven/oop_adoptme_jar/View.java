package com.benaiden.maven.oop_adoptme_jar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSortingMethod;

	/**
	 * Create the frame.
	 */
	public View() {
		setTitle("Adopt Me!");
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
		
		JList petList = new JList();
		petList.setBounds(10, 11, 414, 171);
		contentPane.add(petList);
		
		JButton btnViewDetails = new JButton("View Details");
		btnViewDetails.setBounds(10, 193, 89, 23);
		contentPane.add(btnViewDetails);
		
		JComboBox sortComboBox = new JComboBox();
		sortComboBox.setToolTipText("Sorting Method");
		sortComboBox.setBounds(208, 193, 89, 22);
		sortComboBox.addItem("Name");
        sortComboBox.addItem("Age");
        sortComboBox.addItem("Species");
		contentPane.add(sortComboBox);
		
		txtSortingMethod = new JTextField();
		txtSortingMethod.setEditable(false);
		txtSortingMethod.setText("Sorting Method:");
		txtSortingMethod.setBounds(109, 196, 89, 20);
		contentPane.add(txtSortingMethod);
		txtSortingMethod.setColumns(10);
	}
}
