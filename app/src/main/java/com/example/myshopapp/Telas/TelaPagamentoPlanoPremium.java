package com.example.myshopapp.Telas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.myshopapp.R;

public class TelaPagamentoPlanoPremium extends AppCompatActivity {

    ImageButton BotaoImagemVoltar;
    ImageButton BotaoImagemHome;
    ImageButton BotaoImagemVender;
    ImageButton BotaoImagemListarCategorias;
    ImageButton BotaoImagemCarrinho;
    ImageButton BotaoImagemPerfil;
    ImageButton BotaoImagemAjuda;
    TextView TextoPlanoPremium_TelaPagamentoPlanoPremium;
    TextView TextoFormaPagamento_TelaPagamentoPlanoPremium;
    RadioButton BotaoRadioCartao_TelaPagamentoPlanoPremium;
    RadioButton BotaoRadioBoleto_TelaPagamentoPlanoPremium;
    Button BotaoPagar_TelaPagamentoPlanoPremium;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_pagamento_plano_premium);

        inicializarVariaveis_TelaPagamentoPlanoPremium();
        eventos();
    }

    public void inicializarVariaveis_TelaPagamentoPlanoPremium(){
        BotaoImagemAjuda = findViewById(R.id.botaoImagemAjuda_TelaFixa);
        BotaoImagemPerfil = findViewById(R.id.botaoImagemPerfil_TelaFixa);
        BotaoImagemCarrinho = findViewById(R.id.botaoImagemCarrinho_TelaFixa);
        BotaoImagemListarCategorias = findViewById(R.id.botaoImagemListarCategorias_TelaFixa);
        BotaoImagemVender = findViewById(R.id.botaoImagemVender_TelaFixa);
        BotaoImagemHome = findViewById(R.id.botaoImagemHome_TelaFixa);
        BotaoImagemVoltar = findViewById(R.id.botaoImagemVoltar_TelaFixa);
        TextoPlanoPremium_TelaPagamentoPlanoPremium = findViewById(R.id.textoPlanoPremium_TelaPagamentoPlanoPremium);
        TextoFormaPagamento_TelaPagamentoPlanoPremium = findViewById(R.id.textoFormaPagamento_TelaPagamentoPlanoPremium);
        BotaoRadioCartao_TelaPagamentoPlanoPremium = findViewById(R.id.botaoRadioCartao_TelaPagamentoPlanoPremium);
        BotaoRadioBoleto_TelaPagamentoPlanoPremium = findViewById(R.id.botaoRadioBoleto_TelaPagamentoPlanoPremium);
        BotaoPagar_TelaPagamentoPlanoPremium = findViewById(R.id.botaoPagar_TelaPagamentoPlanoPremium);
    }

    public void eventos(){
        BotaoImagemVoltar.setOnClickListener(view -> { abrirTela(MainActivity.class); });
        BotaoImagemHome.setOnClickListener(view -> { abrirTela(MainActivity.class); });
        BotaoImagemVender.setOnClickListener(view -> { abrirTela(TelaCadastrarProduto.class);});
        BotaoImagemListarCategorias.setOnClickListener(view -> { abrirTela(TelaCategorias.class); });
        BotaoImagemCarrinho.setOnClickListener(view -> { abrirTela(TelaCarrinho.class); });
        BotaoImagemPerfil.setOnClickListener(view -> { abrirTela(TelaPerfil.class); });
        BotaoImagemAjuda.setOnClickListener(view -> { abrirTela(TelaAjuda.class); });
        BotaoPagar_TelaPagamentoPlanoPremium.setOnClickListener(view -> { abrirTela(TelaPagamentoPlanoPremiumFinalizado.class); });
    }

    public void abrirTela(Class tela){
        Intent it_tela = new Intent(getApplicationContext(), tela);
        startActivity(it_tela);
    }
}