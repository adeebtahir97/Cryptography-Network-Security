import javax.swing.*;
import java.util.Random;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.KeyGenerator;

class DESprac{
	byte[] skey = new byte[1000];
	String skeyString;
	static byte[] raw;
	String inputMessage,encryptedMessage,decryptedMessage;

	public DESprac(){
		try{
			//Encryption
			generateSymetricKey(); 
			inputMessage = JOptionPane.showInputDialog(null,"Enter Message to Encrypt:");
			byte[] ibyte = inputMessage.getBytes();
			byte[] ebyte = encrypt(raw,ibyte); 
			encryptedMessage = new String(ebyte);
			JOptionPane.showMessageDialog(null,"Encrypted Message is:" + encryptedMessage);

			//Decryption
			byte[] dbyte = decrypt(raw,ebyte); 
			decryptedMessage = new String(dbyte);
			JOptionPane.showMessageDialog(null,"Decrypted Message is:" + decryptedMessage);
		}catch(Exception e){
			System.out.println(e);
		}
	}

	void generateSymetricKey(){
		try{
			Random r = new Random();
			int num = r.nextInt(10000);
			String knum = String.valueOf(num);
			byte[] knumb = knum.getBytes();
			skey = getRawKey(knumb);
			skeyString = new String(skey);
			System.out.println("DES Symmetric Key is:" + skeyString);
		}catch(Exception e){
			System.out.println(e);
		}		
	}

	private static byte[] getRawKey(byte[] seed) throws Exception{
		KeyGenerator kgen = KeyGenerator.getInstance("DES");
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		sr.setSeed(seed);
		kgen.init(56, sr);
		SecretKey secretkey = kgen.generateKey();
		raw = secretkey.getEncoded();
		return raw;
	}

	private static byte[] encrypt(byte[] raw,byte[] clear) throws Exception{
		SecretKeySpec skeyspec = new SecretKeySpec(raw,"DES");
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.ENCRYPT_MODE,skeyspec);
		byte[] encrypted = cipher.doFinal(clear);
		return encrypted;
	}

	private static byte[] decrypt(byte[] raw,byte[] encrypted) throws Exception{
		SecretKeySpec skeyspec = new SecretKeySpec(raw,"DES");
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.DECRYPT_MODE,skeyspec);
		byte[] decrypted = cipher.doFinal(encrypted);
		return decrypted;
	}

	public static void main(String args[]){
		DESprac des = new DESprac();
	}
}