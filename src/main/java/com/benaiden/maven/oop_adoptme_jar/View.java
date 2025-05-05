package com.benaiden.maven.oop_adoptme_jar;

import java.awt.EventQueue;

import javax.swing.*;
import adoptme.shelter.*;
import adoptme.pet.*;

public class View{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSortingMethod;

	/**
	 * Create the frame.
	 */
	public View(Shelter<Pet> s) {
		String[] listData = new String[s.getArray().size()];
		int i = 0;
		for(Pet p : s.getArray()) {
			listData[i] = p.getName();
			i++;
		}
		
		JFrame frame = new JFrame("Adopt Me");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setLayout(null);
        frame.setVisible(true);
        
        JList<String> list = new JList<>(listData);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(20, 20, 200, 400);
        frame.add(scrollPane);

        frame.setVisible(true);
		
		JButton addPetButton = new JButton("Add");
		addPetButton.setBounds(230, 20, 80, 30);
		frame.add(addPetButton);
		
		JButton adoptPetButton = new JButton("Adopt");
		adoptPetButton.setBounds(230, 50, 80, 30);
		frame.add(adoptPetButton);
		
		JButton removePetButton = new JButton("Remove");
		removePetButton.setBounds(230, 80, 80, 30);
		frame.add(removePetButton);
		
		JComboBox<String> sortComboBox = new JComboBox<>();
		sortComboBox.addItem("Name");
		sortComboBox.addItem("Age");
		sortComboBox.addItem("Species");
		sortComboBox.setBounds(20, 450, 80, 30); // Adjust position/size as needed
		frame.add(sortComboBox);

        
	}
		/*setTitle("Adopt Me!");
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
	}*/
}
