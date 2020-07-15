package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

public class MainViewController implements Initializable {
	@FXML
	private MenuItem menuItemSeller;
	@FXML
	private MenuItem menuItemDepartment;
	@FXML
	private MenuItem menuItemAbout;

	@FXML
	public void onMenuItemSellerAction() {
		System.out.println("Seller Item");
	}

	@FXML
	public void onMenuItemDepartmentAction() {
		System.out.println("Department Item");
	}

	@FXML
	public void onMenuItemAboutAction() {
		System.out.println("About Item");
	}

	@Override
	public void initialize(URL uri, ResourceBundle rsb) {

	}
}
