package application;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Scene;
import javafx.event.ActionEvent;

public class OrderGUIController {
	@FXML
	private Label OrderID;
	@FXML
	private Label thneedsID;
	@FXML
	private Label CustomerID;
	@FXML
	private Label OrderedID;
	@FXML
	private Label FilledID;
	@FXML
	private TextField thneedsField;
	@FXML
	private ChoiceBox<String> customerChoiceBox;
	@FXML
	private DatePicker orderedDate;
	@FXML
	private VBox ordersContainer;
	@FXML
	private DatePicker filledDate;
	
	
	ArrayList<Order> thneedOrders = new ArrayList<>();
	TreeSet<Order> unfilledOrders = new TreeSet<>(Comparator.comparing(Order::getOrderDate));
	TreeSet<Order> filledOrders = new TreeSet<>(Comparator.comparing(Order::getFillDate, Comparator.nullsLast(Comparator.reverseOrder())));
	
	private Stage CustomerStage;
	private CustomerController controller;
	
	public void setChoiceBox(String s) {
		customerChoiceBox.setValue(s);
	}
	
	public void CustomerController2() {
		controller = new CustomerController();
	}
	
	ArrayList<Customer> thneedCustomers = new ArrayList<>();
	
	@FXML
	public void updateCustomerChoiceBox(ActionEvent event) {
        if (controller != null) {
            ChoiceBox<String> customerChoices = controller.setCustomer();
            if (customerChoices != null) {
                customerChoiceBox.getItems().setAll(customerChoices.getItems());
            } else {
            	System.out.println("The list is null");
            }
        }
    }
	
	@FXML
	private void addOrder(ActionEvent event) {
			int orderID = thneedOrders.size() + 1;
			String thneeds = thneedsField.getText();
			String selectedCustomer = customerChoiceBox.getValue();
			LocalDate dateOrdered = orderedDate.getValue();
			LocalDate dateFilled = filledDate.getValue();
			Order order = new Order(orderID, thneeds, selectedCustomer, dateOrdered, dateFilled);
			thneedOrders.add(order);
			
				if (dateFilled == null) {
					unfilledOrders.add(order);
				} else {
					filledOrders.add(order);			
				}
			
			thneedsField.setText("");
			customerChoiceBox.getSelectionModel().clearSelection();
			orderedDate.setValue(null);
			filledDate.setValue(null);
			
			updateOrdersUI();
	}
	
	@FXML
	private void saveButtonClicked(ActionEvent event) {
		ordersContainer.getChildren().forEach(node -> {
	        if (node instanceof TextField) {
	            TextField textField = (TextField) node;
	            Order order = (Order) textField.getUserData();
	            int index = thneedOrders.indexOf(order);
	            if (index != -1) {
	            	String[] orderInfo = textField.getText().split(" ,"); 
	            	if (orderInfo.length >= 4) {
	            	    String customer = orderInfo[0].substring("Customer: ".length()).trim();
	            	    String thneeds = orderInfo[1].substring("Thneeds: ".length()).trim();
	            	    String dateOrderedStr = orderInfo[2].substring("Date Ordered:".length()).trim();
	            	    String dateFilledStr = orderInfo[3].substring("Date Filled:".length()).trim();
	            	    LocalDate dateOrdered = null;
	            	    LocalDate dateFilled = null;
	            	    try {
	            	        dateOrdered = LocalDate.parse(dateOrderedStr);
	            	        if (!dateFilledStr.equals("null")) {
	            	            dateFilled = LocalDate.parse(dateFilledStr);
	            	        }
	            	    } catch (DateTimeParseException e) {
	            	        e.printStackTrace();
	            	    }
	            	    order.setCustomerName(customer);
	            	    order.setThneeds(thneeds);
	            	    order.setOrderDate(dateOrdered);
	            	    order.setFilledDate(dateFilled);
	            	}
	                thneedOrders.set(index, order);
	                System.out.println("Order updated in thneedOrders");
	                if (order.getFillDate() == null) {
	                    if (!unfilledOrders.contains(order)) {
	                        unfilledOrders.add(order);
	                        System.out.println("Order added to unfilledOrders");
	                    }
	                    filledOrders.remove(order);
	                } else {
	                    if (!filledOrders.contains(order)) {
	                        filledOrders.add(order);
	                        System.out.println("Order added to filledOrders");
	                    }
	                    unfilledOrders.remove(order);
	                }

	            }
	        }
	    });
	    updateOrdersUI();
	}
	
	@FXML
	private void updateOrdersUI() {
		ordersContainer.getChildren().clear();
		
		for (Order order : unfilledOrders) {
			displayOrder(order);
		}
		
		for (Order order : filledOrders) {
			displayOrder(order);
		}
	}
	
	@FXML
	private void displayOrder(Order order) {
		Label orderLabel = new Label("Order " + order.getID());
	    TextField orderTextField = new TextField();
	    orderTextField.setUserData(order);
	    orderTextField.setText(order.toString());
	    ordersContainer.getChildren().addAll(orderLabel, orderTextField);
	}
	
	@FXML
	private void ShowCustomerButtonClicked(ActionEvent event) {
		if (CustomerStage == null) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Customers.fxml"));
			AnchorPane OrderSummaryPane;
			
			try {
				OrderSummaryPane = (AnchorPane)loader.load();
				Scene OrderSummaryScene = new Scene(OrderSummaryPane);
				CustomerStage = new Stage();
				CustomerStage.setScene(OrderSummaryScene);
				CustomerStage.setTitle("Order Summary Window");
				controller = (CustomerController) loader.getController();
				controller.setController(this);
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		CustomerStage.show();
	}
	
	
	@FXML
	private void writeAllClicked(ActionEvent event) {
		try {
			FileWriter fileWriter = new FileWriter("OrderList.txt");
			
			for(Order order : unfilledOrders) {
				fileWriter.write(order + "\n");
			}
			for(Order order : filledOrders) {
				fileWriter.write(order + "\n");
			}
			fileWriter.close();
		} catch(IOException e) {
			System.out.print("There is no data regarding previous orders.");
		}
		
	}

}
