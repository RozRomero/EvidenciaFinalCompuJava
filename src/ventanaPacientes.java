import DAO.PacientesCRUD;
import entidades.Paciente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class ventanaPacientes extends JFrame {
    private JPanel miPanel;
    private JTextField txtnumID;
    private JLabel lblID;
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

    public ventanaPacientes() {
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //buscar paciente
                PacientesCRUD crud = new PacientesCRUD();
                String numID = txtnumID.getText();
                Paciente a = crud.buscarPacientePorID(numID);
                if(a == null){
                    //JOptionPane.showMessageDialog(miPanel,"No se encuentra el paciente con el identificador: " + numID,"Pacientes",JOptionPane.ERROR_MESSAGE);
                    int respuesta = JOptionPane.showConfirmDialog(miPanel,"No se encuentra el paciente con el identificador: " + numID + "\n¿Desea dar de alta?" ,"Paciente",JOptionPane.YES_NO_OPTION);
                    if(respuesta == 0){
                        //sí quiere dar de alta el paciente inexistente
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
              //instanciar objeto de la clase Paciente
              Paciente a = new Paciente();
              a.setnumID(txtnumID.getText());
              a.setNombre(txtNombre.getText());
              a.setApPaterno(txtApPaterno.getText());
              a.setApMaterno(txtApMaterno.getText());

              //Date fechaNac = new Date(txtFechaNac.getText());
              a.setFechaNacimiento(new Date());

              //invocar metodo de insertarPaciente
              PacientesCRUD crud = new PacientesCRUD();
              crud.insertarPaciente(a);
            }
        });
    }

    public static void main(String[] args) {
        ventanaPacientes v = new ventanaPacientes();
        v.setContentPane(v.miPanel);
        v.setSize(500,500);
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setVisible(true);
    }
}
