/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendmail;

import javax.swing.JOptionPane;

/**
 *
 * @author ChristianArias
 */
public class Send {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        data.cargarConexion();
        //System.out.println(data.correo);
        switch(args[0]){
            case "0":
                new Configuracion.Configuraciones().setVisible(true);
                break;
            case "1":
                new Enviar.SMTP().enviar(args[1],args[2],args[3]);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error: "+args[0]);
                break;
        }
        //System.out.println(args[0]);
    }
    
}
