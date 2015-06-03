package com.ues.bean;
import com.ues.dao.PersonasDao;
import com.ues.model.Persona;
import java.util.List;

/**
 *
 * @author Jocelyn
 */
public class PersonasBean {
    
    
    private List<Persona> miLista;
    private PersonasDao personasDao;
    
    public PersonasBean(){
    }

    public List<Persona> getMiLista() {
        try {
            miLista = personasDao.listaPersonas();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return miLista;
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

    
}


