import DAO.AlumnosCRUD;
import entidades.Alumno;

public class prueba {

    public static void main(String[] args) {
        AlumnosCRUD crud=new AlumnosCRUD();
        Alumno a = crud.buscarAlumnoPorMat("0000");
        if(a==null){
            System.out.println("No se encuentra alumno con esa matricula");
        }else{
            System.out.println(a.getNombre() + " " + a.getApMaterno());
        }

    }
}
