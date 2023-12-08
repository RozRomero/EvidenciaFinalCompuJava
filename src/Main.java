import entidades.Paciente;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

import DAO.DoctoresCRUD;
import entidades.Doctor;
import entidades.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main extends JFrame {
    private JPanel loginPanel;
    private JTextField txtUsuario;
    private JPasswordField txtpassword;
    private JButton btnIngresar;
    private JPanel mainPanel;
    private JComboBox<String> cmbOperaciones;
    private JButton btnRealizarOperacion;
    private JTextArea txtResultado;
    private JTextArea txtListaDoctores;

    private Usuario usuarioActual;
    private DoctoresCRUD doctoresCRUD;

    public Main() {
        // Inicializa instancias de CRUD y otras configuraciones necesarias
        doctoresCRUD = new DoctoresCRUD();

        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuarioActual = new Usuario();
                usuarioActual.setNombreUsuario(txtUsuario.getText());
                usuarioActual.setpassword(new String(txtpassword.getPassword()));
                usuarioActual.setEsAdmin(true);  // Ajusta según tu lógica real
                mostrarOperaciones();
            }
        });

        btnRealizarOperacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarOperacion();
            }
        });
    }

    private void mostrarOperaciones() {
        // Cambia la visibilidad de los paneles según el tipo de usuario
        loginPanel.setVisible(false);
        mainPanel.setVisible(true);
        if (!usuarioActual.esAdmin()) {
            // Deshabilita operaciones no permitidas para usuarios regulares
            cmbOperaciones.removeItem("CRUD Doctores");
        } else {
            mostrarListaDoctores();
        }
    }

    private void realizarOperacion() {
        String operacionSeleccionada = cmbOperaciones.getSelectedItem().toString();
        txtResultado.setText("");  // Limpia el área de texto

        switch (operacionSeleccionada) {
            case "Ingresar un doctor":
                ingresarDoctor();
                mostrarListaDoctores();
                break;
            case "Consultar un doctor":
                consultarDoctor();
                break;
            // Agrega más casos para otras operaciones
            default:
                txtResultado.setText("Operación no reconocida");
        }
    }

    private void ingresarDoctor() {
        // Lógica para ingresar un doctor
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del doctor:");
        String especialidad = JOptionPane.showInputDialog("Ingrese la especialidad del doctor:");

        Doctor nuevoDoctor = new Doctor(generarIdUnico(), nombre, especialidad);
        doctoresCRUD.insertarDoctor(nuevoDoctor);
        txtResultado.setText("Doctor ingresado con éxito: " + nuevoDoctor);
    }

    private void consultarDoctor() {
        // Lógica para consultar un doctor
        String idDoctor = JOptionPane.showInputDialog("Ingrese el ID del doctor a consultar:");
        Doctor doctorConsultado = doctoresCRUD.buscarDoctorPorID(idDoctor);
        if (doctorConsultado != null) {
            txtResultado.setText("Doctor encontrado: " + doctorConsultado);
        } else {
            txtResultado.setText("Doctor no encontrado con el ID proporcionado.");
        }
    }

    private String generarIdUnico() {
        return "D" + System.currentTimeMillis();
    }

    private void mostrarListaDoctores() {
        ArrayList<Doctor> listaDoctores = doctoresCRUD.getListaDoctores();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Lista de Doctores:\n");
        for (Doctor doctor : listaDoctores) {
            stringBuilder.append(doctor).append("\n");
        }
        txtListaDoctores.setText(stringBuilder.toString());
    }
    }
