/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.dao.impl;

import com.ues.dao.TipoUsuarioDao;
import com.ues.dao.UsuariosDao;
import com.ues.exception.DAOException;
import com.ues.model.CustomHibernateDaoSupport;
import com.ues.model.TipoUsuario;
import java.util.Date;
import java.util.List;

/**
 *
 * @author malo
 */
public class TipoUsuarioDaoHibImpl extends CustomHibernateDaoSupport implements TipoUsuarioDao  {

    public void crearUsuario(TipoUsuario tipoUsuario) throws DAOException {
        getHibernateTemplate().saveOrUpdate(tipoUsuario);
    }


    public TipoUsuario buscaTipoUsuario(String nombre) throws DAOException {
        List list = getHibernateTemplate().find(" from TipoUsuario WHERE nombre=?",nombre);
        return (TipoUsuario) list.get(0);
    }

   
    public List<TipoUsuario> listaTipoUsuarios() throws DAOException {
        List<TipoUsuario> lista = getHibernateTemplate().find("from TipoUsuario order by idTipoUsuario");
        return lista;
    }

    public void modificarTipoUsuario(TipoUsuario tipoUsuario) throws DAOException {
        getHibernateTemplate().update(tipoUsuario);
    }

    public void borrarTipoUsuario(TipoUsuario tipoUsuario) throws DAOException {
        getHibernateTemplate().delete(tipoUsuario);
    }

}
