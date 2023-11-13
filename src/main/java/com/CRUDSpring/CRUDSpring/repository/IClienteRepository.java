
package com.CRUDSpring.CRUDSpring.repository;

import com.CRUDSpring.CRUDSpring.model.ClientesModelo;
import java.util.List;


public interface IClienteRepository {
    
    public List<ClientesModelo> findAll();    
    public int save(ClientesModelo CModel);
    public int update(ClientesModelo CModel);
    public int deleteByInt(ClientesModelo CModel);    
}
