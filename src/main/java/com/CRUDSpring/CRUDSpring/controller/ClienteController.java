
package com.CRUDSpring.CRUDSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.CRUDSpring.CRUDSpring.model.ClientesModelo;
import com.CRUDSpring.CRUDSpring.model.ServiceResponse;
import com.CRUDSpring.CRUDSpring.service.IClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.Controller;


//@RestController
@Controller
@RequestMapping("miapp/tester")
@CrossOrigin("*")
public class ClienteController {
    
    @Autowired
    private IClienteService iClienteService;
    
@GetMapping("/")
public String index(Model model) {
    List<ClientesModelo> clientes = iClienteService.findAll();
    model.addAttribute("clientes", clientes);
    return "index";
}

@GetMapping("/new")
public String newHTMLPage() {
    return "newhtml";
}


    
    @GetMapping("/list")
    public ResponseEntity<List<ClientesModelo>> list(){
        var resultado=iClienteService.findAll();
        return new ResponseEntity<>(resultado, HttpStatus.OK);  
    } 

    @PostMapping("/save")
    public ResponseEntity<ServiceResponse> save(@RequestBody ClientesModelo CModel){
        ServiceResponse serviceResponse = new ServiceResponse();
        int resultado = iClienteService.save(CModel);
        if (resultado == 1){
            serviceResponse.setMensaje("Registro Guardado");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
        
    }
    
   @PostMapping("/actualizar")
    public ResponseEntity<ServiceResponse> update(@RequestBody ClientesModelo CModel){
        ServiceResponse serviceResponse = new ServiceResponse();
        int resultado = iClienteService.update(CModel);
        if (resultado == 1){
            serviceResponse.setMensaje("Registro Actualizado");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);      
    }
    
   // @GetMapping("/borrar/{id}")
    @PostMapping("/borrar/{id}")
   // public ResponseEntity<ServiceResponse> update(@PathVariable int id){
      public ResponseEntity<ServiceResponse> deleteByInt(@RequestBody ClientesModelo CModel){
        ServiceResponse serviceResponse = new ServiceResponse();
        int resultado = iClienteService.deleteByInt(CModel);
        if (resultado == 1){
            serviceResponse.setMensaje("Registro Eliminado");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    } 
        
}
