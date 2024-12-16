package example.Loc5_Spring_Security.config;

import org.springframework.stereotype.Component;

@Component
public class PasswordValidator {

    public boolean validate(String username, String password) {
        // Implement your logic to verify username and password.
        // For example, compare with a stored password hash.
        return "user".equals(username) && "pass".equals(password); // Example logic
    }
}