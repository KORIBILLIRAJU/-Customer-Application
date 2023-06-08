package customerApplication;
import java.util.Scanner;
public class CustomerServices {
	Customer customerList[] = new Customer[100];
	int index = 0;
	int customerId = 1001;
	Scanner obj = new Scanner(System.in);
	
	public void addNewCustomer() {
		if(index<30) {
			System.out.println();
			System.out.println("Enter Customer Name: ");
			String name = obj.next();
			System.out.println("Enter your Gender: ");
			String gender = obj.next();
			System.out.println("Enter your Email-id: ");
			String email = obj.next();
			System.out.println("Enter your Phone Number: ");
			long phone = obj.nextLong();
			System.out.println("Enter your Date of Birth: ");
			String dob = obj.next();
			System.out.println("Enter your Address: ");
			String address = obj.next();
			Customer c = new Customer();
			c.customerDetails(customerId, name, gender, email, phone, dob, address);
			customerList[index] = c;
			index = index + 1;
			customerId = customerId + 1;
			System.out.println("---------------------------------------------");
			System.out.println("*Customer Details Added Succesfully.*");
			System.out.println("---------------------------------------------");
		}
		else {
			System.out.println("---------------------------------------------");
			System.out.println("Sorry, No more customers are accepted.");
			System.out.println("---------------------------------------------");
		}
	}
	
	public void editCustomer() {
		if(index != 0) {
			System.out.println();
			System.out.println("Enter the CustomerId to Edit the details: ");
			customerId = obj.nextInt();
			for(int i=0;i<index;i++) {
				if(customerList[i].getId() == customerId) {
					System.out.println("Enter Customer Name: ");
					String name = obj.next();
					System.out.println("Enter your Gender: ");
					String gender = obj.next();
					System.out.println("Enter your Email-id: ");
					String email = obj.next();
					System.out.println("Enter your Phone Number: ");
					long phone = obj.nextLong();
					System.out.println("Enter your Date of Birth: ");
					String dob = obj.next();
					System.out.println("Enter your Address: ");
					String address = obj.next();
					Customer c = new Customer();
					c.customerDetails(customerId, name, gender, email, phone, dob, address);
					customerList[i] = c;
					System.out.println("---------------------------------------------");
					System.out.println("Customer with Id "+customerId+" updated Successfully");
					System.out.println("---------------------------------------------");
				}
			}
		}
		else {
			System.out.println("---------------------------------------------");
			System.out.println("There are no customers till now.");
			System.out.println("---------------------------------------------");
		}
	}
	
	public void deleteCustomer() {
		if(index != 0) {
			System.out.println();
			System.out.println("Enter the CustomerId to delete the Customer Application: ");
			customerId = obj.nextInt();
			for(int i=0;i<index;i++) {
		      	if(customerList[i].getId() == customerId) {
		    	  for(int j=i;j<index-1;j++) {
		        	customerList[j] = customerList[j+1];
		        	}
		        	customerList[index-1] = null;
		        	index--;
		        	System.out.println("---------------------------------------------");
		        	System.out.println("Customer with Id "+customerId+" deleted Successfully");
		        	System.out.println("---------------------------------------------");
		      	}
			}
		}
		else {
			System.out.println("---------------------------------------------");
			System.out.println("There are no customers till now.");
			System.out.println("---------------------------------------------");
		}
	}
	
	public void diplayAllCustomers() {
		if(index == 0) {
			System.out.println("---------------------------------------------");
			System.out.println("There are no customers till now.");
			System.out.println("---------------------------------------------");
		}
		else {
			for(int i=0;i<index;i++) {
				Customer c = customerList[i];
				System.out.println(c);
			}
		}
	}
	
	public void displayCustomerById() {
		if(index != 0) {
			System.out.println();
			System.out.println("Enter the CustomerId to display the Particular Customer details: ");
			customerId = obj.nextInt();
			for(int i=0;i<index;i++) {
				if(customerList[i].getId() == customerId) {
					System.out.println(customerList[i]);
				}
				else {
					System.out.println("---------------------------------------------");
					System.out.println("Customer Id with "+customerId+"doesn't exist.");
					System.out.println("---------------------------------------------");
				}
			}
		}
		else{
			System.out.println("---------------------------------------------");
			System.out.println("There are no customers till now.");
			System.out.println("---------------------------------------------");
		}
	}
	
	public void menu() {
		CustomerServices cs = new CustomerServices();
		while(true) {
			System.out.println();
			System.out.println("*******Welcome to Our Store*******");
			System.out.println("---------------------------------------------");
			System.out.println("Press 1 for Add New Customer.");
			System.out.println("Press 2 for Edit Customer Details.");
			System.out.println("Press 3 for Delete entire customer from Database.");
			System.out.println("Press 4 for Display All Customer Details.");
			System.out.println("Press 5 for Display a particular Customer Details.");
			System.out.println("Press 0 for Exit from the Application.");
			System.out.println("---------------------------------------------");
			System.out.println("Enter Your Choice...");
			int ch = obj.nextInt();
			switch(ch) {
				case 1: cs.addNewCustomer();break;
				case 2: cs.editCustomer();break;
				case 3: cs.deleteCustomer();break;
				case 4: cs.diplayAllCustomers();break;
				case 5: cs.displayCustomerById();break;
				case 0: System.exit(ch);
				default:
					System.out.println();
					System.out.println("Press Enter to go to the Previous Menu...");
					obj.next();
			}
		}
	}
}

