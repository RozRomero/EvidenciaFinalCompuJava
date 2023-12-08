package entidades;

public class Usuario {
    private String nombreUsuario;
    private String password;
    private boolean esAdmin;

    public Usuario() {
        // Constructor vacío
    }

    public Usuario(String nombreUsuario, String password, boolean esAdmin) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.esAdmin = esAdmin;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public boolean esAdmin() {
        return esAdmin;
    }

    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombreUsuario='" + nombreUsuario + '\'' +
                ", password='" + password + '\'' +
                ", esAdmin=" + esAdmin +
                '}';
    }

    public void mostrarDetalles() {
        // Muestra los detalles del usuario en la consola
        System.out.println("Detalles del usuario:");
        System.out.println("Nombre de usuario: " + nombreUsuario);
        System.out.println("password: " + password);
        System.out.println("Es administrador: " + esAdmin);
    }
}
