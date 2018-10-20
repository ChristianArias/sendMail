/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _sistema;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;

/**
 *
 * @author ChristianArias
 */
public class crypt {
    
    public String encriptar(String s){
        return Base64.encodeBase64String(StringUtils.getBytesUtf8(s));
    }
    
    public String desencriptar(String s){
        return StringUtils.newStringUtf8(Base64.decodeBase64(s));
    }
    
}
