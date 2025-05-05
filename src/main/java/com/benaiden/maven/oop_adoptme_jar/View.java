package com.benaiden.maven.oop_adoptme_jar;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import adoptme.shelter.*;
import adoptme.pet.*;
import adoptme.serializer.*;

public class View{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSortingMethod;

	/**
	 * Create the frame.
	 */
	private static void saveDataToFiles(Shelter<Pet> s) {
		String petsFilePath = "./src/main/resources/pets.json";
        String exoticFilePath = "./src/main/resources/exotic_animals.json";
        
        ShelterSerializer.writeSheltersToJson(s, petsFilePath, exoticFilePath);
	}
	
	/**
	 * public View(Shelter<Pet> s) - This method creates the pieces of the JFrame
	 * which is rendered out to the user.
	 * @param s - List of pet objects
	 */
	public View(Shelter<Pet> s) {

		// JFrame
		JFrame frame = new JFrame("Adopt Me");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setLayout(null);
        frame.setVisible(true);
        
        // List of pets
        DefaultListModel<String> listModel = new DefaultListModel<>();
		for (Pet p : s.getArray()) {
		    listModel.addElement(p.getName());
		}
		JList<String> list = new JList<>(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(20, 20, 200, 400);
        frame.add(scrollPane);
		
		// Sorting combo box
		JComboBox<String> sortComboBox = new JComboBox<>();
		sortComboBox.addItem("Name");
		sortComboBox.addItem("Age");
		sortComboBox.addItem("Species");
		sortComboBox.setBounds(20, 450, 80, 30); // Adjust position/size as needed
		frame.add(sortComboBox);
		
		// Right-side panel for input
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(null);
		inputPanel.setBounds(350, 20, 220, 200); // adjust as needed
		frame.add(inputPanel);

		// Name label and field
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setBounds(10, 10, 80, 25);
		inputPanel.add(nameLabel);

		JTextField nameField = new JTextField();
		nameField.setBounds(100, 10, 100, 25);
		inputPanel.add(nameField);

		// Species label and field
		JLabel speciesLabel = new JLabel("Species:");
		speciesLabel.setBounds(10, 45, 80, 25);
		inputPanel.add(speciesLabel);

		JTextField speciesField = new JTextField();
		speciesField.setBounds(100, 45, 100, 25);
		inputPanel.add(speciesField);

		// Age label and field
		JLabel ageLabel = new JLabel("Age:");
		ageLabel.setBounds(10, 80, 80, 25);
		inputPanel.add(ageLabel);

		JTextField ageField = new JTextField();
		ageField.setBounds(100, 80, 100, 25);
		inputPanel.add(ageField);

		// Type combo box
		JLabel typeLabel = new JLabel("Type:");
		typeLabel.setBounds(10, 115, 80, 25);
		inputPanel.add(typeLabel);

		String[] petTypes = { "Cat", "Dog", "Rabbit" };
		JComboBox<String> typeComboBox = new JComboBox<>(petTypes);
		typeComboBox.setBounds(100, 115, 100, 25);
		inputPanel.add(typeComboBox);
		
        // Add button
		JButton addPetButton = new JButton("Add");
		addPetButton.setBounds(230, 20, 80, 30);
		addPetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
	            if(nameField.getText() == "" || speciesField.getText() == "" || ageField.getText() == "") {
	            	System.out.println("Please enter the details of your pet!");
	            } 
	            else // make new pet
	            { 
	            	String nameText = nameField.getText();
	            	String speciesText = speciesField.getText();
	            	int ageInput = Integer.parseInt(ageField.getText());
	            	
	            	Pet newPet;
	            	if((String) typeComboBox.getSelectedItem() == "Cat") {
	            		newPet = new Cat(0, nameText, speciesText, ageInput, false);
	            	}
	            	else if((String) typeComboBox.getSelectedItem() == "Dog") {
	            		newPet = new Dog(0, nameText, speciesText, ageInput, false);
	            	}
	            	else {
	            		newPet = new Rabbit(0, nameText, speciesText, ageInput, false);
	            	}
	            	
	            	s.addPet(newPet);
	            	listModel.addElement(nameText);
	            }
	        }
		});
		frame.add(addPetButton);
		
		// Adopt button
		JButton adoptPetButton = new JButton("Adopt");
		adoptPetButton.setBounds(230, 50, 80, 30);
		adoptPetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
	            // adopt pet (is adopted?) -> update list
	           String selectedName = list.getSelectedValue();
	           
	           Pet p = s.getPetByName(selectedName);
	           p.adopt();
	        }
		});
		frame.add(adoptPetButton);
		
		// Remove button
		JButton removePetButton = new JButton("Remove");
		removePetButton.setBounds(230, 80, 80, 30);
		removePetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedName = list.getSelectedValue();
				
				s.removePetByName(selectedName);
				
				listModel.removeElement(selectedName);
	        }
		});
		frame.add(removePetButton);
		
		// save on close functionality
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        saveDataToFiles(s);
		    }
		});
		
		frame.setVisible(true);
		
		
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
