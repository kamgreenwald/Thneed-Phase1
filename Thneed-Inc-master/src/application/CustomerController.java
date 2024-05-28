package application;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.ArrayList;

import javafx.event.ActionEvent;

public class CustomerController {
@FXML
private Label name;
@FXML
private Label number;
@FXML
private Label address;
@FXML
private ChoiceBox<String> CustomerChoice;
@FXML
private TextField newName;
@FXML
private TextField newNumber;
@FXML
private TextField newAddress;

		private OrderGUIController callingController;
		
		public void setController(OrderGUIController orderGUIController) {
			this.callingController = orderGUIController;
			}
		
		ArrayList<Customer> thneedCustomers = new ArrayList<>();
		
		public ChoiceBox<String> setCustomer() {
			for (int i = 0; i<thneedCustomers.size(); i++) {
			if (!CustomerChoice.getItems().contains(thneedCustomers.get(i).getCustomerName()))
			CustomerChoice.getItems().add(thneedCustomers.get(i).getCustomerName());
				}
			return CustomerChoice;
		}
		
		@FXML
		private void loadCustomer(ActionEvent event) {
			for (int i = 0; i<thneedCustomers.size();i++) {
					if (thneedCustomers.get(i).getCustomerName().equals(CustomerChoice.getValue())) {
						name.setText(thneedCustomers.get(i).getCustomerName());
						address.setText(thneedCustomers.get(i).getAddress());
						number.setText(thneedCustomers.get(i).getNumber());
					}
				}
			}
		
		@FXML
		private void createCustomer(ActionEvent event) {
			thneedCustomers.add(new Customer(0,newName.getText(),newAddress.getText(), newNumber.getText()));
				System.out.println(thneedCustomers.get(thneedCustomers.size()-1).getCustomerName()+ " Added");
					newName.clear();
					newAddress.clear();
					newNumber.clear();
					setCustomer();
				}
			}
		
