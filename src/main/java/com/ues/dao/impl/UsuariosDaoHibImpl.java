package com.ues.dao.impl;

import com.ues.model.CustomHibernateDaoSupport;
import com.ues.dao.UsuariosDao;
import com.ues.exception.DAOException;
import com.ues.model.Usuario;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Airy
 */
public class UsuariosDaoHibImpl extends CustomHibernateDaoSupport implements UsuariosDao {

    
    public void crearUsuario(Usuario usuario) throws DAOException {
        usuario.setFechaCreacion(new Date());
        getHibernateTemplate().saveOrUpdate(usuario);
    }

    public Usuario buscaUsuario(String nombreUsuario) throws DAOException {
        List list = getHibernateTemplate().find(" from Usuario WHERE nombreUsuario=?",nombreUsuario);
        return (Usuario) list.get(0);
    }

    public List<Usuario> listaUsuarios() throws DAOException {
        List<Usuario> lista = getHibernateTemplate().find("from Usuario");
        return lista;
    }

    public void modificarUsuario(Usuario usuario) throws DAOException {
        usuario.setFechaModificacion(new Date());
        getHibernateTemplate().update(usuario);
    }

    public void borrarUsuario(Usuario usuario) throws DAOException {
        getHibernateTemplate().delete(usuario);
    }

}