import DAO.PacientesCRUD;
import entidades.Paciente;

public class prueba {

    public static void main(String[] args) {
        PacientesCRUD crud=new PacientesCRUD();
        Paciente a = crud.buscarPacientePorID("0000");
        if(a==null){
            System.out.println("No se encuentra paciente con ese identificador");
        }else{
            System.out.println(a.getNombre() + " " + a.getApMaterno());
        }

    }
}
