public class MainApp {
    public static void main(String[] args) {
        try {
            AESEncryption aes = new AESEncryption();
            String original = "Hello Uyên";
            String encrypted = aes.encrypt(original);
            String decrypted = aes.decrypt(encrypted);

            System.out.println("Original: " + original);
            System.out.println("Encrypted: " + encrypted);
            System.out.println("Decrypted: " + decrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}