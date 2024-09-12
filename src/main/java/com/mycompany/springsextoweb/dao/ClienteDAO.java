package com.mycompany.springsextoweb.dao;

import com.mycompany.springsextoweb.modelo.Cliente;
import java.util.List;

public interface ClienteDAO {
  
  public List<Cliente> getClientes ();

  public void creaCliente(Cliente elClienPost);

  public Cliente traeCliente(Long idCliente);
  
}
