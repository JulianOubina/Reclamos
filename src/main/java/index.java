import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.MultipartFile;




import java.io.File;
import java.io.InputStream;

public class index {
    public static void main(String[] args) {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        String hash1 = encoder.encode("admin");
//
//        System.out.println(hash1);
        // Obtenga el mensaje de error
        String errorMessage = "java.sql.SQLIntegrityConstraintViolationException: Duplicate entry '6' for key 'reclamos.UK_m8vq7pejtjht7n5omckmjpovo'";

      // Extraiga el valor duplicado
        String duplicateValue = errorMessage.substring(errorMessage.indexOf("'") + 1, errorMessage.indexOf("'", errorMessage.indexOf("'") + 1));

     // Extraiga el nombre de la clave única
        String constraintName = errorMessage.substring(errorMessage.indexOf("'reclamos.") + 10, errorMessage.indexOf("'", errorMessage.indexOf("'reclamos.") + 10));

      // Extraiga el nombre de la columna
        String columnName = constraintName.substring(constraintName.indexOf(".") + 1);

        // Imprima el nombre de la columna
        System.out.println(columnName);

    }
}
