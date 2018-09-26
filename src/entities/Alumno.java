package entities;

public class Alumno {
    
    public String nombre;
    public String apellido;
    public String curso;
    public String sexo;
    public int edad;
    public String deporte;

    public Alumno(){
    }
    
    public Alumno(String nombre, String apellido, String curso, String sexo, int edad, String deporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
        this.sexo = sexo;
        this.edad = edad;
        this.deporte = deporte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }
    
    
    
}
