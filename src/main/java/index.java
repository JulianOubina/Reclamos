import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class index {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hash1 = encoder.encode("admin");

        System.out.println(hash1);

    }
}
