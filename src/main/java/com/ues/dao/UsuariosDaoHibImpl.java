package com.ues.dao;

import com.ues.exception.DAOException;
import com.ues.model.Usuario;
import java.util.List;

/**
 *
 * @author Airy
 */
public class UsuariosDaoHibImpl extends CustomHibernateDaoSupport implements UsuariosDao {

    
    public void crearUsuario(Usuario usuario) throws DAOException {
        getHibernateTemplate().saveOrUpdate(usuario);
    }

    public Usuario buscaUsuario(String username) throws DAOException {
        List list = getHibernateTemplate().find(" from Usuario WHERE USERNAME=?",username);
        return (Usuario) list.get(0);
    }

    public List<Usuario> listaUsuarios() throws DAOException {
        List<Usuario> lista = getHibernateTemplate().find("from Usuario");
        return lista;
    }

    public void modificarUsuario(Usuario usuario) throws DAOException {
        getHibernateTemplate().update(usuario);
    }

    public void borrarUsuario(Usuario usuario) throws DAOException {
        getHibernateTemplate().delete(usuario);
    }

}