package org.example;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
public class Encryptor {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode("admin123");
        System.out.println(encodedPassword);
    }
}



