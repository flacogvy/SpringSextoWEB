package com.mycompany.springsextoweb.dao;

import com.mycompany.springsextoweb.modelo.Cliente;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ClienteDAOObj implements ClienteDAO {
  
  @Autowired
  private SessionFactory sessionFactory;

  @Override
  @Transactional
  public List<Cliente> getClientes() {
    //Obtener session
    Session miSesion = sessionFactory.getCurrentSession();
    
    //Crear consulta
    Query<Cliente> miQuery = miSesion.createQuery("from Cliente", Cliente.class);
    
    //Ejecutar la Query
    List<Cliente> miLista = miQuery.getResultList();
    
    return miLista;
  }

  @Override
  @Transactional
  public void creaCliente(Cliente elClienPost) {
    
    //Obtener session
    Session miSesion = sessionFactory.getCurrentSession();
    
    //Insertar el Cliente
    
    System.out.println("que esta pasando al CREAR:" + elClienPost.getCliId());
    if (elClienPost.getCliId() == null)  {
      miSesion.persist(elClienPost);
    } else {
      miSesion.merge(elClienPost);
    }
    
    //miSesion.persist(elClienPost);
    //miSesion.saveOrUpdate(this);
  }

  @Override
  @Transactional
  public Cliente traeCliente(Long idCliente) {
    //Obtener session
    Session miSesion = sessionFactory.getCurrentSession();
    
    Cliente recCliente = miSesion.get(Cliente.class, idCliente);
    
    return recCliente; 
    
  }

  @Override
  @Transactional
  public void eliminarCliente(Long idCliente) {
    //Obtener session
    Session miSesion = sessionFactory.getCurrentSession();
    
    //borrar el Cliente
    /*
    en el Query se debe colocar la ruta completa y el nombre de la clase talcual:
    en este caso "com.mycompany.springsextoweb.modelo.Cliente" y en where debe ir 
    el nombre del campo en la clase, no el nombre de la columna en la tabla:
    aqui "cliId" es el nombre del campo que mapea a la clumna que es "CLI_ID"
    */
    
    Query qryBorra = miSesion.createQuery("delete from com.mycompany.springsextoweb.modelo.Cliente where cliId=:idDelCliente");
    qryBorra.setParameter("idDelCliente", idCliente);
    
    qryBorra.executeUpdate();
    
  }
  
  
}
