package com.example.myshopapp.Modulos;

public class Usuario implements Cloneable{
    private int id;
    private String nome;
    private String email;
    private String documento;
    private String telefone;
    private String senha;
    private String cep;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;

    public Usuario(){}

    public Usuario(String nome, String email, String documento, String telefone, String senha, String cep, String endereco, String bairro, String cidade, String estado){
        this.nome = nome;
        this.email = email;
        this.documento = documento;
        this.telefone = telefone;
        this.senha = senha;
        this.cep = cep;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Usuario(String nome, String email, String documento, String telefone) {
        this.nome = nome;
        this.email = email;
        this.documento = documento;
        this.telefone = telefone;
    }

    public Usuario(int id, String nome, String email, String documento, String telefone, String senha, String cep, String endereco, String bairro, String cidade, String estado){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.documento = documento;
        this.telefone = telefone;
        this.senha = senha;
        this.cep = cep;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Usuario(int id, String email, String senha){
        this.id = id;
        this.nome = email;
        this.senha = senha;
    }

    public Usuario(Usuario u){
        this.id = u.id;
        this.nome = u.nome;
        this.documento = u.documento;
        this.senha = u.senha;
        this.email = u.email;
        this.endereco = u.endereco;
        this.cep = u.cep;
        this.bairro = u.bairro;
        this.cidade = u.cidade;
        this.estado = u.estado;
        this.telefone = u.telefone;
    }

    public int getId(){ return this.id; }
    public void setId(int id){ this.id = id; }

    public String getNome(){ return this.nome; }
    public void setNome(String l){ this.nome = l; }

    public String getEmail(){ return this.email; }
    public void setEmail(String e){ this.email = e; }

    public String getDocumento() { return this.documento; }
    public void setDocumento(String doc) { this.documento = doc; }

    public String getTelefone(){ return this.telefone; }
    public void setTelefone(String tel){ this.telefone = tel; }

    public String getSenha(){ return this.senha; }
    public void setSenha(String s){ this.senha = s; }

    public String getCep() { return this.cep; }
    public void setCep(String cep) { this.cep = cep; }

    public String getEndereco(){ return this.endereco; }
    public void setEndereco(String end){ this.endereco= end; }

    public String getBairro(){ return this.bairro; }
    public void setBairro(String b){ this.bairro = b; }

    public String getCidade(){ return this.cidade; }
    public void setCidade(String city){ this.cidade = city; }

    public String getEstado(){ return this.estado; }
    public void setEstado(String uf){ this.estado = uf; }

    @Override
    public Object clone(){
        Usuario clone = new Usuario(this);
        return clone;
    }
}