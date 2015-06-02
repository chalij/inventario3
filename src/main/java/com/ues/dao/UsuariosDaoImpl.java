package com.ues.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.ues.exception.DAOException;
import com.ues.model.Usuario;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Airy
 */
public class UsuariosDaoImpl implements UsuariosDao {

   private DataSource dataSource;
   private JdbcTemplate jdbcTemplate;

   public void crearUsuario(Usuario usuario) throws DAOException {
       Object[] args = new Object[]{
           usuario.getTipoUsuario().getIdTipoUsuario(),
           usuario.getNombreUsuario(),
           usuario.getContrasena(),
           usuario.getFechaCreacion(),
           usuario.getFechaModificacion(),
       };

       String idUsuario = "";
       String sql = "INSERT INTO USUARIO("
               + "ID_TIPO_USUARIO,"
               + "NOMBRE_USUARIO,"
               + "CONTRASENA,"
               + "FECHA_CREACION,"
               + "FECHA_MODIFICACION "
               + ") VALUES(?, ?, ?,?,?,?)";

       try {
           this.jdbcTemplate.update(sql, args);
       } catch (Exception e) {
           e.printStackTrace();
           throw new DAOException("Error de acceso a datos: " + e.getMessage());
       }
   }

   public Usuario buscaUsuario(String username) throws DAOException {
       Usuario usuario = null;
       Object[] args = new Object[]{
           username
       };
       try {
           String sql = "SELECT "
               + "ID_USUARIO,"
              // + "ID_TIPO_USUARIO,"
               + "NOMBRE_USUARIO,"
               + "CONTRASENA "
            //   + "FECHA_CREACION,"
            //   + "FECHA_MODIFICACION "
                   + "FROM USUARIO WHERE NOMBRE_USUARIO=?";
           usuario = (Usuario) this.jdbcTemplate.queryForObject(sql, args,
                   new RowMapper() {

                       public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                           Usuario usuario = new Usuario();
                           usuario.setIdUsuario(rs.getInt("ID_USUARIO"));
                         //  usuario.setTipoUsuario(new TipoUsuario.rs.getInt("ID_TIPO_USUARIO"));
                           usuario.setNombreUsuario(rs.getString("NOMBRE_USUARIO"));
                           usuario.setContrasena(rs.getString("CONTRASENA"));
                       //    usuario.setFechaCreacion(rs.getString("USERNAME"));
                         //  usuario.setPassword(rs.getString("PASSWORD"));
                           return usuario;
                       }
                   });
       } catch (EmptyResultDataAccessException ee) {
           return null;
       } catch (DataAccessException ex) {
           throw new DAOException("Error de acceso a datos: " + ex.getMessage());
       }
       return usuario;
   }

   public List<Usuario> listaUsuarios() throws DAOException {
       List<Usuario> usuarios = null;
       try {
           String sql = "SELECT "
               + "ID_USUARIO,"
              // + "ID_TIPO_USUARIO,"
               + "NOMBRE_USUARIO,"
               + "CONTRASENA "
              // + "FECHA_CREACION,"
             //  + "FECHA_MODIFICACION "
                   + "FROM USUARIO";
           usuarios = this.jdbcTemplate.query(sql,
                   new RowMapper() {

                       public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                           Usuario usuario = new Usuario();
                           usuario.setIdUsuario(rs.getInt("ID_USUARIO"));
                         //  usuario.setTipoUsuario(new TipoUsuario.rs.getInt("ID_TIPO_USUARIO"));
                           usuario.setNombreUsuario(rs.getString("NOMBRE_USUARIO"));
                           usuario.setContrasena(rs.getString("CONTRASENA"));
                       //    usuario.setFechaCreacion(rs.getString("USERNAME"));
                         //  usuario.setPassword(rs.getString("PASSWORD"));
                           return usuario;
                       }
                   });
       } catch (EmptyResultDataAccessException ee) {
           return null;
       } catch (DataAccessException ex) {
           throw new DAOException("Error de acceso a datos: " + ex.getMessage());
       }
       return usuarios;
   }

   public void modificarUsuario(Usuario usuario) throws DAOException {
       Object[] args = new Object[]{
           usuario.getTipoUsuario().getIdTipoUsuario(),
           usuario.getNombreUsuario(),
           usuario.getContrasena(),
           usuario.getFechaCreacion(),
           usuario.getFechaModificacion(),
           usuario.getIdUsuario()
       };
       String sql = "UPDATE usuario SET "
               + "ID_TIPO_USUARIO=?,"
               + "NOMBRE_USUARIO=?,"
               + "CONTRASENA=?,"
               + "FECHA_CREACION=?,"
               + "FECHA_MODIFICACION=? "
               + "WHERE ID_USUARIO=?";
       try {
           this.jdbcTemplate.update(sql, args);
       } catch (Exception e) {
           e.printStackTrace();
           throw new DAOException("Error de acceso a datos: " + e.getMessage());
       }
   }

   public void borrarUsuario(Usuario usuario) throws DAOException {
       Object[] args = new Object[]{
           usuario.getIdUsuario()
       };
       String sql = "DELETE FROM usuario WHERE ID_USUARIO=?";
       try {
           this.jdbcTemplate.update(sql, args);
       } catch (Exception e) {
           e.printStackTrace();
           throw new DAOException("Error de acceso a datos: " + e.getMessage());
       }
   }

   public DataSource getDataSource() {
       return dataSource;
   }

   public void setDataSource(DataSource dataSource) {
       this.dataSource = dataSource;
       this.setJdbcTemplate(new JdbcTemplate(dataSource));
   }

   public JdbcTemplate getJdbcTemplate() {
       return jdbcTemplate;
   }

   public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
       this.jdbcTemplate = jdbcTemplate;
   }
}