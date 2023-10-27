package com.backend.parcial.test;

import com.backend.parcial.dao.impl.OdontologoDaoH2;
import com.backend.parcial.service.OdontologoService;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;

import static org.junit.Assert.assertFalse;

public class OdontologoServiceTest {

    private OdontologoService  odontologoService = new OdontologoService(new OdontologoDaoH2());

    @BeforeAll
    static void doBefore() {
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/parcial;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Test
    public void deberiaRetornarUnaListaNoVacia(){
        assertFalse(odontologoService.listarOdontologos().isEmpty());
    }
}