package projeto.vendas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashBoardController implements Initializable {
    @FXML
    private Button btRegisterCustomer;

    @FXML
    private Button btRegisterEmployee;

    Scene fxmlFile;
    Parent root;
    Stage window;
    private static Stage pStage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void RegisterEmployee(ActionEvent event) {
        try {
            openModalView("EmployeeView.fxml", "Customer Register");
        } catch (Exception ex) {
            System.out.println("" + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @FXML
    void registerCustomer(ActionEvent event) {
        try {
            openModalView("CustomerView.fxml", "Customer Register");
        } catch (Exception ex) {
            System.out.println("" + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void openModalView(String resource, String title) throws IOException {
        root = FXMLLoader.load(getClass().getResource(resource));
        fxmlFile = new Scene(root);
        window = new Stage();
        window.setScene(fxmlFile);
        window.setTitle(title);
        window.showAndWait();
    }
}
