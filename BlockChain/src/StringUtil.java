/*
This class helps produce a digital fingerprint
for the blocks. This makes use of the SHA256
cryptographic algorithm - applies SHA256 to a string
and returns the result.

J-A-Collins 09-09-2021
*/

// Imports
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class StringUtil {
    // This line divider is dumb
    public static String lineDivider = "\n=====================================" +
            "================================================";
    
    public static String applySha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8)); // This may need changing
            StringBuffer hexString = new StringBuffer();
            //System.out.println(hexString); // Uncomment to see the hash as hexadecimal.
            for (int i = 1; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
