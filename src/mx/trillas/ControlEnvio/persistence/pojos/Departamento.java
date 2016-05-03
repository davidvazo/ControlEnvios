package mx.trillas.ControlEnvio.persistence.pojos;
// Generated 19/04/2016 10:31:08 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Departamento generated by hbm2java
 */
public class Departamento  implements java.io.Serializable {

     private Integer id;
     private String nombre;
     private Set destinatarios = new HashSet(0);

    public Departamento() {
    }
	
    public Departamento(String nombre) {
        this.nombre = nombre;
    }
    public Departamento(String nombre, Set destinatarios) {
       this.nombre = nombre;
       this.destinatarios = destinatarios;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set getDestinatarios() {
        return this.destinatarios;
    }
    
    public void setDestinatarios(Set destinatarios) {
        this.destinatarios = destinatarios;
    }

    public String toString(){
    	return this.getNombre();
    }


}

