package EmailApplication;

import java.util.Scanner;

//7/7/21

public class email {
		private String firstName;
		private String lastName;
		private String password;
		private String department;
		private String email;
		private int mailboxCapacity = 500;
		private int defaultPasswordLength = 10; // can change later, so its default
		private String alternateEmail;
		private String companySuffix = "company.com";
				
		//Java methods, a constructor has the same name as that of the class and does not have any return type. 
		// For example, class Test { Test() { // constructor body } } Here, Test() is a constructor.
		
		// constructor to receive the first name and last name
		// definition: initializes the newly created object before it is used, is called 
		// can not be abstract, final, static and Synchronized.
		
		public email(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
			//System.out.println("Email Created: " + this.firstName + " " + this.lastName);	
			
		// Call method asking for the department - return the department, since setDepartment is private, this sets department equal to it
			this.department = setDepartment();
			//System.out.println("Department: " + this.department);
			
		// Call method that returns a random password 
			this.password = randomPassword(defaultPasswordLength); // pass in value of password length
			System.out.println("Your password is: " + this.password);
		
		// Combine elements to generate email
			email = this.firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
		  //System.out.println("Your email is: " + email);
			
		}
		// ask for department - separate method 
		private String setDepartment() {
			System.out.print("New employee: " + firstName + ". \nDepartment Code:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
			// scanner to read in input 
			Scanner in = new Scanner(System.in);
			int depChoice = in.nextInt(); 
			if (depChoice == 1) { return "sales"; }
			else if (depChoice == 2) { return "dev"; }
			else if (depChoice == 3) { return "acct"; }
			else { return ""; }
			
			}
					
		
		// generate a random password
		private String randomPassword(int length) {
			String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789!@#$%";
			// array of characters
			char[] password = new char[length]; 
			// iterate through value of length
			for (int i=0; i<length; i++) {
				int rand = (int) (Math.random() * passwordSet.length()); // store random integer in rand 
				password[i] = passwordSet.charAt(rand); // password value equal to passwordSet to char at random number
			}
			// once it generates, return the password
			// modify and put it as new string
			// pass the password characters 
			return new String(password); 
		}
				
		// set mailbox capacity
		// not necessary to put in constructor, already have mailbox capacity defined 
		// public api; process is called encapsulation and is hiding the actual properties 
		public void setMailboxCapacity(int capacity) {
			this.mailboxCapacity = capacity;
		}
		
		// set alternate email
		public void setAlternateEmail(String altEmail) {
			this.alternateEmail = altEmail;
		}
		
		// change password
		public void changePassword(String password) {
			this.password = password;
		}
		//public methods (get methods) that are going to access the properties instead of actually defining and interacting with them directly,
		// they are being accessed through methods - encapsulation, data binding, data hiding 
		public int getMailboxCapacity() { return mailboxCapacity; }
		public String getAlternateEmail() { return alternateEmail; }
		public String getPassword() { return password; }
		
		//return info - name, email, mailbox capacity from variables 
		public String showInfo() {
			return "Display Name: " + firstName + " " + lastName + 
					"\nCompany Email: " + email + " " +
					"\nMailbox Capacity: " + mailboxCapacity + "mb";
		}
}
