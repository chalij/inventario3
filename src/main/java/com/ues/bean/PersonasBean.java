package com.ues.bean;

import static com.sun.javafx.logging.PulseLogger.addMessage;
import com.ues.dao.PersonasDao;
import com.ues.model.Persona;
import com.ues.model.Usuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Jocelyn
 */
public class PersonasBean {

    private List<Persona> miLista;
    private PersonasDao personasDao;
    private int idusuarioU;
    private String fechaV;
    private Persona persona = new Persona();

    public PersonasBean() {
    }

    public List<Persona> getMiLista() {
        try {
            miLista = personasDao.listaPersonas();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return miLista;
    }

    public void addPersona(ActionEvent actionEvent) {
        try {
            Persona per = new Persona();
            Usuario us = new Usuario();
            per.setIdPersona(persona.getIdPersona());
            us.setIdUsuario(idusuarioU);
            per.setNombre(persona.getNombre());
            per.setApellido(persona.getApellido());
            per.setGenero(persona.getGenero());
            per.setDui(persona.getDui());
            per.setNit(persona.getNit());
            // ARREGLAR ESTO DE LA FECHA
            Date date= new Date();
            String pattern = "dd/MM/yyyy";
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            try {
                date = format.parse(fechaV);
                System.out.println(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            per.setFechaNac(date);
            per.setDireccion(persona.getDireccion());
            per.setCorreo(persona.getCorreo());
            personasDao.crearPersona(per);
            addMessage("Insertado Id:!!" + persona.getIdPersona());
        } catch (Exception e) {
            addMessage("Error Id:!!" + persona.getIdPersona() + " " + e.getMessage());
            e.printStackTrace();
        }

    }

    public void setMiLista(List<Persona> miLista) {
        this.miLista = miLista;
    }

    public PersonasDao getPersonasDao() {
        return personasDao;
    }

    public void setPersonasDao(PersonasDao personasDao) {
        this.personasDao = personasDao;
    }

    /**
     * @return the idusuarioU
     */
    public int getIdusuarioU() {
        return idusuarioU;
    }

    /**
     * @param idusuarioU the idusuarioU to set
     */
    public void setIdusuarioU(int idusuarioU) {
        this.idusuarioU = idusuarioU;
    }

    /**
     * @return the persona
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * @param persona the persona to set
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    private void addMessage(String welcome_to_Primefaces) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, welcome_to_Primefaces, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * @return the fechaV
     */
    public String getFechaV() {
        return fechaV;
    }

    /**
     * @param fechaV the fechaV to set
     */
    public void setFechaV(String fechaV) {
        this.fechaV = fechaV;
    }

}
