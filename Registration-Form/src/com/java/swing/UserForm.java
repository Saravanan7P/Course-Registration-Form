package com.java.swing;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

	/**
	 * User Registration using Swing
	 * @author javaguides.net
	 *
	 */
	public class UserForm extends JFrame {
	    private static final long serialVersionUID = 1L;
	    private JPanel contentPane;
	    private JTextField firstname;
	    private JTextField lastname;
	    private JTextField email;
	    private JTextField study;
	    private JTextField area;
	    private JTextField mob;
	    private JButton btnNewButton;

	    /**
	     * Launch the application.
	     */
	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                	UserForm frame = new UserForm();
	                    frame.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }

	    

	    public UserForm() {
	    
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(450, 190, 1014, 597);
	        setResizable(false);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);

	        JLabel lblNewUserRegister = new JLabel("Course Registration Form");
	        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 32));
	        lblNewUserRegister.setBounds(362, 52, 325, 50);
	        contentPane.add(lblNewUserRegister);

	        JLabel lblName = new JLabel("First Name");
	        lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblName.setBounds(58, 152, 99, 43);
	        contentPane.add(lblName);

	        JLabel lblNewLabel = new JLabel("Last Name");
	        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblNewLabel.setBounds(58, 243, 110, 29);
	        contentPane.add(lblNewLabel);

	        JLabel lblEmailAddress = new JLabel("Email\r\n address");
	        lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblEmailAddress.setBounds(58, 324, 124, 36);
	        contentPane.add(lblEmailAddress);

	        firstname = new JTextField();
	        firstname.setFont(new Font("Tahoma", Font.PLAIN, 32));
	        firstname.setBounds(214, 151, 228, 50);
	        contentPane.add(firstname);
	        firstname.setColumns(10);

	        lastname = new JTextField();
	        lastname.setFont(new Font("Tahoma", Font.PLAIN, 32));
	        lastname.setBounds(214, 235, 228, 50);
	        contentPane.add(lastname);
	        lastname.setColumns(10);

	        email = new JTextField();

	        email.setFont(new Font("Tahoma", Font.PLAIN, 32));
	        email.setBounds(214, 320, 228, 50);
	        contentPane.add(email);
	        email.setColumns(10);

	        study = new JTextField();
	        study.setFont(new Font("Tahoma", Font.PLAIN, 32));
	        study.setBounds(707, 151, 228, 50);
	        contentPane.add(study);
	        study.setColumns(10);

	        JLabel lblUsername = new JLabel("Course");
	        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblUsername.setBounds(542, 159, 99, 29);
	        contentPane.add(lblUsername);

	        JLabel lblLocality = new JLabel("Location");
	        lblLocality.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblLocality.setBounds(542, 245, 99, 24);
	        contentPane.add(lblLocality);

	        JLabel lblMobileNumber = new JLabel("Mobile number");
	        lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblMobileNumber.setBounds(542, 329, 139, 26);
	        contentPane.add(lblMobileNumber);
	        
	        area = new JTextField();
	        area.setFont(new Font("Tahoma", Font.PLAIN, 32));
	        area.setBounds(707, 235, 228, 50);
	        contentPane.add(area);
	        area.setColumns(10);
	        
	        mob = new JTextField();
	        mob.setFont(new Font("Tahoma", Font.PLAIN, 32));
	        mob.setBounds(707, 320, 228, 50);
	        contentPane.add(mob);
	        mob.setColumns(10);

	        

	        btnNewButton = new JButton("Register");
	        btnNewButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String firstName = firstname.getText();
	                String lastName = lastname.getText();
	                String emailId = email.getText();
	                String course = study.getText();
	                String Location = area.getText();
	                String mobileNumber = mob.getText();
	                int len = mobileNumber.length();
	               

	                String msg = "" + firstName;
	                msg += " \n";
	                if (len != 10) {
	                    JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number");
	                }

	                try {
	                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/form", "root", "Password");

	                    String query = "INSERT INTO account values('" + firstName + "','" + lastName + "','" + course + "','" +
	                        Location + "','" + emailId + "','" + mobileNumber + "')";

	                    Statement sta = connection.createStatement();
	                    int x = sta.executeUpdate(query);
	                    if (x == 0) {
	                        JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
	                    } else {
	                        JOptionPane.showMessageDialog(btnNewButton,
	                            "Welcome, " + msg + "Your account is sucessfully created");
	                    }
	                    connection.close();
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }
	            }
	        });
	        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
	        btnNewButton.setBounds(399, 447, 259, 74);
	        contentPane.add(btnNewButton);
	    }
	}


