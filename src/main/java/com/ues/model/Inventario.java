package com.ues.model;
// Generated 30-may-2015 11:21:15 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Inventario generated by hbm2java
 */
public class Inventario  implements java.io.Serializable {


     private int idInventario;
     private Empleado empleado;
     private Bodega bodega;
     private String nombre3;
     private BigDecimal monto;
     private Set<Transaccion> transaccions = new HashSet<Transaccion>(0);

    public Inventario() {
    }

	
    public Inventario(int idInventario, Empleado empleado, String nombre3, BigDecimal monto) {
        this.idInventario = idInventario;
        this.empleado = empleado;
        this.nombre3 = nombre3;
        this.monto = monto;
    }
    public Inventario(int idInventario, Empleado empleado, Bodega bodega, String nombre3, BigDecimal monto, Set<Transaccion> transaccions) {
       this.idInventario = idInventario;
       this.empleado = empleado;
       this.bodega = bodega;
       this.nombre3 = nombre3;
       this.monto = monto;
       this.transaccions = transaccions;
    }
   
    public int getIdInventario() {
        return this.idInventario;
    }
    
    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }
    public Empleado getEmpleado() {
        return this.empleado;
    }
    
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    public Bodega getBodega() {
        return this.bodega;
    }
    
    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }
    public String getNombre3() {
        return this.nombre3;
    }
    
    public void setNombre3(String nombre3) {
        this.nombre3 = nombre3;
    }
    public BigDecimal getMonto() {
        return this.monto;
    }
    
    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
    public Set<Transaccion> getTransaccions() {
        return this.transaccions;
    }
    
    public void setTransaccions(Set<Transaccion> transaccions) {
        this.transaccions = transaccions;
    }




}


