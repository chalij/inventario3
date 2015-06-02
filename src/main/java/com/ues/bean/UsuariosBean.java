package com.ues.bean;

import com.ues.dao.UsuariosDao;
import com.ues.model.Usuario;
import java.util.List;

/**
 *
 * @author Airy
 */
public class UsuariosBean {
    private List<Usuario> miLista;
    private UsuariosDao usuariosDao;
    
    public UsuariosBean(){
    }

    public List<Usuario> getMiLista() {
        try {
            miLista = usuariosDao.listaUsuarios();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return miLista;
    }

    public void setMiLista(List<Usuario> miLista) {
        this.miLista = miLista;
    }

    public UsuariosDao getUsuariosDao() {
        return usuariosDao;
    }

    public void setUsuariosDao(UsuariosDao usuariosDao) {
        this.usuariosDao = usuariosDao;
    }
}