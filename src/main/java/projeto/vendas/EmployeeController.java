package projeto.vendas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import projeto.vendas.Dao.CustomersDao;
import projeto.vendas.Dao.EmployeeDao;
import projeto.vendas.Model.Customers;
import projeto.vendas.Model.Employee;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class EmployeeController implements Initializable  {
    @FXML
    private Button btAddEmployee;

    @FXML
    private Button btSearchName;

    @FXML
    private ComboBox<String> cbAccessLevel;

    @FXML
    private ComboBox<String> cbuf;

    @FXML
    private TableColumn<Employee, String> colAccessLevel;

    @FXML
    private TableColumn<Employee, String> colAddress;

    @FXML
    private TableColumn<Employee, String> colCPF;

    @FXML
    private TableColumn<Employee, String> colCep;

    @FXML
    private TableColumn<Employee, String> colCity;

    @FXML
    private TableColumn<Employee, Integer> colCode;

    @FXML
    private TableColumn<Employee, String> colComplement;

    @FXML
    private TableColumn<Employee, String> colEmail;

    @FXML
    private TableColumn<Employee, String> colName;

    @FXML
    private TableColumn<Employee, String> colNeighbor;

    @FXML
    private TableColumn<Employee, Integer> colNumber;

    @FXML
    private TableColumn<Employee, String> colOffice;

    @FXML
    private TableColumn<Employee, String> colPassword;

    @FXML
    private TableColumn<Employee, String> colPhone;

    @FXML
    private TableColumn<Employee, String> colRG;

    @FXML
    private TableColumn<Employee, String> colState;

    @FXML
    private TableColumn<Employee, String> colTelephone;

    @FXML
    private TableView<Employee> tableEmployee;

    @FXML
    private TextField txtaddress;

    @FXML
    private TextField txtcep;

    @FXML
    private TextField txtcity;

    @FXML
    private TextField txtcode;

    @FXML
    private TextField txtcomplement;

    @FXML
    private TextField txtcpf;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtneighbor;

    @FXML
    private TextField txtnumber;

    @FXML
    private TextField txtoffice;

    @FXML
    private PasswordField txtpassword;

    @FXML
    private TextField txtphone;

    @FXML
    private TextField txtrg;

    @FXML
    private TextField txtsearch;

    @FXML
    private TextField txttelephone;

    private ObservableList<Employee> employeeData;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cbAccessLevel.getItems().add("Level1");
        cbAccessLevel.getItems().add("Level2");

        colCode.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colRG.setCellValueFactory(new PropertyValueFactory<>("rg"));
        colCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colTelephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colCep.setCellValueFactory(new PropertyValueFactory<>("cep"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colNumber.setCellValueFactory(new PropertyValueFactory<>("number"));
        colComplement.setCellValueFactory(new PropertyValueFactory<>("complement"));
        colNeighbor.setCellValueFactory(new PropertyValueFactory<>("neighbor"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        colOffice.setCellValueFactory(new PropertyValueFactory<>("office"));
        colState.setCellValueFactory(new PropertyValueFactory<>("uf"));
        colAccessLevel.setCellValueFactory(new PropertyValueFactory<>("accessLevel"));

        employeeData = FXCollections.observableArrayList();
        tableEmployee.setItems(employeeData);
    }

    public void list(){
        EmployeeDao dao = new EmployeeDao();
        List<Employee> list = dao.listEmployee();
        employeeData.clear();
        employeeData.addAll(list);
    }

    @FXML
    void addEmployee(ActionEvent event) {
        Employee obj = new Employee();

        obj.setName(txtname.getText());
        obj.setRg((txtrg.getText()));
        obj.setCpf(txtcpf.getText());
        obj.setEmail(txtemail.getText());
        obj.setTelephone(txttelephone.getText());
        obj.setPhone(txtphone.getText());
        obj.setPassword(txtpassword.getText());
        obj.setOffice(txtoffice.getText());
        obj.setCep(txtcep.getText());
        obj.setAddress(txtaddress.getText());
        obj.setNumber(Integer.parseInt(txtnumber.getText()));
        obj.setComplement(txtcomplement.getText());
        obj.setNeighbor(txtneighbor.getText());
        obj.setCity(txtcity.getText());
        obj.setUf(cbuf.getSelectionModel().getSelectedItem());
        obj.setAccessLevel(cbAccessLevel.getSelectionModel().getSelectedItem());

        var dao = new EmployeeDao();

        dao.registerEmployee(obj);
    }

    @FXML
    void deleteEmployee(ActionEvent event) {
        Employee obj = new Employee();

        obj.setId(Integer.parseInt(txtcode.getText()));

        EmployeeDao dao = new EmployeeDao();

        dao.deleteEmployee(obj);
    }

    @FXML
    void editEmployee(ActionEvent event) {
        Employee obj = new Employee();

        obj.setName(txtname.getText());
        obj.setRg((txtrg.getText()));
        obj.setCpf(txtcpf.getText());
        obj.setEmail(txtemail.getText());
        obj.setTelephone(txttelephone.getText());
        obj.setPhone(txtphone.getText());
        obj.setCep(txtcep.getText());
        obj.setAddress(txtaddress.getText());
        obj.setNumber(Integer.parseInt(txtnumber.getText()));
        obj.setComplement(txtcomplement.getText());
        obj.setNeighbor(txtneighbor.getText());
        obj.setCity(txtcity.getText());
        obj.setPassword(txtpassword.getText());
        obj.setOffice(txtoffice.getText());
        obj.setUf(cbuf.getSelectionModel().getSelectedItem());
        obj.setAccessLevel(cbAccessLevel.getSelectionModel().toString());

        obj.setId(Integer.parseInt(txtcode.getText()));

        EmployeeDao dao = new EmployeeDao();

        dao.changeEmployee(obj);
    }

    @FXML
    void mouseClickcedTableEmployee(MouseEvent event) {
        int selectedIndex = tableEmployee.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            txtcode.setText(String.valueOf(tableEmployee.getItems().get(selectedIndex).getId()));
            txtname.setText(tableEmployee.getItems().get(selectedIndex).getName());
            txtrg.setText(tableEmployee.getItems().get(selectedIndex).getRg());
            txtcpf.setText(tableEmployee.getItems().get(selectedIndex).getCpf());
            txtemail.setText(tableEmployee.getItems().get(selectedIndex).getEmail());
            txttelephone.setText(tableEmployee.getItems().get(selectedIndex).getTelephone());
            txtphone.setText(tableEmployee.getItems().get(selectedIndex).getPhone());
            txtcep.setText(tableEmployee.getItems().get(selectedIndex).getCep());
            txtaddress.setText(tableEmployee.getItems().get(selectedIndex).getAddress());
            txtnumber.setText(String.valueOf(tableEmployee.getItems().get(selectedIndex).getNumber()));
            txtcomplement.setText(tableEmployee.getItems().get(selectedIndex).getComplement());
            txtpassword.setText(tableEmployee.getItems().get(selectedIndex).getPassword());
            txtoffice.setText(tableEmployee.getItems().get(selectedIndex).getOffice());
            txtneighbor.setText(tableEmployee.getItems().get(selectedIndex).getNeighbor());
            txtcity.setText(tableEmployee.getItems().get(selectedIndex).getCity());
            cbuf.setValue(tableEmployee.getItems().get(selectedIndex).getUf());
            cbAccessLevel.setValue(tableEmployee.getItems().get(selectedIndex).getAccessLevel());
        }
    }

    @FXML
    void newEmployee(ActionEvent event) {

    }

    @FXML
    void seacrhCpf(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER) {
            Employee obj = new Employee();
            EmployeeDao dao = new EmployeeDao();

            obj = dao.searchByCPF(txtcpf.getText());
            System.out.println(txtcpf.getText());

            txtcode.setText(String.valueOf(obj.getId()));
            txtname.setText(obj.getName());
            txtrg.setText(obj.getRg());
            txtcpf.setText(obj.getCpf());
            txtemail.setText(obj.getEmail());
            txttelephone.setText(obj.getTelephone());
            txtphone.setText(obj.getPhone());
            txtcep.setText(obj.getCep());
            txtaddress.setText(obj.getAddress());
            txtnumber.setText(String.valueOf(obj.getNumber()));
            txtcomplement.setText(obj.getComplement());
            txtpassword.setText(obj.getPassword());
            txtoffice.setText(obj.getOffice());
            txtneighbor.setText(obj.getNeighbor());
            txtcity.setText(obj.getCity());
            cbuf.setValue((obj.getUf()));
            cbAccessLevel.setValue((obj.getAccessLevel()));
        }
    }

    @FXML
    void searchCep(KeyEvent event) {
        if(event.getCode() == KeyCode.TAB) {
            Employee obj = new Employee();
            EmployeeDao dao = new EmployeeDao();

            try {
                obj = dao.searchCep(txtcep.getText());
                System.out.println(txtcep.getText());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            txtaddress.setText(obj.getAddress());
            txtneighbor.setText(obj.getNeighbor());
            txtcity.setText((obj.getCity()));
            cbuf.setValue((obj.getUf()));
        }
    }

    @FXML
    void searchName(ActionEvent event) {
        String name = txtname.getText();
        Employee obj = new Employee();
        EmployeeDao dao = new EmployeeDao();

        obj = dao.queryByName(name);

        if (obj.getName() != null) {
            txtcode.setText(String.valueOf(obj.getId()));
            txtname.setText(obj.getName());
            txtrg.setText(obj.getRg());
            txtcpf.setText(obj.getCpf());
            txtemail.setText(obj.getEmail());
            txtpassword.setText(obj.getPassword());
            txtoffice.setText(obj.getOffice());
            cbuf.setValue(obj.getAccessLevel());
            txttelephone.setText(obj.getTelephone());
            txtphone.setText(obj.getPhone());
            txtcep.setText(obj.getCep());
            txtaddress.setText(obj.getAddress());
            txtnumber.setText(String.valueOf(obj.getNumber()));
            txtcomplement.setText(obj.getComplement());
            txtneighbor.setText(obj.getNeighbor());
            txtcity.setText(obj.getCity());
            cbuf.setValue(obj.getUf());
        } else {
            JOptionPane.showMessageDialog(null, "Employee not found!");
        }
    }

    @FXML
    void searchNameTable(ActionEvent event) {
        String name = "%" + txtsearch.getText() + "%";

        EmployeeDao dao = new EmployeeDao();
        List<Employee> list = dao.SearchEmployeeByName(name);

        ObservableList<Employee> data = FXCollections.observableArrayList(list);
        tableEmployee.setItems(data);
    }
    }



