/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendmail;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author ChristianArias
 */
public class data {
    
    public static String correo = "",pwd = "",servidor = "",puerto = "";
    
    public static void cargarConexion(){
        try{
            String linea = "";
            File archivo = new File(_sistema.Ubicacion.path()+"data.conexion");
            if(!archivo.exists()){
                new Logs.Error().error("No tiene configuracion cargada");
                System.exit(0);
            }else{
                try(BufferedReader br = new BufferedReader(new FileReader(archivo))){
                    while((linea = br.readLine())!=null){
                        String[] array = linea.split(",");
                        correo      = new _sistema.crypt().desencriptar(array.length > 0 ? array[0] : "");
                        pwd         = new _sistema.crypt().desencriptar(array.length > 1 ? array[1] : "");
                        servidor    = array.length > 2 ? array[2] : "";
                        puerto      = array.length > 3 ? array[3] : "";
                    }
                }
            }
        }catch(IOException e){
            new Logs.Error().error(e.getMessage());
        }
    }
    
    public static void guardarConexion(String texto,File ruta){
        try{
            try(PrintWriter wr = new PrintWriter(new BufferedWriter(new FileWriter(ruta)) ,true)){ 
                wr.write(texto);
                new Logs.Error().error("Configuraciones actualizadas");
            }
        }catch(IOException e){ new Logs.Error().error(e.getMessage()); }
    }
    
}
