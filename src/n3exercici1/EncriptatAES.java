package n3exercici1;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncriptatAES {

	private SecretKeySpec crearClau(String clau) throws Exception {
		byte[] clauEncriptacio = clau.getBytes("UTF-8");
		MessageDigest sha = MessageDigest.getInstance("SHA-1");
		clauEncriptacio = sha.digest(clauEncriptacio);
		clauEncriptacio = Arrays.copyOf(clauEncriptacio, 16);
		SecretKeySpec secret = new SecretKeySpec(clauEncriptacio, "AES");
		return secret;
	}
	
	public String encriptar(String dades, String clauSecreta) throws Exception {
		SecretKeySpec secret = this.crearClau(clauSecreta);
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, secret);
		byte[] dadesEncriptar = dades.getBytes("UTF-8");
		byte[] bytesEncriptats = cipher.doFinal(dadesEncriptar);
		String encriptat = Base64.getEncoder().encodeToString(bytesEncriptats);
		return encriptat;
	}
	
	public String desencriptar(String dadesEncriptades, String clauSecreta) throws Exception {
		SecretKeySpec secret = this.crearClau(clauSecreta);
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
		cipher.init(Cipher.DECRYPT_MODE, secret);
		byte[] bytesEncriptats = Base64.getDecoder().decode(dadesEncriptades);
		byte[] dadesDesencriptades = cipher.doFinal(bytesEncriptats);
		String dades = new String(dadesDesencriptades);
		return dades;
	}
}