package com.example.myshopapp.BancodeDados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myshopapp.Modulos.Produto;
import com.example.myshopapp.Modulos.Usuario;
import com.example.myshopapp.Modulos.Vendedor;

public class BancoSQLite extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "MyShop_BD.db";
    private static final String ID = "id";
    private static final String NOME = "nome";
    private static final String EMAIL = "email";
    private static final String DOCUMENTO = "documento";
    private static final String TELEFONE = "telefone";
    private static final String SENHA = "senha";
    private static final String CEP = "cep";
    private static final String ENDERECO = "endereco";
    private static final String BAIRRO = "bairro";
    private static final String CIDADE = "cidade";
    private static final String ESTADO = "estado";

    private static final String CODIGOBARRAS = "codigobarras";
    private static final String CATEGORIA = "categoria";
    private static final String QUANTIDADE = "quantidade";
    private static final String DESCRICAO = "descricao";
    private static final String MARCA = "marca";
    private static final String PRECO_CUSTO = "preco_custo";
    private static final String PRECO_VENDA = "preco_venda";
    // private static final String IMAGEM = "imagem";

    private static final String TABELA_USUARIOS = "usuarios";
    private static final String TABELA_PRODUTOS = "produtos";
    private static final String TABELA_VENDEDORES = "vendedores";
    private static final int VERSAO = 1;

    public BancoSQLite(Context context){ super(context, NOME_BANCO, null, VERSAO); }

// =========================================== USUARIOS =====================================================

    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_USUARIOS_TABLE = "CREATE TABLE " + TABELA_USUARIOS + " ( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NOME + " TEXT, " + EMAIL + " TEXT, " + DOCUMENTO + " TEXT, " + TELEFONE + " TEXT, " + SENHA + " TEXT, " + CEP + " TEXT, " + ENDERECO + " TEXT, " + BAIRRO + " TEXT, " + CIDADE + " TEXT, " + ESTADO + " TEXT )";
        db.execSQL(CREATE_USUARIOS_TABLE);

        String CREATE_PRODUTOS_TABLE = "CREATE TABLE " + TABELA_PRODUTOS + " ( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + CODIGOBARRAS + " TEXT, " + CATEGORIA + " TEXT, " + NOME + " TEXT, " + QUANTIDADE + " TEXT, " + DESCRICAO + " TEXT, " + MARCA + " TEXT, " + PRECO_CUSTO + " TEXT, " + PRECO_VENDA + " TEXT )";
        db.execSQL(CREATE_PRODUTOS_TABLE);

        String CREATE_VENDEDORES_TABLE = "CREATE TABLE " + TABELA_VENDEDORES + " ( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NOME + " TEXT, " + EMAIL + " TEXT, " + DOCUMENTO + " TEXT, " + TELEFONE + " TEXT, " + SENHA + " TEXT, " + CEP + " TEXT, " + ENDERECO + " TEXT, " + BAIRRO + " TEXT, " + CIDADE + " TEXT, " + ESTADO + " TEXT )";
        db.execSQL(CREATE_VENDEDORES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_USUARIOS);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_PRODUTOS);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_VENDEDORES);
        onCreate(db);
    }

    public boolean inserirUsuario(Usuario u){
        long result;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NOME, u.getNome());
        values.put(EMAIL, u.getEmail());
        values.put(DOCUMENTO, u.getDocumento());
        values.put(TELEFONE, u.getTelefone());
        values.put(SENHA, u.getSenha());
        values.put(CEP, u.getCep());
        values.put(ENDERECO, u.getEndereco());
        values.put(BAIRRO, u.getBairro());
        values.put(CIDADE, u.getCidade());
        values.put(ESTADO, u.getEstado());
        result = db.insert(TABELA_USUARIOS, null, values);
        db.close();

        if (result == -1)
            return false;
        else
            return true;
    }

    public Usuario selecionarUsuario(String email){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                TABELA_USUARIOS, new String[]{ID,EMAIL,SENHA}, EMAIL + " = ?", new String[]{ String.valueOf(email) }, null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();

            Usuario user = new Usuario(
                    Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2));

            return (Usuario) user.clone();
        }
        else
            return null;
    }

    public Usuario selecionarUsuarioporID(String id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                TABELA_USUARIOS, new String[]{ID,NOME,EMAIL,DOCUMENTO,TELEFONE,SENHA,CEP,ENDERECO,BAIRRO,CIDADE,ESTADO}, ID + " = ?", new String[]{ String.valueOf(id) }, null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();

            Usuario user = new Usuario(
                    Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getString(10));

            return (Usuario) user.clone();
        }
        else
            return null;
    }

// =========================================== VENDEDORES =====================================================

    public boolean inserirVendedor(Vendedor v){
        long result;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NOME, v.getNome());
        values.put(EMAIL, v.getEmail());
        values.put(DOCUMENTO, v.getDocumento());
        values.put(TELEFONE, v.getTelefone());
        values.put(SENHA, v.getSenha());
        values.put(CEP, v.getCep());
        values.put(ENDERECO, v.getEndereco());
        values.put(BAIRRO, v.getBairro());
        values.put(CIDADE, v.getCidade());
        values.put(ESTADO, v.getEstado());
        result = db.insert(TABELA_VENDEDORES, null, values);
        db.close();

        if (result == -1)
            return false;
        else
            return true;
    }

    public Vendedor selecionarVendedor(String email){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                TABELA_VENDEDORES, new String[]{ID,EMAIL,SENHA}, EMAIL + " = ?", new String[]{ String.valueOf(email) }, null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();

            Vendedor vendedor = new Vendedor(
                    Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2));

            return (Vendedor) vendedor.clone();
        }
        else
            return null;
    }

    public Vendedor selecionarVendedorporID(String id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                TABELA_VENDEDORES, new String[]{ID,NOME,EMAIL,DOCUMENTO,TELEFONE,SENHA,CEP,ENDERECO,BAIRRO,CIDADE,ESTADO}, ID + " = ?", new String[]{ String.valueOf(id) }, null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();

            Vendedor vendedor = new Vendedor(
                    Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getString(10));

            return (Vendedor) vendedor.clone();
        }
        else
            return null;
    }

// =========================================== PRODUTOS =====================================================

    public boolean inserirProduto(Produto p){
        long result;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CODIGOBARRAS, p.getCodigobarras());
        values.put(CATEGORIA, p.getCategoria());
        values.put(NOME, p.getNome());
        values.put(QUANTIDADE, p.getQuantidade());
        values.put(DESCRICAO, p.getDescricao());
        values.put(MARCA, p.getMarca());
        values.put(PRECO_CUSTO, p.getPrecoCusto());
        values.put(PRECO_VENDA, p.getPrecoVenda());
        //values.put(IMAGEM, p.getImagem());
        result = db.insert(TABELA_PRODUTOS, null, values);
        db.close();

        if (result == -1)
            return false;
        else
            return true;
    }

    public Produto selecionarProduto(String codigobarras){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                TABELA_PRODUTOS, new String[]{ID,CODIGOBARRAS}, CODIGOBARRAS + " = ?", new String[]{ String.valueOf(codigobarras) }, null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();

            Produto produto = new Produto(
                    Integer.parseInt(cursor.getString(0)), cursor.getString(1));

            return (Produto) produto.clone();
        }
        else
            return null;
    }

    public Produto selecionarProdutoporID(String id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                TABELA_PRODUTOS, new String[]{ID,CODIGOBARRAS,CATEGORIA,NOME,QUANTIDADE,DESCRICAO,MARCA,PRECO_CUSTO,PRECO_VENDA}, ID + " = ?", new String[]{ String.valueOf(id) }, null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();

            Produto produto = new Produto(
                    Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8));

            return (Produto) produto.clone();
        }
        else
            return null;
    }

}