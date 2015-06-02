package dao;

import com.ejemplos.exception.DAOException;
import model.Usuario;
import java.util.List;

/**
 *
 * @author Airy
 */
public interface UsuariosDao {

   public void crearUsuario(Usuario usuario) throws DAOException;
   public Usuario buscaUsuario(String username) throws DAOException;
   public List<Usuario> listaUsuarios() throws DAOException;
   public void modificarUsuario(Usuario usuario) throws DAOException;
   public void borrarUsuario(Usuario usuario) throws DAOException;
}