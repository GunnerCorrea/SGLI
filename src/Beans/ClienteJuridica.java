/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Malengo
 */
public class ClienteJuridica extends Cliente {
    
 
    private String cnpj;
    private String inscricao;
    private String nomeFantasia;
    
    
    public String getCnpj(){
        return cnpj;
    }
    public void setCnpj(String cnpj){
        this.cnpj= cnpj;
    }
    public String getInscricao(){
        return inscricao;
    }
    public void setInscricao(String inscricao){
        this.inscricao= inscricao;
    }
    public String getNomeFantasia(){
        return nomeFantasia;
    }
    public void setNomeFantasia(){
        this.nomeFantasia= nomeFantasia;
    }
}
