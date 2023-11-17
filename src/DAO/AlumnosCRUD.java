package DAO;

import entidades.Alumno;

import java.io.*;
import java.util.ArrayList;

public class AlumnosCRUD {
    public void insertarAlumno(Alumno a){
        try{
            FileInputStream leer =
                    new FileInputStream("C:\\temp\\listaAlumno.txt");
            ObjectInputStream miStream2 = new ObjectInputStream(leer);
            Object o = miStream2.readObject();
            ArrayList<Alumno> otraLista = (ArrayList<Alumno>)o;
            otraLista.add(a);

            //escribir de vuelta al archivo
            FileOutputStream escribir =
                    new FileOutputStream("C:\\temp\\listaAlumno.txt");
            ObjectOutputStream miStream = new ObjectOutputStream(escribir);
            miStream.writeObject(otraLista);
            miStream.close();
            miStream2.close();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public Alumno buscarAlumnoPorMat(String matricula){
        //obtener lista de alumnos desde Archivo
        try{
            FileInputStream leer =
                    new FileInputStream("C:\\temp\\listaAlumno.txt");
            ObjectInputStream miStream2 = new ObjectInputStream(leer);
            Object o = miStream2.readObject();
            ArrayList<Alumno> otraLista = (ArrayList<Alumno>)o;
            for(Alumno a: otraLista){
                if(a.getMatricula().equals(matricula)){
                    return a;
                }
            }
            //saliendo del for
            miStream2.close();
            return null;



           // Alumno pruebaAlumno = otraLista.get(0);
           // System.out.println(pruebaAlumno.getNombre());


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
