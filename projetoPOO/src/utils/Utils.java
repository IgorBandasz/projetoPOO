/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author iband
 */
public class Utils {
  
  public static String calcularHash(String senha) {
    String hashSHA1 = "";
    try {
      // Crie uma instância do MessageDigest 
      //com o algoritmo SHA1
      MessageDigest sha1 = MessageDigest.getInstance("SHA1");

      // Atualize o digest com os bytes do texto
      sha1.update(senha.getBytes());

      // Calcule o hash SHA1
      byte[] digest = sha1.digest();

      // Converta o hash de bytes para uma representação hexadecimal
      StringBuilder sb = new StringBuilder();
      for (byte b : digest) {
        sb.append(String.format("%02x", b));
      }
      hashSHA1 = sb.toString();
    } catch (NoSuchAlgorithmException e) {
      System.err.println("Algoritmo SHA1 não encontrado");
    }

    return hashSHA1;
  }
}
