package jornadesesportives;

import entities.Alumno;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class JornadesEsportives {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public Map<String, Alumno> alumnos = new HashMap<String, Alumno>();
    
    public static void main(String[] args) throws IOException {
        
        int decision = 1;
        
        do{
            showMenu(decision);
            decision = Integer.parseInt(br.readLine());
            
            switch(decision){
                case 1:
                    System.out.println("1-. Inscribir alumno");
                    addAlumnoaArchivo();
                    break;
                case 2:
                    System.out.println("2-. Alumnos por curso");
                    cargarAlumnosaHashMap();
                    break;
                default:
                    break;
                 
            }
                    
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
        System.out.println("Curso alumno : ");
        String curso = br.readLine();
        System.out.println("Edad alumno : ");
        int edad = Integer.parseInt(br.readLine());
        System.out.println("Sexo alumno : ");
        String sexo = br.readLine();
        System.out.println("Deporte alumno : ");
        String deporte = br.readLine();
        
        Alumno alu = new Alumno(nombre, apellido, curso, sexo, edad, deporte);

        String rutaActual = System.getProperty("user.dir");
        String separador = File.separator;
        String rutaFichero = rutaActual + separador + "alumnos.txt";
        File f = new File(rutaFichero);
        FileWriter fw = new FileWriter(f, true);
        BufferedWriter bw = new BufferedWriter(fw);
        
        bw.append(nombre + "," + apellido + "," + curso + "," + sexo + "," + edad + "," + deporte);
        
        bw.newLine();
        bw.close();
        
    }
    
    public static void cargarAlumnosaHashMap() throws FileNotFoundException, IOException{
        
        String rutaActual = System.getProperty("user.dir");
        String separador = File.separator;
        String rutaFichero = rutaActual + separador + "datos.txt";
        File f = new File(rutaFichero);
        FileReader fr = new FileReader(f);
        BufferedReader brr = new BufferedReader(fr);
        if (f.exists()) {
            System.out.println("El fichero existe.");
            System.out.println("Nombre del fichero:" + f.getName());
            
            String linea;
            while((linea = brr.readLine()) != null){
                System.out.println("Linea = " + linea);
            }
        }
        
    }
}
