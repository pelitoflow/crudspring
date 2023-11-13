package com.CRUDSpring.CRUDSpring.service;

import com.CRUDSpring.CRUDSpring.model.ClientesModelo;
import com.CRUDSpring.CRUDSpring.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClienteService implements IClienteService{
    
    @Autowired
    private IClienteRepository iClienteRepository;

    @Override
    public List<ClientesModelo> findAll() {
        List<ClientesModelo> list;
        try{
            list=iClienteRepository.findAll();
        }catch (Exception ex){
            throw ex;
        }
        return list;   
    }

    @Override
    public int save(ClientesModelo CModel) {
        int row;
        try{
            row=iClienteRepository.save(CModel);
        }catch (Exception ex){
            throw ex;
        } 
        return row;       
    }

    @Override
    public int update(ClientesModelo CModel) {
        int row;
        try{
            row=iClienteRepository.update(CModel);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }

    @Override
    public int deleteByInt(ClientesModelo CModel) {
        int row;
        try{
            row=iClienteRepository.deleteByInt(CModel);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }
    
}
