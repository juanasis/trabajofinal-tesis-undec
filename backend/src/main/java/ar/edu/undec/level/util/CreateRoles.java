package ar.edu.undec.level.util;

import ar.edu.undec.level.security.entity.Rol;
import ar.edu.undec.level.security.enums.RolNombre;
import ar.edu.undec.level.security.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class CreateRoles implements CommandLineRunner {
    /**
     * MUY IMPORTANTE: ESTA CLASE SÓLO SE EJECUTARÁ UNA VEZ PARA CREAR LOS ROLES.
     * UNA VEZ CREADOS SE DEBERÁ ELIMINAR O BIEN COMENTAR EL CÓDIGO
     *
     */
    @Autowired
    RolService rolService;

    @Override
    public void run(String... args) throws Exception {
     /*   Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
        Rol rolUser = new Rol(RolNombre.ROLE_USER);
        Rol rolMozo = new Rol(RolNombre.ROLE_MOZO);
        Rol rolCajero = new Rol(RolNombre.ROLE_CAJERO);
        Rol rolCliente = new Rol(RolNombre.ROLE_CLIENTE);
        Rol rolCocinero = new Rol(RolNombre.ROLE_COCINERO);
        rolService.save(rolAdmin);
        rolService.save(rolUser);
        rolService.save(rolMozo);
        rolService.save(rolCajero);
        rolService.save(rolCliente);
        rolService.save(rolCocinero);
*/
    }
}
