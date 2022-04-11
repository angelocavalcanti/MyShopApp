package com.example.myshopapp.Telas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myshopapp.R;

public class TelaInformacaoProduto extends AppCompatActivity {

    ImageButton BotaoImagemVoltar;
    ImageButton BotaoImagemHome;
    ImageButton BotaoImagemVender;
    ImageButton BotaoImagemListarCategorias;
    ImageButton BotaoImagemCarrinho;
    ImageButton BotaoImagemPerfil;
    ImageButton BotaoImagemAjuda;
    Button BotaoAddProdutoNoCarrinho_TelaInformacaoProduto;
    ImageView ImagemProdutoSelecionado_TelaInformacaoProduto;
    TextView TextoLojaProdutoSelecionado_TelaInformacaoProduto;
    TextView TextoInfoProdutoSelecionado_TelaInformacaoProduto;
    TextView TextoTituloProdutoSelecionado_TelaInformacaoProduto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_informacao_produto);

        inicializarVariaveis_TelaInformacaoProduto();
        eventos();

        // Recuperando dados da ActivityMain:
        Intent intent = getIntent();
        String informacao = intent.getStringExtra("informacao");
        String loja = intent.getStringExtra("loja");
        int produto = intent.getIntExtra("foto_do_produto", 1);

        TextoInfoProdutoSelecionado_TelaInformacaoProduto.setText(informacao);
        ImagemProdutoSelecionado_TelaInformacaoProduto.setImageResource(produto);
        TextoLojaProdutoSelecionado_TelaInformacaoProduto.setText(loja);

        BotaoAddProdutoNoCarrinho_TelaInformacaoProduto.setOnClickListener(View->{ abrirTelaPagamentoProdutoComArgumentos(produto); });
    }

    public void inicializarVariaveis_TelaInformacaoProduto(){
        BotaoAddProdutoNoCarrinho_TelaInformacaoProduto = findViewById(R.id.botaoAddProdutoNoCarrinho_TelaInformacaoProduto);
        BotaoImagemAjuda = findViewById(R.id.botaoImagemAjuda_TelaFixa);
        BotaoImagemPerfil = findViewById(R.id.botaoImagemPerfil_TelaFixa);
        BotaoImagemCarrinho = findViewById(R.id.botaoImagemCarrinho_TelaFixa);
        BotaoImagemListarCategorias = findViewById(R.id.botaoImagemListarCategorias_TelaFixa);
        BotaoImagemVender = findViewById(R.id.botaoImagemVender_TelaFixa);
        BotaoImagemHome = findViewById(R.id.botaoImagemHome_TelaFixa);
        BotaoImagemVoltar = findViewById(R.id.botaoImagemVoltar_TelaFixa);
        ImagemProdutoSelecionado_TelaInformacaoProduto = findViewById(R.id.imagemProdutoSelecionado_TelaInformacaoProduto);
        TextoLojaProdutoSelecionado_TelaInformacaoProduto = findViewById(R.id.textoLojaProdutoSelecionado_TelaInformacaoProduto);
        TextoInfoProdutoSelecionado_TelaInformacaoProduto = findViewById(R.id.textoInfoProdutoSelecionado_TelaInformacaoProduto);
        TextoTituloProdutoSelecionado_TelaInformacaoProduto = findViewById(R.id.textoTituloProdutoSelecionado_TelaInformacaoProduto);
    }

    public void abrirTela(Class tela){
        Intent it_tela = new Intent(getApplicationContext(), tela);
        startActivity(it_tela);
    }

    public void abrirTelaPagamentoProdutoComArgumentos(int imagem){
        Intent fotoProduto = new Intent(this, TelaPagamentoProduto.class);
        fotoProduto.putExtra("foto_do_produto", imagem);
        startActivity(fotoProduto);
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