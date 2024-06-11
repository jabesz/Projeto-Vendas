package projeto.vendas.Dao;

import com.github.gilbertotorrezan.viacep.se.ViaCEPClient;
import com.github.gilbertotorrezan.viacep.shared.ViaCEPEndereco;
import projeto.vendas.Jdbc.ConnectionFactory;
import projeto.vendas.Model.Customers;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomersDao {

    private Connection connection;
    public CustomersDao() {
        this.connection = new ConnectionFactory().getConnection();
        if (this.connection == null) {
            System.err.println("Failed to establish database connection!");
        } else {
            System.out.println("Database connection established successfully.");
        }
    }

    public void registerCustomer(Customers obj) {
        try {
            String sql = "insert into tb_clientes (nome, rg, cpf, email, celular, telefone, cep, endereco, numero, complemento, bairro, cidade, estado) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";

            PreparedStatement ps = null;
            try {
                ps = connection.prepareStatement(sql);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            ps.setString(1, obj.getName());
            ps.setString(2, obj.getRg());
            ps.setString(3, obj.getCpf());
            ps.setString(4, obj.getEmail());
            ps.setString(5, obj.getTelephone());
            ps.setString(6, obj.getPhone());
            ps.setString(7, obj.getCep());
            ps.setString(8, obj.getAddress());
            ps.setInt(9, obj.getNumber());
            ps.setString(10, obj.getComplement());
            ps.setString(11, obj.getNeighbor());
            ps.setString(12, obj.getCity());
            ps.setString(13, obj.getUf());

            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "Register Successfully!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }

    public void changeCustomer(Customers obj) {
        try {

            String sql = "update tb_clientes set nome=?, rg=?, cpf=?, email=?, telefone=? ,celular=?, cep=?, "
                    + "endereco=?, numero=?,complemento=?,bairro=?,cidade=?, estado=?  where id =?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, obj.getName());
            ps.setString(2, obj.getRg());
            ps.setString(3, obj.getCpf());
            ps.setString(4, obj.getEmail());
            ps.setString(5, obj.getTelephone());
            ps.setString(6, obj.getPhone());
            ps.setString(7, obj.getCep());
            ps.setString(8, obj.getAddress());
            ps.setInt(9, obj.getNumber());
            ps.setString(10, obj.getComplement());
            ps.setString(11, obj.getNeighbor());
            ps.setString(12, obj.getCity());
            ps.setString(13, obj.getUf());

            ps.setInt(14, obj.getId());

            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "Change Successfully!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }
    }

    public void deleteCustomer(Customers obj) {
        try {

            String sql = "delete from tb_clientes where id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, obj.getId());

            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "Delete Successfully!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }

    }

    public List<Customers> listCustomer() {
        try {

            List<Customers> lista = new ArrayList<>();

            String sql = "select * from tb_clientes";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Customers obj = new Customers();

                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelephone(rs.getString("telefone"));
                obj.setPhone(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setAddress(rs.getString("endereco"));
                obj.setNumber(rs.getInt("numero"));
                obj.setComplement(rs.getString("complemento"));
                obj.setNeighbor(rs.getString("bairro"));
                obj.setCity(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                lista.add(obj);
            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro :" + erro);
            return null;
        }

    }

    public Customers queryByName(String nome) {
        try {
            String sql = "select * from tb_clientes where nome = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, nome);

            ResultSet rs = ps.executeQuery();
            Customers obj = new Customers();

            if (rs.next()) {

                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelephone(rs.getString("telefone"));
                obj.setPhone(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setAddress(rs.getString("endereco"));
                obj.setNumber(rs.getInt("numero"));
                obj.setComplement(rs.getString("complemento"));
                obj.setNeighbor(rs.getString("bairro"));
                obj.setCity(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));
            }

            return obj;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Customer not found!");
            return null;
        }
    }

    public Customers searchByCPF(String cpf) {
        try {
            String sql = "select * from tb_clientes where cpf = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cpf);

            ResultSet rs = ps.executeQuery();
            Customers obj = new Customers();

            if (rs.next()) {

                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelephone(rs.getString("telefone"));
                obj.setPhone(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setAddress(rs.getString("endereco"));
                obj.setNumber(rs.getInt("numero"));
                obj.setComplement(rs.getString("complemento"));
                obj.setNeighbor(rs.getString("bairro"));
                obj.setCity(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));
            }

            return obj;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Customer not found!");
            return null;
        }
    }




    public List<Customers> SearchCustomerByName(String nome) {
        try {

            List<Customers> lista = new ArrayList<>();

            String sql = "select * from tb_clientes where nome like ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, nome);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Customers obj = new Customers();

                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelephone(rs.getString("telefone"));
                obj.setPhone(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setAddress(rs.getString("endereco"));
                obj.setNumber(rs.getInt("numero"));
                obj.setComplement(rs.getString("complemento"));
                obj.setNeighbor(rs.getString("bairro"));
                obj.setCity(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                lista.add(obj);
            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro :" + erro);
            return null;
        }
    }

    public Customers searchCep(String cep) throws IOException {
        ViaCEPClient client = new ViaCEPClient();
        ViaCEPEndereco address = client.getEndereco(cep);


        Customers obj = new Customers();

        obj.setAddress(address.getLogradouro());
        obj.setCity(address.getLocalidade());
        obj.setNeighbor(address.getBairro());
        obj.setUf(address.getUf());
        return obj;
    }
}
