package com.example.myshopapp.Telas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.myshopapp.R;

public class TelaPagamentoProduto extends AppCompatActivity {

    ImageButton BotaoImagemVoltar;
    ImageButton BotaoImagemHome;
    ImageButton BotaoImagemVender;
    ImageButton BotaoImagemListarCategorias;
    ImageButton BotaoImagemCarrinho;
    ImageButton BotaoImagemPerfil;
    ImageButton BotaoImagemAjuda;
    ImageView ImagemProduto_TelaPagamentoProduto;
    TextView TextoFormaPagamento_TelaPagamentoProduto;
    RadioButton RadioButtonCartao_TelaPagamentoProduto;
    RadioButton RadioButtonBoleto_TelaPagamentoProduto;
    TextView TextoEnderecoEntrega_TelaPagamentoProduto;
    RadioButton RadioButtonEnderecoPrincipal_TelaPagamentoProduto;
    RadioButton RadioButtonEnderecoNovo_TelaPagamentoProduto;
    Button BotaoPagar_TelaPagamentoProduto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_pagamento_produto);

        inicializarVariaveis_TelaPagamentoProduto();
        eventos();

        // Recuperando foto do produto da TelaInformacaoProduto:
        Intent intent = getIntent();
        int produto = intent.getIntExtra("foto_do_produto", 1);

        // Setando a foto do produto no imageview da TelaPagamentoProduto:
        ImagemProduto_TelaPagamentoProduto.setImageResource(produto);

        BotaoPagar_TelaPagamentoProduto.setOnClickListener(View->{ abrirTelaPedidoFinalizadoComArgumentos(produto); });
    }

    public void inicializarVariaveis_TelaPagamentoProduto() {
        ImagemProduto_TelaPagamentoProduto = findViewById(R.id.imagemProduto_TelaPagamentoProduto);
        TextoFormaPagamento_TelaPagamentoProduto = findViewById(R.id.textoFormaPagamento_TelaPagamentoProduto);
        RadioButtonCartao_TelaPagamentoProduto = findViewById(R.id.botaoRadioCartao_TelaPagamentoProduto);
        RadioButtonBoleto_TelaPagamentoProduto = findViewById(R.id.botaoRadioBoleto_TelaPagamentoProduto);
        TextoEnderecoEntrega_TelaPagamentoProduto = findViewById(R.id.textoEnderecoEntrega_TelaPagamentoProduto);
        RadioButtonEnderecoPrincipal_TelaPagamentoProduto = findViewById(R.id.botaoRadioEnderecoPrincipal_TelaPagamentoProduto);
        RadioButtonEnderecoNovo_TelaPagamentoProduto = findViewById(R.id.botaoRadioEnderecoNovo_TelaPagamentoProduto);
        BotaoImagemVoltar = findViewById(R.id.botaoImagemVoltar_TelaFixa);
        BotaoImagemHome = findViewById(R.id.botaoImagemHome_TelaFixa);
        BotaoImagemVender = findViewById(R.id.botaoImagemVender_TelaFixa);
        BotaoImagemListarCategorias = findViewById(R.id.botaoImagemListarCategorias_TelaFixa);
        BotaoImagemCarrinho = findViewById(R.id.botaoImagemCarrinho_TelaFixa);
        BotaoImagemPerfil = findViewById(R.id.botaoImagemPerfil_TelaFixa);
        BotaoImagemAjuda = findViewById(R.id.botaoImagemAjuda_TelaFixa);
        BotaoPagar_TelaPagamentoProduto = findViewById(R.id.botaoPagar_TelaPagamentoProduto);
    }

    public void abrirTela(Class tela){
        Intent it_tela = new Intent(getApplicationContext(), tela);
        startActivity(it_tela);
    }

    public void abrirTelaPedidoFinalizadoComArgumentos(int imagem){
        Intent pedidofinalizado = new Intent(this, TelaPedidoFinalizado.class);
        pedidofinalizado.putExtra("foto_do_produto", imagem);
        startActivity(pedidofinalizado);
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
}