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
import projeto.vendas.Model.Customers;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {

    @FXML
    private Button btDelete;

    @FXML
    private Button btEdit;

    @FXML
    private Button btNew;

    @FXML
    private Button btSave;

    @FXML
    private Button btSearchNameTable;

    @FXML
    private Button btSearchName;

    @FXML
    private ComboBox<String> cbuf;


    @FXML
    private Tab tabCustomerConsultation;

    @FXML
    private Tab tabPersonalData;

    @FXML
    private TableColumn<Customers, String> colAddress;

    @FXML
    private TableColumn<Customers, String> colCPF;

    @FXML
    private TableColumn<Customers, String> colCep;

    @FXML
    private TableColumn<Customers, String> colCity;

    @FXML
    private TableColumn<Customers, Integer> colCode;

    @FXML
    private TableColumn<Customers, String> colComplement;

    @FXML
    private TableColumn<Customers, String> colEmail;

    @FXML
    private TableColumn<Customers, String> colName;

    @FXML
    private TableColumn<Customers, String> colNeighbor;

    @FXML
    private TableColumn<Customers, Integer> colNumber;

    @FXML
    private TableColumn<Customers, String> colPhone;

    @FXML
    private TableColumn<Customers, String> colRG;

    @FXML
    private TableColumn<Customers, String> colState;

    @FXML
    private TableColumn<Customers, String> colTelephone;


    @FXML
    private TableView<Customers> tableCustomers;

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
    private TextField txtsearch;

    @FXML
    private TextField txtphone;

    @FXML
    private TextField txtrg;

    @FXML
    private TextField txttelephone;

    private ObservableList<Customers> customersData;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
        colState.setCellValueFactory(new PropertyValueFactory<>("uf"));

        customersData = FXCollections.observableArrayList();
        tableCustomers.setItems(customersData);
    }

    public void list(){
        CustomersDao dao = new CustomersDao();
        List<Customers> list = dao.listCustomer();
        customersData.clear();
        customersData.addAll(list);
    }

    @FXML
    void addCustomer(ActionEvent event) {
        Customers obj = new Customers();

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
        obj.setUf(cbuf.getSelectionModel().getSelectedItem());

        CustomersDao dao = new CustomersDao();

        dao.registerCustomer(obj);
    }

    @FXML
    void deleteCustomer(ActionEvent event) {
        Customers obj = new Customers();

        obj.setId(Integer.parseInt(txtcode.getText()));

        CustomersDao dao = new CustomersDao();

        dao.deleteCustomer(obj);
    }

    @FXML
    void editCustomer(ActionEvent event) {
        Customers obj = new Customers();

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
        obj.setUf(cbuf.getSelectionModel().getSelectedItem());

        obj.setId(Integer.parseInt(txtcode.getText()));

        CustomersDao dao = new CustomersDao();

        dao.changeCustomer(obj);
    }

    @FXML
    void newCustomer(ActionEvent event) {

    }

    @FXML
    void mouseClickcedTableCustomers(MouseEvent event) {

        int selectedIndex = tableCustomers.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            txtcode.setText(String.valueOf(tableCustomers.getItems().get(selectedIndex).getId()));
            txtname.setText(tableCustomers.getItems().get(selectedIndex).getName());
            txtrg.setText(tableCustomers.getItems().get(selectedIndex).getRg());
            txtcpf.setText(tableCustomers.getItems().get(selectedIndex).getCpf());
            txtemail.setText(tableCustomers.getItems().get(selectedIndex).getEmail());
            txttelephone.setText(tableCustomers.getItems().get(selectedIndex).getTelephone());
            txtphone.setText(tableCustomers.getItems().get(selectedIndex).getPhone());
            txtcep.setText(tableCustomers.getItems().get(selectedIndex).getCep());
            txtaddress.setText(tableCustomers.getItems().get(selectedIndex).getAddress());
            txtnumber.setText(String.valueOf(tableCustomers.getItems().get(selectedIndex).getNumber()));
            txtcomplement.setText(tableCustomers.getItems().get(selectedIndex).getComplement());
            txtneighbor.setText(tableCustomers.getItems().get(selectedIndex).getNeighbor());
            txtcity.setText(tableCustomers.getItems().get(selectedIndex).getCity());
            cbuf.setValue(tableCustomers.getItems().get(selectedIndex).getUf());
        }

    }

    @FXML
    void searchName(ActionEvent event) {
        String name = txtname.getText();
        Customers obj = new Customers();
        CustomersDao dao = new CustomersDao();

        obj = dao.queryByName(name);

        if (obj.getName() != null) {
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
            txtneighbor.setText(obj.getNeighbor());
            txtcity.setText(obj.getCity());
            cbuf.setValue((obj.getUf()));
        } else {
            JOptionPane.showMessageDialog(null, "Customers not found!");
        }
    }

    @FXML
    void searchCep(KeyEvent event) {
        if(event.getCode() == KeyCode.TAB) {
            Customers obj = new Customers();
            CustomersDao dao = new CustomersDao();

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
    void searchCpf(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER) {
            Customers obj = new Customers();
            CustomersDao dao = new CustomersDao();

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
            txtneighbor.setText(obj.getNeighbor());
            txtcity.setText(obj.getCity());
            cbuf.setValue((obj.getUf()));
        }
    }

    @FXML
    void searchNameTable(ActionEvent event) {
        String name = "%" + txtsearch.getText() + "%";

        CustomersDao dao = new CustomersDao();
        List<Customers> list = dao.SearchCustomerByName(name);

        ObservableList<Customers> data = FXCollections.observableArrayList(list);
        tableCustomers.setItems(data);
    }

}