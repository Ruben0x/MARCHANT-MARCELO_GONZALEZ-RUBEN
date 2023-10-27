package com.backend.parcial.dao.impl;

import com.backend.parcial.dao.IDao;
import com.backend.parcial.model.Odontologo;
import org.apache.log4j.Logger;

import java.util.List;


public class OdontologoDaoEnMemoria implements IDao<Odontologo> {

    private final Logger LOGGER = Logger.getLogger(OdontologoDaoEnMemoria.class);
    private List<Odontologo> odontologosList;

    public OdontologoDaoEnMemoria(List<Odontologo> odontologosList){
        this.odontologosList = odontologosList;
    }


    @Override
    public Odontologo guardar(Odontologo odontologo) {
        int id = odontologosList.size() + 1;
        odontologosList.add(odontologo);
        Odontologo odontologo1 = new Odontologo(id,  odontologo.getNumeroMatricula(), odontologo.getNombre(),odontologo.getApellido());
        LOGGER.info("Odontolgo guardado: " + odontologo1);
        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
        return odontologosList;
    }
}
