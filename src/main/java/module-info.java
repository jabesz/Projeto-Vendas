module projeto.vendas {
    requires javafx.controls;
    requires javafx.fxml;
    requires viacep;
    requires java.desktop;
    requires java.sql;


    opens projeto.vendas to javafx.fxml;
    exports projeto.vendas;
    opens projeto.vendas.Model to java.base;
    exports projeto.vendas.Model;
}