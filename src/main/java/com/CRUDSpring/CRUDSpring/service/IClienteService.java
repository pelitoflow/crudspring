package com.CRUDSpring.CRUDSpring.service;

import com.CRUDSpring.CRUDSpring.model.ClientesModelo;
import java.util.List;

public interface IClienteService {
    
    public List<ClientesModelo> findAll();
    public int save(ClientesModelo CModel);
    public int update(ClientesModelo CModel);
    public int deleteByInt(ClientesModelo CModel);
    
}
