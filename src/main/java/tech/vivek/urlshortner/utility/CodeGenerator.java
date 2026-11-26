package tech.vivek.urlshortner.utility;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class CodeGenerator {
    public static final String CHARACTERS =
                    "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+
                    "abcdefghijklmnopqrstuvwxyz"+
                    "0123456789";
    public static final int CODE_LENGTH = 8;
    private final SecureRandom random = new SecureRandom();

    public String generateCode() {
        StringBuilder sb = new StringBuilder(CODE_LENGTH);
        for(int i = 0; i < CODE_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }
        return sb.toString();
    }
}
