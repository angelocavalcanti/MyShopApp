package com.example.myshopapp.Modulos;

public class Produto implements Cloneable{
    private int id;
    private String codigobarras;
    private String categoria;
    private String nome;
    private String quantidade;
    private String descricao;
    private String marca;
    private String preco_custo;
    private String preco_venda;
    // A ser implementado futuramente:
    // private String imagem;

    public Produto(){}

    public Produto(String codigobarras, String categoria, String nome, String quantidade, String descricao, String marca, String preco_custo, String preco_venda){
        this.codigobarras = codigobarras;
        this.categoria = categoria;
        this.nome = nome;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.marca = marca;
        this.preco_custo = preco_custo;
        this.preco_venda = preco_venda;
        //this.imagem = imagem;
    }

    public Produto(int id, String codigobarras, String categoria, String nome, String quantidade, String descricao, String marca, String preco_custo, String preco_venda){
        this.id = id;
        this.codigobarras = codigobarras;
        this.categoria = categoria;
        this.nome = nome;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.marca = marca;
        this.preco_custo = preco_custo;
        this.preco_venda = preco_venda;
        //this.imagem = imagem;
    }

    public Produto(Produto p){
        this.id = p.id;
        this.codigobarras = p.codigobarras;
        this.categoria = p.categoria;
        this.nome = p.nome;
        this.quantidade = p.quantidade;
        this.descricao = p.descricao;
        this.marca = p.marca;
        this.preco_custo = p.preco_custo;
        this.preco_venda = p.preco_venda;
        //this.imagem = p.imagem;
    }

    public Produto(int id, String codigobarras){
        this.id = id;
        this.codigobarras = codigobarras;
    }

    public int getId(){ return this.id; }
    public void setId(int id){ this.id = id; }

    public String getCodigobarras(){ return this.codigobarras; }
    public void setCodigobarras(String codigobarras){ this.codigobarras = codigobarras; }

    public String getCategoria(){ return this.categoria; }
    public void setCategoria(String categoria){ this.categoria = categoria; }

    public String getNome(){ return this.nome; }
    public void setNome(String nome){ this.nome = nome; }

    public String getQuantidade(){ return this.quantidade; }
    public void setQuantidade(String quantidade){ this.quantidade = quantidade; }

    public String getDescricao(){ return this.descricao; }
    public void setDescricao(String descricao){ this.descricao = descricao; }

    public String getMarca(){ return this.marca; }
    public void setMarca(String marca){ this.marca = marca; }

    public String getPrecoCusto(){ return this.preco_custo; }
    public void setPrecoCusto(String preco_custo){ this.preco_custo= preco_custo; }

    public String getPrecoVenda(){ return this.preco_venda; }
    public void setPrecoVenda(String preco_venda){ this.preco_venda = preco_venda; }

    //public String getImagem(){ return this.imagem; }
    //public void setImagem(String imagem){ this.imagem = imagem; }

    @Override
    public Object clone(){
        Produto clone = new Produto(this);
        return clone;
    }
}
