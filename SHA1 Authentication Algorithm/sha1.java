import java.security.*;
import javax.swing.*;
public class sha1 {
	public static void main(String[] a) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA1");
			System.out.println("Message digest object info: ");
			System.out.println(" Algorithm = " +md.getAlgorithm());
			System.out.println(" Provider = " +md.getProvider());
			System.out.println(" ToString = " +md.toString());
			String input = JOptionPane.showInputDialog(null,"Enter The String ->");
			md.update(input.getBytes());
			byte[] output = md.digest();
			System.out.println("SHA1 For (\"" +input+"\") -> "+bytesToHex(output));
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	public static String bytesToHex(byte[] buffer)
	{
		char hexDigit[] = {'0', '1', '2', '3', '4', '5', '6','7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		StringBuffer sbuf = new StringBuffer();
		for (int j=0; j<buffer.length; j++) {
			sbuf.append(hexDigit[(b[j] >> 4) & 0x0f]);
			sbuf.append(hexDigit[b[j] & 0x0f]);
		}
		return sbuf.toString();	
	}
}