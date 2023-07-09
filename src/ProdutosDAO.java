/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto) throws SQLException, ClassNotFoundException{
        
        
        String sql = "INSERT INTO filmes (nome, valor) VALUES (?,?);";
        conn = conectaDAO.connectDB();
        prep = conn.prepareStatement(sql);
        
        try{
            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getValor());
            
            prep.execute();
            prep.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Dados Cadastrar:" + erro);
        }
        
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        String sql = "SELECT * FROM filmes";
        try {
            conn = conectaDAO.connectDB();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            prep = conn.prepareStatement(sql);
            resultset = prep.executeQuery();
            while(resultset.next()){
                ProdutosDTO objdadosdto = new ProdutosDTO();
                objdadosdto.setNome(resultset.getString("nome"));
                objdadosdto.setValor(resultset.getInt("valor"));
                objdadosdto.setStatus(resultset.getString("status"));
                
                boolean add = listagem.add(objdadosdto);
            }
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Dados Pesquisar: " + erro);
        }
        return listagem;
    }
    
    
    
        
}

