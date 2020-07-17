package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentListController implements Initializable {

	private DepartmentService departmentService;

	@FXML
	private TableView<Department> tbDepartments;
	@FXML
	private TableColumn<Department, Integer> tcId;

	@FXML
	private TableColumn<Department, String> tcName;

	@FXML
	private Button btnNewDepartment;

	private ObservableList<Department> obsListDep;

	@FXML
	public void onBtnNewAction() {
		System.out.println("Created with Sucess!");
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	private void initializeNodes() {
		tcId.setCellValueFactory(new PropertyValueFactory<>("Id"));
		tcName.setCellValueFactory(new PropertyValueFactory<>("Name"));

		Stage stage = (Stage) Main.getMainScene().getWindow();
		tbDepartments.prefHeightProperty().bind(stage.heightProperty());

	}

	public void updateTableView() {
		if (departmentService == null) {
			throw new IllegalStateException("Department Serve was null");
		}
		List<Department> listDep = departmentService.findAll();
		obsListDep = FXCollections.observableArrayList(listDep);
		tbDepartments.setItems(obsListDep);
	}
}
