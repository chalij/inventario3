/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.dao;

import com.ues.exception.DAOException;
import java.util.List;
import com.ues.model.TipoUsuario;

/**
 *
 * @author Administrador
 */
public interface TipoUsuarioDao {
    
   public void crearUsuario(TipoUsuario tipoUsuario) throws DAOException;
   public TipoUsuario buscaTipoUsuario(String username) throws DAOException;
   public List<TipoUsuario> listaTipoUsuarios() throws DAOException;
   public void modificarTipoUsuario(TipoUsuario tipoUsuario) throws DAOException;
   public void borrarTipoUsuario(TipoUsuario tipoUsuario) throws DAOException;
}
