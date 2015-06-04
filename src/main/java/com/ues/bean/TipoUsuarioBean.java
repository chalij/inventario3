/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.bean;

import com.ues.dao.TipoUsuarioDao;
import com.ues.model.TipoUsuario;
import java.util.List;

/**
 *
 * @author malo
 */
public class TipoUsuarioBean {
    
    private List<TipoUsuario> miLista;
    private TipoUsuarioDao tipoUsuarioDao;
    private TipoUsuario tipoUsuarioV;

    /**
     * @return the miLista
     */
    public List<TipoUsuario> getMiLista() {
        try {
            miLista = tipoUsuarioDao.listaTipoUsuarios();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return miLista;
    }

    /**
     * @param miLista the miLista to set
     */
    public void setMiLista(List<TipoUsuario> miLista) {
        this.miLista = miLista;
    }

    /**
     * @return the tipoUsuarioDao
     */
    public TipoUsuarioDao getTipoUsuarioDao() {
        return tipoUsuarioDao;
    }

    /**
     * @param tipoUsuarioDao the tipoUsuarioDao to set
     */
    public void setTipoUsuarioDao(TipoUsuarioDao tipoUsuarioDao) {
        this.tipoUsuarioDao = tipoUsuarioDao;
    }

    /**
     * @return the tipoUsuarioV
     */
    public TipoUsuario getTipoUsuarioV() {
        return tipoUsuarioV;
    }

    /**
     * @param tipoUsuarioV the tipoUsuarioV to set
     */
    public void setTipoUsuarioV(TipoUsuario tipoUsuarioV) {
        this.tipoUsuarioV = tipoUsuarioV;
    }
}
