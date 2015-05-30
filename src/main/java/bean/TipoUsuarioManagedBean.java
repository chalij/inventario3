/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import model.TipoUsuario;

/**
 *
 * @author Administrador
 */
@Named(value = "tipoUsuarioManagedBean")
@Dependent
public class TipoUsuarioManagedBean {
    
    /**
     * Creates a new instance of TipoUsuarioManagedBean
     */
    public TipoUsuarioManagedBean() {
    }

   /* public List<TipoUsuario> getTipoUsuario() {
    }*/

}
