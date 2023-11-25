import entidades.Paciente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class citas extends JFrame {
    private JPanel miPanel;
    private JComboBox cmbPaciente;
    private JComboBox cmbDoctor;
    private JTextArea txtObservaciones;
    private JTextField txtFecha;
    private JButton btnAgregarCita;
    private JButton button2;
    private JTextField txtPaciente;
    private JComboBox cmbDia;
    private JComboBox cmbMes;
    private JComboBox cmbAnio;
    ArrayList<Paciente> otraLista;

    public boolean validarFecha(String fecha){

        try{
            SimpleDateFormat formatoFecha =
                    new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            Date miFecha = formatoFecha.parse(fecha);
            System.out.println(miFecha);
        }catch(Exception e){
            return false;
        }
        return true;


    }
    public citas() {
        try {
            FileInputStream leer =
                    new FileInputStream("C:\\temp\\listaPaciente.txt");
            ObjectInputStream miStream2 = new ObjectInputStream(leer);
            Object o = miStream2.readObject();
            otraLista = (ArrayList<Paciente>) o;
            for(Paciente a: otraLista){
                cmbPaciente.addItem(a.getnumID());
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        cmbPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(miPanel,cmbPaciente.getSelectedItem());
                String nombreCompleto="";
                String mat = cmbPaciente.getSelectedItem().toString();
                for(Paciente a: otraLista){
                    if(a.getnumID().equals(mat)){
                       nombreCompleto =  a.getNombre() + " " + a.getApMaterno();
                         break;
                    }
                }

                txtPaciente.setText(nombreCompleto);
            }
        });
        btnAgregarCita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fecha = cmbDia.getSelectedItem().toString() + "/" + cmbMes.getSelectedItem().toString() + "/" + cmbAnio.getSelectedItem().toString();
                boolean resultado = validarFecha(fecha);
                if(resultado){
                    JOptionPane.showMessageDialog(miPanel,"todo ok");

                }else{
                    JOptionPane.showMessageDialog(miPanel,"error en la fecha");
                    txtFecha.requestFocus();
                }
            }
        });
    }
    public static void main(String[] args) {
        citas t = new citas();
        t.setContentPane(t.miPanel);
        t.setSize(500,500);
        t.setTitle("Citas");
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        t.setVisible(true);
    }
}
