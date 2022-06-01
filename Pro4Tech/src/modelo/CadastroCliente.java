/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author diego
 */
public class CadastroCliente {
    private String cargo;
    private String nome;
    private String email;
    private String nome_empresa;
    private String projetos;
    private String telefone;
    private String senha;
    private String token;

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome_empresa() {
        return nome_empresa;
    }

    public void setNome_empresa(String nome_empresa) {
        this.nome_empresa = nome_empresa;
    }

    public String getProjetos() {
        return projetos;
    }

    public void setProjetos(String projetos) {
        this.projetos = projetos;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String whatsapp) {
        this.telefone = whatsapp;
    }
    
    
}
