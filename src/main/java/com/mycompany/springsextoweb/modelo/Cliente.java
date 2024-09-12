package com.mycompany.springsextoweb.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CLIENTE")
public class Cliente {
  
  @Id
  @GeneratedValue (strategy=GenerationType.IDENTITY)
  @Column (name="CLI_ID")
  private Long cliId;
  @Column (name="CLI_NOMBRE")
  private String cliNombre;
  @Column (name="CLI_PATERNO")
  private String cliPaterno;
  @Column (name="CLI_EMAIL")
  private String cliEmail;

  public Cliente() {
  }

  public Cliente(Long cliId, String cliNombre, String cliPaterno, String cliEmail) {
    this.cliId = cliId;
    this.cliNombre = cliNombre.toUpperCase();
    this.cliPaterno = cliPaterno.toUpperCase();
    this.cliEmail = cliEmail.toUpperCase();
  }

  public Long getCliId() {
    return cliId;
  }

  public void setCliId(Long cliId) {
    this.cliId = cliId;
  }

  public String getCliNombre() {
    return cliNombre;
  }

  public void setCliNombre(String cliNombre) {
    this.cliNombre = cliNombre.toUpperCase();
  }

  public String getCliPaterno() {
    return cliPaterno;
  }

  public void setCliPaterno(String cliPaterno) {
    this.cliPaterno = cliPaterno.toUpperCase();
  }

  public String getCliEmail() {
    return cliEmail;
  }

  public void setCliEmail(String cliEmail) {
    this.cliEmail = cliEmail.toUpperCase();
  }

  @Override
  public String toString() {
    return "Cliente{" + "cliId=" + cliId + ", cliNombre=" + cliNombre + ", cliPaterno=" + 
            cliPaterno + ", cliEmail=" + cliEmail + '}';
  }
  
  
}
