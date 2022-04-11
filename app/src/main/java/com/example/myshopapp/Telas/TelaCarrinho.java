package com.example.myshopapp.Telas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myshopapp.BancodeDados.BancoSQLite;
import com.example.myshopapp.Modulos.Produto;
import com.example.myshopapp.Modulos.Usuario;
import com.example.myshopapp.R;

public class TelaCarrinho extends AppCompatActivity {

    ImageButton BotaoImagemVoltar;
    ImageButton BotaoImagemHome;
    ImageButton BotaoImagemVender;
    ImageButton BotaoImagemListarCategorias;
    ImageButton BotaoImagemCarrinho;
    ImageButton BotaoImagemPerfil;
    ImageButton BotaoImagemAjuda;
    TextView TextoTituloCarrinho_TelaCarrinho;
    ImageView ImagemProduto1_TelaCarrinho;
    TextView TextoProdutoImagem1_TelaCarrinho;
    ImageView ImagemProduto2_TelaCarrinho;
    TextView TextoProdutoImagem2_TelaCarrinho;
    ImageView ImagemProduto3_TelaCarrinho;
    TextView TextoProdutoImagem3_TelaCarrinho;
    TextView TextoInfoValorTotal_TelaCarrinho;
    Button BotaoFinalizarCompra_TelaCarrinho;
    TextView TextoValorTotal_TelaCarrinho;
    double ValorTotal = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_carrinho);

        inicializarVariaveis_TelaCarrinho();
        eventos();
        mostrarProdutosCarrinho("1");
        mostrarProdutosCarrinho("2");
        mostrarProdutosCarrinho("3");
    }

    public void inicializarVariaveis_TelaCarrinho(){
        BotaoImagemAjuda = findViewById(R.id.botaoImagemAjuda_TelaFixa);
        BotaoImagemPerfil = findViewById(R.id.botaoImagemPerfil_TelaFixa);
        BotaoImagemCarrinho = findViewById(R.id.botaoImagemCarrinho_TelaFixa);
        BotaoImagemListarCategorias = findViewById(R.id.botaoImagemListarCategorias_TelaFixa);
        BotaoImagemVender = findViewById(R.id.botaoImagemVender_TelaFixa);
        BotaoImagemHome = findViewById(R.id.botaoImagemHome_TelaFixa);
        BotaoImagemVoltar = findViewById(R.id.botaoImagemVoltar_TelaFixa);
        TextoTituloCarrinho_TelaCarrinho = findViewById(R.id.textoTituloCarrinho_TelaCarrinho);
        ImagemProduto1_TelaCarrinho = findViewById(R.id.imagemProduto1_TelaCarrinho);
        TextoProdutoImagem1_TelaCarrinho = findViewById(R.id.textoProdutoImagem1_TelaCarrinho);
        ImagemProduto2_TelaCarrinho = findViewById(R.id.imagemProduto2_TelaCarrinho);
        TextoProdutoImagem2_TelaCarrinho = findViewById(R.id.textoProdutoImagem2_TelaCarrinho);
        ImagemProduto3_TelaCarrinho = findViewById(R.id.imagemProduto3_TelaCarrinho);
        TextoProdutoImagem3_TelaCarrinho = findViewById(R.id.textoProdutoImagem3_TelaCarrinho);
        TextoInfoValorTotal_TelaCarrinho = findViewById(R.id.textoInfoValorTotal_TelaCarrinho);
        BotaoFinalizarCompra_TelaCarrinho = findViewById(R.id.botaoFinalizarCompra_TelaCarrinho);
        TextoValorTotal_TelaCarrinho = findViewById(R.id.textoValorTotal_TelaCarrinho);
    }

    public void eventos(){
        BotaoImagemVoltar.setOnClickListener(view -> { abrirTela(MainActivity.class); });
        BotaoImagemHome.setOnClickListener(view -> { abrirTela(MainActivity.class); });
        BotaoImagemVender.setOnClickListener(view -> { abrirTela(TelaCadastrarProduto.class);});
        BotaoImagemListarCategorias.setOnClickListener(view -> { abrirTela(TelaCategorias.class); });
        BotaoImagemCarrinho.setOnClickListener(view -> { abrirTela(TelaCarrinho.class); });
        BotaoImagemPerfil.setOnClickListener(view -> { abrirTela(TelaPerfil.class); });
        BotaoImagemAjuda.setOnClickListener(view -> { abrirTela(TelaAjuda.class); });
        BotaoFinalizarCompra_TelaCarrinho.setOnClickListener(view -> {
            Toast.makeText(this, "COMPRA FINALIZADA COM SUCESSO!", Toast.LENGTH_LONG).show();
            abrirTela(MainActivity.class);
        });
    }

    public void abrirTela(Class tela){
        Intent it_tela = new Intent(getApplicationContext(), tela);
        startActivity(it_tela);
    }

    public void mostrarProdutosCarrinho(String id){
        BancoSQLite db = new BancoSQLite(this);
        Produto produto = db.selecionarProdutoporID(id);
        if(id.equals("1")){
            TextoProdutoImagem1_TelaCarrinho.setText(produto.getNome() + ". " + produto.getDescricao() + ". Marca: " + produto.getMarca() + ".\nR$" + produto.getPrecoVenda());
            TextoValorTotal_TelaCarrinho.setText(produto.getPrecoVenda());
            ValorTotal = ValorTotal + Double.valueOf(TextoValorTotal_TelaCarrinho.getText().toString());
        }else if (id.equals("2")){
            TextoProdutoImagem2_TelaCarrinho.setText(produto.getNome() + ". " + produto.getDescricao() + ". Marca: " + produto.getMarca() + ".\nR$" + produto.getPrecoVenda());
            TextoValorTotal_TelaCarrinho.setText(produto.getPrecoVenda());
            ValorTotal = ValorTotal + Double.valueOf(TextoValorTotal_TelaCarrinho.getText().toString());
        }else if(id.equals("3")){
            TextoProdutoImagem3_TelaCarrinho.setText(produto.getNome() + ". " + produto.getDescricao() + ". Marca: " + produto.getMarca() + ".\nR$" + produto.getPrecoVenda());
            TextoValorTotal_TelaCarrinho.setText(produto.getPrecoVenda());
            ValorTotal = ValorTotal + Double.valueOf(TextoValorTotal_TelaCarrinho.getText().toString());
        }
        TextoValorTotal_TelaCarrinho.setText(Double.toString(ValorTotal));
    }
}