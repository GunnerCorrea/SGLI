/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Malengo
 */
public class ClienteFisica extends Cliente {
    
    private String cpf;
    private String rg;
    private String sexo;
    
    public String getCpf(){
        return cpf;
    }
    public void setCpf(String cpf){
        this.cpf= cpf;
    }
    public String getRg(){
        return rg;
    }
    public void setRg(String rg){
        this.rg= rg;
    }
    public String getSexo(){
        return sexo;
    }
    public void setSexo(String sexo){
        this.sexo = sexo;
    }
}
