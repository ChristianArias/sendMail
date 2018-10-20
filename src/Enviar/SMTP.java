/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enviar;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ChristianArias
 */
public class SMTP {
    
    public void enviar(String destinatario,String asunto,String cuerpo){
        // Esto es lo que va delante de @gmail.com en tu cuenta de correo. Es el remitente también.
        String remitente = sendmail.data.correo;  //Para la dirección nomcuenta@gmail.com
        String clave = sendmail.data.pwd;

        Properties props = System.getProperties();
        props.put("mail.smtp.host", sendmail.data.servidor);  //El servidor SMTP de Google
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", clave);    //La clave de la cuenta
        props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
        props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
        props.put("mail.smtp.port", sendmail.data.puerto); //El puerto SMTP seguro de Google

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(remitente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));//Se podrían añadir varios de la misma manera
            message.setSubject(asunto);
            message.setText(cuerpo);
            try (Transport transport = session.getTransport("smtp")) {
                transport.connect(sendmail.data.servidor, remitente, clave);
                transport.sendMessage(message, message.getAllRecipients());
            }catch(Exception e){
                new Logs.Error().error(e.getMessage());
            }
        }catch (MessagingException e) {
            new Logs.Error().error(e.getMessage());
        }
    }
    
}
