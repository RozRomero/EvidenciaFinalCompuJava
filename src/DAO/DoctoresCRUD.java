package DAO;

import entidades.Doctor;

import java.util.ArrayList;
import java.util.Iterator;

public class DoctoresCRUD {
    private ArrayList<Doctor> listaDoctores;

    public DoctoresCRUD() {
        listaDoctores = new ArrayList<>();
    }

    public ArrayList<Doctor> getListaDoctores() {
        return listaDoctores;
    }

    public void setListaDoctores(ArrayList<Doctor> listaDoctores) {
        this.listaDoctores = listaDoctores;
    }

    public void insertarDoctor(Doctor doctor) {
        // Agrega un doctor a la lista
        listaDoctores.add(doctor);
    }

    public Doctor buscarDoctorPorID(String ID) {
        // Busca un doctor por su ID
        Iterator<Doctor> iterator = listaDoctores.iterator();
        while (iterator.hasNext()) {
            Doctor doctor = iterator.next();
            if (doctor.getIdDoctor().equals(ID)) {
                return doctor;
            }
        }
        return null; // Retorna null si el doctor no se encuentra
    }

    public void mostrarDoctores() {
        System.out.println("Lista de Doctores:");
        for (Doctor doctor : listaDoctores) {
            System.out.println(doctor);
        }
    }
}
