package com.ues.bean;

import com.ues.dao.UsuariosDao;
import com.ues.exception.DAOException;
import com.ues.model.TipoUsuario;
import com.ues.model.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

/**
 *
 * @author Airy
 */
public class UsuariosBean {

    private Usuario usuario = new Usuario();
    private int tipoUsuarioT;
    private List<Usuario> miLista;
    private UsuariosDao usuariosDao;
    private String city;  
    private Map<String,String> cities = new HashMap<String, String>();
    
    private String car;  
    private List<SelectItem> cars;

    public UsuariosBean() {
    }

    public List<SelectItem> getMiLista() {
        try {
            //miLista = usuariosDao.listaUsuarios();
            Usuario u1=new Usuario();
            Usuario u2=new Usuario();
            Usuario u3=new Usuario();
        SelectItemGroup g1 = new SelectItemGroup("German Cars");
        g1.setSelectItems(new SelectItem[] {new SelectItem(u1), new SelectItem(u2), new SelectItem(u3)});
         
         
            setCars(new ArrayList<SelectItem>());
            cars.add(g1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cars;
    }

    public void addUsuario(ActionEvent actionEvent) {
        try {
            Usuario us = new Usuario();
            TipoUsuario tus = new TipoUsuario();
            tus.setIdTipoUsuario(tipoUsuarioT);
            us.setIdUsuario(usuario.getIdUsuario());
            us.setNombreUsuario(usuario.getNombreUsuario());
            us.setContrasena(usuario.getContrasena());
            us.setFechaCreacion(new Date());
            us.setTipoUsuario(tus);
            usuariosDao.crearUsuario(us);
            addMessage("Insertado Id:!!" + usuario.getIdUsuario());
        } catch (Exception e) {
            addMessage("Error Id:!!" + usuario.getIdUsuario()+" "+ e.getMessage());
            e.printStackTrace();
        }

    }

    public Map<String,String> listaDesp()
    {
        
        cities = new HashMap<String, String>();
        cities.put("New York", "New York");
        cities.put("London","London");
        cities.put("Paris","Paris");
        cities.put("Barcelona","Barcelona");
        cities.put("Istanbul","Istanbul");
        cities.put("Berlin","Berlin");
        return cities;
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
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, welcome_to_Primefaces, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * @return the tipoUsuarioT
     */
    public int getTipoUsuarioT() {
        return tipoUsuarioT;
    }

    /**
     * @param tipoUsuarioT the tipoUsuarioT to set
     */
    public void setTipoUsuarioT(int tipoUsuarioT) {
        this.tipoUsuarioT = tipoUsuarioT;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the cities
     */
    public Map<String,String> getCities() {
        return cities;
    }

    /**
     * @param cities the cities to set
     */
    public void setCities(Map<String,String> cities) {
        this.cities = cities;
    }

    /**
     * @return the car
     */
    public String getCar() {
        return car;
    }

    /**
     * @param car the car to set
     */
    public void setCar(String car) {
        this.car = car;
    }

    /**
     * @return the cars
     */
    public List<SelectItem> getCars() {
        return cars;
    }

    /**
     * @param cars the cars to set
     */
    public void setCars(List<SelectItem> cars) {
        this.cars = cars;
    }

}
