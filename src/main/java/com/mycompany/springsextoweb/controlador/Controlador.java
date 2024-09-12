package com.mycompany.springsextoweb.controlador;

import com.mycompany.springsextoweb.dao.ClienteDAO;
import com.mycompany.springsextoweb.modelo.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cliente")
public class Controlador {
  
  @Autowired
  private ClienteDAO clienteDAO;
  
  @RequestMapping ("/lista")
  public String listaCliente (Model miModelo) {
    //Obtener los clientes del DAO
    List<Cliente> listaCli = clienteDAO.getClientes();
    
    //Agreagar los clientes al Modelo
    miModelo.addAttribute("modCliente", listaCli);
    
    return "lista-clientes";
  }
  
  @RequestMapping ("/formAdiCli")
  public String formAdiCli (Model miModelo) {
    //Bind de datos de los Clientes
    Cliente elCliente= new Cliente();
    miModelo.addAttribute("modCliente", elCliente);
    
    return "formNewCliente";
  }
  
  @PostMapping ("/creaCliente")
  public String creaMiCliente (@ModelAttribute ("modCliente") Cliente elClienPost ) {
    
    // insertar el cliente elClienPost
    clienteDAO.creaCliente (elClienPost);
    
    return "redirect:/cliente/lista";
  }
  
  @GetMapping ("/formModifCliente")
  public String formModifCliente (@RequestParam("clienteId") Long idCliente, 
          Model miModelo ) {
    //Obtener el cliente con id idCliente
    Cliente cliUno = clienteDAO.traeCliente (idCliente);
    
    //establecer el cliente como atributo del modelo
    miModelo.addAttribute("modCliente", cliUno);
    
    //ir al formulario
    return "formNewCliente";
  }
  
}
