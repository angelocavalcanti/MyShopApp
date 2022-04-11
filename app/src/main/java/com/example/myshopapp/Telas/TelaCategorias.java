package com.example.myshopapp.Telas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.myshopapp.R;

public class TelaCategorias extends AppCompatActivity {

    ImageButton BotaoImagemVoltar;
    ImageButton BotaoImagemHome;
    ImageButton BotaoImagemVender;
    ImageButton BotaoImagemListarCategorias;
    ImageButton BotaoImagemCarrinho;
    ImageButton BotaoImagemPerfil;
    ImageButton BotaoImagemAjuda;
    TextView TextoCategorias_TelaCategorias;
    Button BotaoCategoriaBicicleta_TelaCategorias;
    Button BotaoCategoriaCelular_TelaCategorias;
    Button BotaoCategoriaFone_TelaCategorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_categorias);

        inicializarVariaveis_TelaCategorias();
        eventos();
    }

    public void inicializarVariaveis_TelaCategorias(){
        BotaoImagemAjuda = findViewById(R.id.botaoImagemAjuda_TelaFixa);
        BotaoImagemPerfil = findViewById(R.id.botaoImagemPerfil_TelaFixa);
        BotaoImagemCarrinho = findViewById(R.id.botaoImagemCarrinho_TelaFixa);
        BotaoImagemListarCategorias = findViewById(R.id.botaoImagemListarCategorias_TelaFixa);
        BotaoImagemVender = findViewById(R.id.botaoImagemVender_TelaFixa);
        BotaoImagemHome = findViewById(R.id.botaoImagemHome_TelaFixa);
        BotaoImagemVoltar = findViewById(R.id.botaoImagemVoltar_TelaFixa);
        TextoCategorias_TelaCategorias = findViewById(R.id.textoCategorias_TelaCategorias);
        BotaoCategoriaCelular_TelaCategorias = findViewById(R.id.botaoCategoriaCelular_TelaCategorias);
        BotaoCategoriaFone_TelaCategorias = findViewById(R.id.botaoCategoriaFone_TelaCategorias);
        BotaoCategoriaBicicleta_TelaCategorias = findViewById(R.id.botaoCategoriaBicicleta_TelaCategorias);
    }

    public void eventos(){
        BotaoImagemVoltar.setOnClickListener(view -> { abrirTela(MainActivity.class); });
        BotaoImagemHome.setOnClickListener(view -> { abrirTela(MainActivity.class); });
        BotaoImagemVender.setOnClickListener(view -> { abrirTela(TelaCadastrarProduto.class);});
        BotaoImagemListarCategorias.setOnClickListener(view -> { abrirTela(TelaCategorias.class); });
        BotaoImagemCarrinho.setOnClickListener(view -> { abrirTela(TelaCarrinho.class); });
        BotaoImagemPerfil.setOnClickListener(view -> { abrirTela(TelaPerfil.class); });
        BotaoImagemAjuda.setOnClickListener(view -> { abrirTela(TelaAjuda.class); });
        BotaoCategoriaBicicleta_TelaCategorias.setOnClickListener(view -> {
            abrirTelaInformacaoProdutoComArgumento("Bicicleta"); });
        BotaoCategoriaCelular_TelaCategorias.setOnClickListener(view ->
            {abrirTelaInformacaoProdutoComArgumento("Celular"); });
        BotaoCategoriaFone_TelaCategorias.setOnClickListener(view ->
            { abrirTelaInformacaoProdutoComArgumento("Fone"); });
    }

    public void abrirTela(Class tela){
        Intent it_tela = new Intent(getApplicationContext(), tela);
        startActivity(it_tela);
    }

    public void abrirTelaInformacaoProdutoComArgumento(String categoria){
        Intent it = new Intent(this, TelaListarProdutos.class);
        it.putExtra("categoria", categoria);
        startActivity(it);
    }
}