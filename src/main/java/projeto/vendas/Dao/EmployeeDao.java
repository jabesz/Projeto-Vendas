package projeto.vendas.Dao;

import com.github.gilbertotorrezan.viacep.se.ViaCEPClient;
import com.github.gilbertotorrezan.viacep.shared.ViaCEPEndereco;
import projeto.vendas.Jdbc.ConnectionFactory;
import projeto.vendas.Model.Employee;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    private Connection connection;
    public EmployeeDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void registerEmployee(Employee obj) {
        try {
            String sql = "INSERT INTO tb_funcionarios (nome, rg, cpf, email, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado, senha, cargo, nivel_acesso) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
            ps.setString(14, obj.getPassword());
            ps.setString(15, obj.getOffice());
            ps.setString(16, obj.getAccessLevel());

            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "register successfully!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }

    public void changeEmployee(Employee obj) {
        try {

            String sql = "update tb_funcionarios set  nome=?, rg=?, cpf=?, email=?, telefone=? ,celular=?, cep=?, "
                    + "endereco=?, numero=?,complemento=?,bairro=?,cidade=?, estado=?, senha=?, nivel_acesso=?  where id =?";

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
            ps.setString(14, obj.getPassword());
            ps.setString(15, obj.getOffice());
            ps.setString(16, obj.getAccessLevel());

            ps.setInt(14, obj.getId());

            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "change successfully!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }
    }

    public void deleteEmployee(Employee obj) {
        try {

            String sql = "delete from tb_funcionarios where id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, obj.getId());

            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "Delete successfully!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }

    }

    public List<Employee> listEmployee() {
        try {

            List<Employee> lista = new ArrayList<>();

            String sql = "select * from tb_funcionarios";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Employee obj = new Employee();

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
                obj.setPassword(rs.getString("senha"));
                obj.setOffice(rs.getString("cargo"));
                obj.setAccessLevel(rs.getString("nivel_acesso"));

                lista.add(obj);
            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro :" + erro);
            return null;
        }

    }

    public Employee queryByName(String nome) {
        try {
            String sql = "select * from tb_funcionarios where nome = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, nome);

            ResultSet rs = ps.executeQuery();
            Employee obj = new Employee();

            if (rs.next()) {

                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setPassword(rs.getString("senha"));
                obj.setOffice(rs.getString("cargo"));
                obj.setAccessLevel(rs.getString("nivel_acesso"));
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
            JOptionPane.showMessageDialog(null, "Employee not found!");
            return null;
        }
    }

    public Employee searchByCPF(String cpf) {
        try {
            String sql = "select * from tb_funcionarios where cpf = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cpf);

            ResultSet rs = ps.executeQuery();
            Employee obj = new Employee();

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
                obj.setPassword(rs.getString("senha"));
                obj.setOffice(rs.getString("cargo"));
                obj.setAccessLevel(rs.getString("Nivel Acesso"));
            }

            return obj;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Employee not found!");
            return null;
        }
    }




    public List<Employee> SearchEmployeeByName(String nome) {
        try {

            List<Employee> lista = new ArrayList<>();

            String sql = "select * from tb_funcionarios where nome like ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, nome);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Employee obj = new Employee();

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
                obj.setPassword(rs.getString("senha"));
                obj.setOffice(rs.getString("cargo"));
                obj.setAccessLevel(rs.getString("nivel_acesso"));

                lista.add(obj);
            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro :" + erro);
            return null;
        }
    }

    public Employee searchCep(String cep) throws IOException {

        ViaCEPClient client = new ViaCEPClient();
        ViaCEPEndereco endereco = client.getEndereco(cep);


        Employee obj = new Employee();

        obj.setAddress(endereco.getLogradouro());
        obj.setCity(endereco.getLocalidade());
        obj.setNeighbor(endereco.getBairro());
        obj.setUf(endereco.getUf());
        return obj;
    }
}
