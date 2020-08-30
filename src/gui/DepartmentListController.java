package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
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
	public void onBtnNewAction(ActionEvent event) {
		Stage parentStage = Utils.currenteStage(event);
		createDialogForm("/gui/DepartmentForm.fxml", parentStage);
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

	private void createDialogForm(String absoluteName, Stage parentStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Pane pane = loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Enter Department Data");
			dialogStage.setScene(new Scene(pane));
			dialogStage.setResizable(false);
			dialogStage.initOwner(parentStage);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.showAndWait();

		} catch (IOException e) {
			Alerts.showAlert("Erro ao Criar Stage", null, e.getMessage(), AlertType.ERROR);
		}
	}
}
