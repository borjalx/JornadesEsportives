package jornadesesportives;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class JornadesEsportives {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public Map<Integer, String> alumnos = new HashMap<Integer, String>();
    
    public static void main(String[] args) throws IOException {
        
        int decision = 1;
        
        do{
            showMenu(decision);
            decision = Integer.parseInt(br.readLine());
        }
        while(decision > 0 && decision <= 6);
        
        System.out.println("Gracias!");
        
        
        
    }
    
    public static void showMenu(int decision){
        
        System.out.println("BIENVENIDO AL MENÚ DE LAS JORNADAS DEPORTIVAS DE STUCOM");
        System.out.println("1-. Inscribir alumno");
        System.out.println("2-. Alumnos por curso");
        System.out.println("3-. Deportes con incidencias");
        System.out.println("4-. Eliminar isncripciónd de un alumno");
        System.out.println("5-. Listado de inscripciones, agrupadas por deporte y ordenados por alumnos alfabéticamente");
        System.out.println("6-. Anular deporte ");
        System.out.println("Cualquier otro caracter (numero/letra) cierra app");
        System.out.println("DECISIÓN : ");
        
        
        
    }
    
    public static void addAlumnoaArchivo() throws IOException{
        
        System.out.println("Nombre alumno : ");
        String nombre = br.readLine();
        System.out.println("Apellido alumno : ");
        String apellido = br.readLine();
        
        
        String rutaActual = System.getProperty("user.dir");
        String separador = File.separator;
        String rutaFichero = rutaActual + separador + "datos.txt";
        File f = new File(rutaFichero);
        if (f.exists()) {
            System.out.println("El fichero existe.");
            System.out.println("Nombre del fichero:" + f.getName());
        }
        
    }
    
    public static void cargarAlumnosaHashMap(){
        
        String rutaActual = System.getProperty("user.dir");
        String separador = File.separator;
        String rutaFichero = rutaActual + separador + "datos.txt";
        File f = new File(rutaFichero);
        if (f.exists()) {
            System.out.println("El fichero existe.");
            System.out.println("Nombre del fichero:" + f.getName());
        }
    }
}
