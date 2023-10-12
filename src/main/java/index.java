import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class index {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hash1 = encoder.encode("password");
        String hash = encoder.encode(hash1);

        boolean matches = encoder.matches(hash1, hash);
        System.out.println(matches); // true

    }
}
