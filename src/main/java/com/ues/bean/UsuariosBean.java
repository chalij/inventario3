package com.ues.bean;

import com.ues.dao.UsuariosDao;
import com.ues.exception.DAOException;
import com.ues.model.Usuario;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Airy
 */
public class UsuariosBean {
    private Usuario usuario = new Usuario();
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

    public void addUsuario(ActionEvent actionEvent) {
        addMessage("Welcome to Primefaces!!");
      /*  System.out.println("sdfdsf");
                Usuario us=new Usuario();
                us.setIdUsuario(4);
                us.setNombreUsuario("chali2");
                us.setContrasena("123");
                usuariosDao.crearUsuario(us);*/
 
 
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

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    private void addMessage(String welcome_to_Primefaces) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "xD",  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}