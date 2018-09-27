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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JornadesEsportives {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static Map<String, Alumno> alumnos = new HashMap<>();
    public static Map<Integer, String> cursos = new HashMap<>();
    
    public static void main(String[] args) throws IOException {
        
        int decision = 1;
        cargarAlumnosaHashMap();
        cargarCursosaHashMap();
        
        mostrarAlumnosdeHM();
        mostrarCursosdeHM();
        
        do{
            showMenu(decision);
            decision = Integer.parseInt(br.readLine());
            
            switch(decision){
                case 1:
                    System.out.println("********************************************************");
                    System.out.println("1-. Inscribir alumno");
                    addAlumnoaArchivo();
                    break;
                case 2:
                    System.out.println("********************************************************");
                    System.out.println("2-. Alumnos por curso");                 
                    mostrarCursosdeHM();
                    System.out.print("Escoge un número de curso : ");
                    int nCurso = Integer.parseInt(br.readLine());
                    alumnosXCurso(nCurso);
                    
                    break;
                default:
                    break;
                 
            }
                    
        }
        while(decision > 0 && decision <= 6);
        
        System.out.println("Gracias!");
        
        
        
    }
    
    public static void showMenu(int decision){
        
        System.out.println("********************************************************");
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
    
    //Funciónq ue añade un objeto alumno con sus valores correspondientes al hashmap alumnos
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
    
    //Función que carga los alumnos del archivo alumnos.txt al hashmap alumnos
    public static void cargarAlumnosaHashMap() throws FileNotFoundException, IOException{
        
        String rutaActual = System.getProperty("user.dir");
        String separador = File.separator;
        String rutaFichero = rutaActual + separador + "alumnos.txt";
        File f = new File(rutaFichero);
        FileReader fr = new FileReader(f);
        BufferedReader brr = new BufferedReader(fr);
        if (f.exists()) {
            String linea;
            alumnos.clear();
            
            while((linea = brr.readLine()) != null){
               //System.out.println("Linea = " + linea);
               String[] datos = linea.split(",");
               Alumno aux = new Alumno(datos[0], datos[1], datos[2], datos[3], Integer.parseInt(datos[4]), datos[5]);
               alumnos.put(datos[0], aux);
            }
        }
        
    }
    
    //Función que carga los cursos que hay disponibles al hashmap cursos
    public static void cargarCursosaHashMap() throws FileNotFoundException, IOException{
        
        //Por ahora:
        //Busca el archivo de los alimnos y separa sus lineas por comas
        //buscamos si el curso de la línea actual se encuentra en el array
        //en caso de que esté repetido no lo añadimos al array
        //en caso de que no esté repetido lo añadimos al array
        //y al final mostramos los valores del array y el número que les corresponde por posición
        
        String rutaActual = System.getProperty("user.dir");
        String separador = File.separator;
        String rutaFichero = rutaActual + separador + "alumnos.txt";
        File f = new File(rutaFichero);
        FileReader fr = new FileReader(f);
        BufferedReader brr = new BufferedReader(fr);
        
        if (f.exists()) {
            //System.out.println("Fichero = " + rutaFichero);
            
            String linea;
            while((linea = brr.readLine()) != null){
                String[] datos = linea.split(",");
                String curso = datos[2];
                boolean repetido = false;
                
                for(Map.Entry<Integer, String> entry : cursos.entrySet()){
                    if(entry.getValue().equalsIgnoreCase(curso)){
                        repetido = true;
                    }
                }

                if(!repetido){
                    cursos.put(cursos.size(), curso);
                }
                
            }
            
            //System.out.println("Cursos = " + cursos);
            //System.out.println("Numero de cursos = " + cursos.size());
        }
        
    }
    
    //Función que muestra los valores de un HashMap
    public static void mostrarCursosdeHM(){
       
        for (int i = 0; i<cursos.size(); i++){
                System.out.println("Curso nº" + i + " = " + cursos.get(i));               
            }
        
    }
    
    public static void mostrarAlumnosdeHM(){
        
        for(Map.Entry<String, Alumno> entry : alumnos.entrySet()){
            System.out.println(entry.getValue().toString());
        }
        
    } 
    
    //Funcón que devuelve los datos de los alumnos por curso
    public static void alumnosXCurso(int nCurso){
        
        //Buscamos el curso por su número
        if(nCurso > cursos.size() || nCurso < 0){
            System.out.println("Número incorrecto");
        }else{
            
            String curso = cursos.get(nCurso);
            System.out.println("Curso = " + curso);
            
            for(Map.Entry<String, Alumno> entry : alumnos.entrySet()){
                if(entry.getValue().getCurso().equalsIgnoreCase(curso)){
                    System.out.println("Alumno = " + entry.getKey());
                }
            }
            
        }
        
    }
}
