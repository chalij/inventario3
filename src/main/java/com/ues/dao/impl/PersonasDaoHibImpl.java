
package com.ues.dao.impl;

import com.ues.model.CustomHibernateDaoSupport;
import com.ues.dao.PersonasDao;
import com.ues.exception.DAOException;
import com.ues.model.Persona;
import java.util.List;

/**
 *
 * @author Jocelyn
 * 
 */
public class PersonasDaoHibImpl extends CustomHibernateDaoSupport implements PersonasDao {

        
    public void crearPersona(Persona persona) throws DAOException {
        getHibernateTemplate().saveOrUpdate(persona);
    }

    public Persona buscaPersona(Integer idPersona) throws DAOException {
        List list = getHibernateTemplate().find(" from Persona WHERE ID_PERSONA=?",idPersona);
        return (Persona) list.get(0);
    }

    public List<Persona> listaPersonas() throws DAOException {
        List<Persona> lista = getHibernateTemplate().find("from Persona");
        return lista;
    }

    public void modificarPersona(Persona persona) throws DAOException {
        getHibernateTemplate().update(persona);
    }

    public void borrarPersona(Persona persona) throws DAOException {
        getHibernateTemplate().delete(persona);
    }

    
}
