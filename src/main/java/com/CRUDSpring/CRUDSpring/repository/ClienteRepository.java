
package com.CRUDSpring.CRUDSpring.repository;

import com.CRUDSpring.CRUDSpring.model.ClientesModelo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class ClienteRepository implements IClienteRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<ClientesModelo> findAll() {
       String SQL="select * from clientes";
       return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(ClientesModelo.class));
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public int save(ClientesModelo CModel) {
        String SQL="insert into clientes values(?,?,?,?,?)";
        return jdbcTemplate.update(SQL, new Object[]{CModel.getId(),
        CModel.getNombres(), CModel.getApellidos(), CModel.getCiudad(),
        CModel.getTelefono()});
    }

    @Override
    public int update(ClientesModelo CModel) {
        String SQL="update clientes set nombres=?, apellidos=?, ciudad=?, telefono=? where id=?";
        return jdbcTemplate.update(SQL, new Object[]{CModel.getNombres(), CModel.getApellidos(), 
            CModel.getCiudad(), CModel.getTelefono(), CModel.getId()});
    }

   /* @Override
    public int deleteById(int varId) {
        //String SQL="update clientes where id=? ";
        String SQL = "delete from clientes where id=?";
        return jdbcTemplate.update(SQL, new Object[]{varId});
    }  */
    
    @Override
    public int deleteByInt(ClientesModelo CModel) {
        //String SQL="update clientes where id=? ";
        String SQL = "delete from clientes where id=?";
        return jdbcTemplate.update(SQL, CModel.getId());
    }  


    
}
