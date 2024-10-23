package seginfo.gerenciadorSenhas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    
    private Conexao conexao;

    public UsuarioDAO() {
        this.conexao = new Conexao();
    }

    public Usuario salvar(Usuario usuario) {
        try {
            this.conexao.abrirConexao();

            String sql = "INSERT INTO Usuario(nome, email, senha) VALUES(?,?, ?)";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getEmail());
            statement.setString(3, usuario.getSenha());
            statement.executeUpdate();

            return usuario;

        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            this.conexao.fecharConexao();
        }
    }

    public Usuario buscar(String email) {
        try {
            this.conexao.abrirConexao();

            String sql = "SELECT * FROM Usuario WHERE email=?";
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setString(1, email);
            
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Usuario usuario = new Usuario(rs.getLong("id"), 
                    rs.getString("nome"),
                    rs.getString("email"), 
                    rs.getString("senha"));

                return usuario;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            this.conexao.fecharConexao();
        }
    }
}
