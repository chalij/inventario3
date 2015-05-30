/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.TipoUsuario;

/**
 *
 * @author Administrador
 */
public interface TipoUsuarioDao {
    public List<TipoUsuario> mostrarTipoUsuario();
    public void insertarTipoUsuario(TipoUsuario tipoUsuario);
    public void modificarTipoUsuario(TipoUsuario tipoUsuario);
    public void eliminarTipoUsuario(TipoUsuario tipoUsuario);
}
