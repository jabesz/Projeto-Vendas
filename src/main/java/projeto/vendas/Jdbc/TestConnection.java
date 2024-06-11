package projeto.vendas.Jdbc;

import javax.swing.*;

public class TestConnection {
    public static void main(String[] args) {
        try {
            new ConnectionFactory().getConnection();
            JOptionPane.showMessageDialog(null, "Connected");
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
