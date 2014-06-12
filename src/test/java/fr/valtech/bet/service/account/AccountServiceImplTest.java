package fr.valtech.bet.service.account;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;

public class AccountServiceImplTest {

    @Test
    @Ignore
    public void encodePassword() {
        String mdp = "lbarbiot";
        MessageDigestPasswordEncoder encoder = new MessageDigestPasswordEncoder("SHA-1");
        String password = encoder.encodePassword(mdp, "ZLaTaNSalt");
        System.out.println("password = " + password);
    }
}