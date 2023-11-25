package entidades;

import java.io.Serializable;
import java.util.Date;

public class Paciente implements Serializable {

    String numID;

    public String getnumID() {
        return numID;
    }

    public void setnumID(String numID) {
        this.numID = numID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    String nombre;
    String apPaterno;
    String apMaterno;
    Date fechaNacimiento;



}
