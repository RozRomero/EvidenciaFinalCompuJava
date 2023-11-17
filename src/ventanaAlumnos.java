import DAO.AlumnosCRUD;
import entidades.Alumno;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class ventanaAlumnos extends JFrame {
    private JPanel miPanel;
    private JTextField txtMatricula;
    private JLabel lblMatricula;
    private JLabel lblNombre;
    private JTextField txtNombre;
    private JLabel lblApellidoPaterno;
    private JLabel lblApellidoMaterno;
    private JLabel lblFechaNac;
    private JLabel lblSexo;
    private JTextField txtApPaterno;
    private JTextField txtApMaterno;
    private JComboBox cmbSexo;
    private JTextField txtFechaNac;
    private JButton btnBuscar;
    private JButton btnEliminar;
    private JButton btnGuardar;
    private JButton btnNuevo;

    public ventanaAlumnos() {
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //buscar alumno
                AlumnosCRUD crud = new AlumnosCRUD();
                String matricula = txtMatricula.getText();
                Alumno a = crud.buscarAlumnoPorMat(matricula);
                if(a == null){
                    //JOptionPane.showMessageDialog(miPanel,"No se encuentra el alumno con la matricula: " + matricula,"Alumnos",JOptionPane.ERROR_MESSAGE);
                    int respuesta = JOptionPane.showConfirmDialog(miPanel,"No se encuentra el alumno con la matricula: " + matricula + "\n¿Desea dar de alta?" ,"Alumno",JOptionPane.YES_NO_OPTION);
                    if(respuesta == 0){
                        //sí quiere dar de alta el alumno inexistente
                        btnNuevo.setEnabled(true);
                        txtNombre.requestFocus();

                    }else if(respuesta == 1){
                        //no quiere dar de alta
                        //limpiar formulario
                        //invocar método para limpiar


                    }
                }
                else{
                   txtNombre.setText(a.getNombre());
                   txtApPaterno.setText(a.getApPaterno());
                   txtApMaterno.setText(a.getApMaterno());
                }


            }
        });
        btnNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              //instanciar objeto de la clase Alumno
              Alumno a = new Alumno();
              a.setMatricula(txtMatricula.getText());
              a.setNombre(txtNombre.getText());
              a.setApPaterno(txtApPaterno.getText());
              a.setApMaterno(txtApMaterno.getText());

              //Date fechaNac = new Date(txtFechaNac.getText());
              a.setFechaNacimiento(new Date());

              //invocar metodo de insertarAlumno
              AlumnosCRUD crud = new AlumnosCRUD();
              crud.insertarAlumno(a);
            }
        });
    }

    public static void main(String[] args) {
        ventanaAlumnos v = new ventanaAlumnos();
        v.setContentPane(v.miPanel);
        v.setSize(500,500);
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setVisible(true);
    }
}
