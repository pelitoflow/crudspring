package com.CRUDSpring.CRUDSpring.model;

import java.math.BigInteger;
import lombok.Data;

@Data
public class ClientesModelo { 
    
    int id;
    String nombres;
    String apellidos;
    String ciudad;
    BigInteger telefono;

    
}

