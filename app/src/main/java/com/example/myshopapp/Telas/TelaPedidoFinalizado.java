package com.example.myshopapp.Telas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myshopapp.R;

public class TelaPedidoFinalizado extends AppCompatActivity {

    ImageButton BotaoImagemVoltar;
    ImageButton BotaoImagemHome;
    ImageButton BotaoImagemVender;
    ImageButton BotaoImagemListarCategorias;
    ImageButton BotaoImagemCarrinho;
    ImageButton BotaoImagemPerfil;
    ImageButton BotaoImagemAjuda;
    TextView TextoInfsPedidoFinalizado_TelaPedidoFinalizado;
    ImageView ImagemProduto_TelaPedidoFinalizado;
    TextView TextoResumoPedidoFinalizado_TelaPedidoFinalizado;
    TextView TextoPedidoFinalizado_TelaPedidoFinalizado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_pedido_finalizado);

        inicializarVariaveis_TelaPedidoFinalizado();
        eventos();

        // Recuperando foto do produto da TelaPagamentoProduto:
        Intent intent = getIntent();
        int produto = intent.getIntExtra("foto_do_produto", 1);

        // Setando a foto do produto no imageview da TelaPedidoFinalizado:
        ImagemProduto_TelaPedidoFinalizado.setImageResource(produto);
    }

    public void inicializarVariaveis_TelaPedidoFinalizado(){
        BotaoImagemAjuda = findViewById(R.id.botaoImagemAjuda_TelaFixa);
        BotaoImagemPerfil = findViewById(R.id.botaoImagemPerfil_TelaFixa);
        BotaoImagemCarrinho = findViewById(R.id.botaoImagemCarrinho_TelaFixa);
        BotaoImagemListarCategorias = findViewById(R.id.botaoImagemListarCategorias_TelaFixa);
        BotaoImagemVender = findViewById(R.id.botaoImagemVender_TelaFixa);
        BotaoImagemHome = findViewById(R.id.botaoImagemHome_TelaFixa);
        BotaoImagemVoltar = findViewById(R.id.botaoImagemVoltar_TelaFixa);
        TextoInfsPedidoFinalizado_TelaPedidoFinalizado = findViewById(R.id.textoInfsPedidoFinalizado_TelaPedidoFinalizado);
        ImagemProduto_TelaPedidoFinalizado = findViewById(R.id.imagemProduto_TelaPedidoFinalizado);
        TextoResumoPedidoFinalizado_TelaPedidoFinalizado = findViewById(R.id.textoResumoPedidoFinalizado_TelaPedidoFinalizado);
        TextoPedidoFinalizado_TelaPedidoFinalizado = findViewById(R.id.textoPedidoFinalizado_TelaPedidoFinalizado);
    }

    public void eventos(){
        BotaoImagemVoltar.setOnClickListener(view -> { abrirTela(MainActivity.class); });
        BotaoImagemHome.setOnClickListener(view -> { abrirTela(MainActivity.class); });
        BotaoImagemVender.setOnClickListener(view -> { abrirTela(TelaCadastrarProduto.class);});
        BotaoImagemListarCategorias.setOnClickListener(view -> { abrirTela(TelaCategorias.class); });
        BotaoImagemCarrinho.setOnClickListener(view -> { abrirTela(TelaCarrinho.class); });
        BotaoImagemPerfil.setOnClickListener(view -> { abrirTela(TelaPerfil.class); });
        BotaoImagemAjuda.setOnClickListener(view -> { abrirTela(TelaAjuda.class); });
    }

    public void abrirTela(Class tela){
        Intent it_tela = new Intent(getApplicationContext(), tela);
        startActivity(it_tela);
    }
}