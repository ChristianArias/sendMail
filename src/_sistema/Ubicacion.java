/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _sistema;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author ChristianArias
 */
public class Ubicacion {
    
    public static String os = "",s = "";
    
    public static String path(){
        String ubicacion = "";
        os = System.getProperty("os.name");
        try{
            if(os.contains("Windows")){     s = "\\";   ubicacion = new File(".").getCanonicalPath()+s;}
            else if(os.contains("Linux")){  s = "/";    ubicacion = new File(".").getCanonicalPath()+s;}
        }catch(IOException e){
            
        }
        return ubicacion;
    }
    
}
