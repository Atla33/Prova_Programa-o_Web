package Banco;

import entidades.Frutas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class frutaRepositorio {

    public static  void criarTabela(){
        System.out.println("CRIANDO TABELA");
        PreparedStatement st = null;
        Connection conn = null;

        try {
            System.out.println("CRIANDO TABELA - TRY");
            conn = Banco.getConnection();//CONECTANDO
            st = conn.prepareStatement(
                    "CREATE TABLE `frutas` (\n" +
                            "  `idFrutas` int NOT NULL AUTO_INCREMENT,\n" +
                            "  `nome` varchar(45) DEFAULT NULL,\n" +
                            "  `tamanho` varchar(45) DEFAULT NULL,\n" +
                            "  `preco` int DEFAULT NULL,\n" +
                            "  `descricao` varchar(45) DEFAULT NULL,\n" +
                            "  `data_validade` varchar(45) DEFAULT NULL,\n" +
                            "  PRIMARY KEY (`idFrutas`)\n" +
                            ");");
            st.executeUpdate();
        }catch ( Exception e){

        }

    }

    public static List<Frutas> buscarTodos() {
        PreparedStatement st = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            List<Frutas> frutas = new ArrayList<>() ;

            conn = Banco.getConnection();//CONECTANDO
            st = conn.prepareStatement(
                    "SELECT * FROM frutas");
            rs = st.executeQuery();
            while (rs.next()) {
                System.out.println("--------------------------------");

                Frutas obj = new Frutas();
                obj.setIdFruta(rs.getInt("idfrutas"));
                obj.setNome(rs.getString("nome"));
                obj.setTamanho(rs.getString("tamanho"));
                obj.setPreco(rs.getInt("preco"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setData_validade(rs.getString("data_validade"));
                System.out.println(obj);
                Frutas.add(obj);
            }

            return  frutas;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            Banco.closeStatement(st);
            Banco.closeResultSet(rs);
        }
    }


    // public static void inserir (String nome, String livro, String autor, String numero_edicao, String ano, Integer paginas){
    public static void inserir (Frutas frutas){
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = Banco.getConnection();//CONECTANDO

            // EXAMPLE 1:
            statement = conn.prepareStatement(//vai receber o comando SQL e ficar preparado para executar
                    "INSERT INTO frutas "
                            + "(nome, tamanho, preco, descricao, data_validade)"
                            + "VALUES "
                            + "(?, ?, ?, ?, ?)", //5 posicoes
                    Statement.RETURN_GENERATED_KEYS);//SOBRECARGA RECEBE OUTRO PARAMETRO

            statement.setString(1, frutas.getNome());//tipo string, posicao 1
            statement.setString(2, frutas.getTamanho());
            statement.setInt(3, frutas.getPreco());
            statement.setString(4, frutas.getDescricao());
            statement.setString(5, frutas.getData_validade());
            int rowsAffected = statement.executeUpdate();//executa sql e retorna um numero inteiro indicando quantas linhas foram alteradas

            if (rowsAffected > 0) {//SE TEVE LINHA ALTERADA
                ResultSet rs = statement.getGeneratedKeys();//VAI pegar os codigos das linhas alteradas
                while (rs.next()) {
                    int id = rs.getInt(1);//valor da primeira coluna
                    System.out.println("Done! Id: " + id);
                }
            }
            else {
                System.out.println("No rows affected!");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Banco.closeStatement(statement);
            Banco.closeConnection();

        }

    }

    public static Frutas listarProdutosPorId(int id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        Connection conn = null;
        Frutas obj = new Frutas();
        try {
            conn = Banco.getConnection();//CONECTANDO
            st = conn.prepareStatement(
                    "SELECT * FROM frutas WHERE idfrutas = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                obj.setIdFruta(rs.getInt("idfrutas"));
                obj.setNome(rs.getString("nome"));
                obj.setTamanho(rs.getString("tamanho"));
                obj.setPreco(rs.getInt("preco"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setData_validade(rs.getString("data_validade"));
            }

            return  obj;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            Banco.closeStatement(st);
            Banco.closeResultSet(rs);
        }
    }
}
