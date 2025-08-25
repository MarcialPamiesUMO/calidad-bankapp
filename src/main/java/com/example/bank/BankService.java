package com.example.bank;

import java.util.logging.Logger;

public class BankService {

    private static final Logger LOG = Logger.getLogger(BankService.class.getName());
    private final UserRepository repo;

    public BankService(UserRepository repo) {
        this.repo = repo;
    }

    public void findAndGreet(String username) {
        try {
            // Regla java:S106 (usar logger en vez de System.out) — aquí ya usamos logger
            LOG.info(() -> "Buscando usuario: " + username);

            String sanitized = Utils.sanitize(username); // nuestro “sanitizer” casero
            String fullName = repo.findFullNameByUsername(sanitized);

            if (fullName != null) {
                LOG.info(() -> "Hola, " + fullName + "!");
            } else {
                LOG.info("Usuario no encontrado.");
            }
        } catch (Exception e) {
            // Regla java:S1166 (intencionalmente vacía para que Sonar la detecte)
        }
    }
}
