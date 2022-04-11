package com.example.myshopapp.Telas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.myshopapp.R;

public class MainActivity extends AppCompatActivity {

    Button BotaoSair_TelaPrincipal;
    ImageButton BotaoImagemHome_TelaPrincipal;
    ImageButton BotaoImagemVender_TelaPrincipal;
    ImageButton BotaoImagemCategorias_TelaPrincipal;
    ImageButton BotaoImagemCarrinho_TelaPrincipal;
    ImageButton BotaoImagemPerfil_TelaPrincipal;
    ImageButton BotaoImagemAjuda_TelaPrincipal;
    ImageButton BotaoImagemSetaEsquerda_TelaPrincipal;
    ImageButton BotaoImagemSetaDireita_TelaPrincipal;
    ImageButton BotaoImagemProdutoLinha0Coluna0_TelaPrincipal;
    ImageButton BotaoImagemProdutoLinha0Coluna1_TelaPrincipal;
    ImageButton BotaoImagemProdutoLinha1Coluna0_TelaPrincipal;
    ImageButton BotaoImagemProdutoLinha1Coluna1_TelaPrincipal;
    ImageView ImagemVisualizacaoPrincipal_TelaPrincipal;
    TextView TextoProdutoLinha0Coluna0_TelaPrincipal;
    TextView TextoProdutoLinha0Coluna1_TelaPrincipal;
    TextView TextoProdutoLinha1Coluna0_TelaPrincipal;
    TextView TextoProdutoLinha1Coluna1_TelaPrincipal;
    ImageView ImagemLogo_TelaPrincipal;
    SearchView CampoDePesquisa_TelaPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarVariaveis_MainActivity();
        evento();
    }

    public void trocaImagem(String x){
        if(x == "Bicicleta1"){
            ImagemVisualizacaoPrincipal_TelaPrincipal.setImageResource(R.drawable.bicicleta1);
        }else if(x == "Bicicleta2"){
            ImagemVisualizacaoPrincipal_TelaPrincipal.setImageResource(R.drawable.bicicleta2);
        }else{
            ImagemVisualizacaoPrincipal_TelaPrincipal.setImageResource(R.drawable.celulares1);
        }
    }

    public void inicializarVariaveis_MainActivity(){
        BotaoSair_TelaPrincipal = findViewById(R.id.botaoSair_TelaPrincipal);
        BotaoImagemHome_TelaPrincipal = findViewById(R.id.botaoImagemHome_TelaPrincipal);
        BotaoImagemVender_TelaPrincipal = findViewById(R.id.botaoImagemVender_TelaPrincipal);
        BotaoImagemCategorias_TelaPrincipal = findViewById(R.id.botaoImagemCategorias_TelaPrincipal);
        BotaoImagemCarrinho_TelaPrincipal = findViewById(R.id.botaoImagemCarrinho_TelaPrincipal);
        BotaoImagemPerfil_TelaPrincipal = findViewById(R.id.botaoImagemPerfil_TelaPrincipal);
        BotaoImagemAjuda_TelaPrincipal = findViewById(R.id.botaoImagemAjuda_TelaPrincipal);
        ImagemVisualizacaoPrincipal_TelaPrincipal = findViewById(R.id.imagemVisualizacaoPrincipal_TelaPrincipal);
        BotaoImagemSetaEsquerda_TelaPrincipal = findViewById(R.id.botaoImagemSetaEsquerda_TelaPrincipal);
        BotaoImagemSetaDireita_TelaPrincipal = findViewById(R.id.botaoImagemSetaDireita_TelaPrincipal);
        BotaoImagemProdutoLinha0Coluna0_TelaPrincipal = findViewById(R.id.botaoImagemProdutoLinha0Coluna0_TelaPrincipal);
        BotaoImagemProdutoLinha0Coluna1_TelaPrincipal = findViewById(R.id.botaoImagemProdutoLinha0Coluna1_TelaPrincipal);
        BotaoImagemProdutoLinha1Coluna0_TelaPrincipal = findViewById(R.id.botaoImagemProdutoLinha1Coluna0_TelaPrincipal);
        BotaoImagemProdutoLinha1Coluna1_TelaPrincipal = findViewById(R.id.botaoImagemProdutoLinha1Coluna1_TelaPrincipal);
        TextoProdutoLinha0Coluna0_TelaPrincipal = findViewById(R.id.textoProdutoLinha0Coluna0_TelaPrincipal);
        TextoProdutoLinha0Coluna1_TelaPrincipal = findViewById(R.id.textoProdutoLinha0Coluna1_TelaPrincipal);
        TextoProdutoLinha1Coluna0_TelaPrincipal = findViewById(R.id.textoProdutoLinha1Coluna0_TelaPrincipal);
        TextoProdutoLinha1Coluna1_TelaPrincipal = findViewById(R.id.textoProdutoLinha1Coluna1_TelaPrincipal);
        ImagemLogo_TelaPrincipal = findViewById(R.id.imagemLogo_TelaPrincipal);
        CampoDePesquisa_TelaPrincipal = findViewById(R.id.campoDePesquisa_TelaPrincipal);
    }

    // Metodo que tem como parametro de entrada uma classe e mostra ela na tela:
    public void abrirTela(Class tela){
        Intent it_tela = new Intent(getApplicationContext(), tela);
        startActivity(it_tela);
    }

    public void abrirTelaInformacaoProdutoComArgumentos(String informacao, String loja, int imagem){
        String  Loja = "Produto vendido e entregue por:\nLoja "+loja;
        Intent detalhesDoProduto = new Intent(this, TelaInformacaoProduto.class);
        detalhesDoProduto.putExtra("informacao", informacao);
        detalhesDoProduto.putExtra("loja", Loja);
        detalhesDoProduto.putExtra("foto_do_produto", imagem);
        startActivity(detalhesDoProduto);
    }

    public void evento(){
        BotaoSair_TelaPrincipal.setOnClickListener(view -> { abrirTela(TelaLogin.class); });
        BotaoImagemHome_TelaPrincipal.setOnClickListener(view -> { abrirTela(MainActivity.class); });
        BotaoImagemVender_TelaPrincipal.setOnClickListener(view -> { abrirTela(TelaCadastrarProduto.class); });
        BotaoImagemCategorias_TelaPrincipal.setOnClickListener(view -> { abrirTela(TelaCategorias.class); });
        BotaoImagemCarrinho_TelaPrincipal.setOnClickListener(view -> {abrirTela(TelaCarrinho.class); });
        BotaoImagemPerfil_TelaPrincipal.setOnClickListener(view -> { abrirTela(TelaPerfil.class); });
        BotaoImagemAjuda_TelaPrincipal.setOnClickListener(view -> { abrirTela(TelaAjuda.class); });
        // Cria tipo um carrossel. Ao clicar na seta para a direita troca a foto do imageview por outra:
        BotaoImagemSetaDireita_TelaPrincipal.setOnClickListener(view -> { trocaImagem("Bicicleta2"); });
        // Ao clicar na seta para a esquerda troca a foto do imageview por outra:
        BotaoImagemSetaEsquerda_TelaPrincipal.setOnClickListener(view -> { trocaImagem("Bicicleta1"); });
        BotaoImagemProdutoLinha0Coluna0_TelaPrincipal.setOnClickListener(View->{
            abrirTelaInformacaoProdutoComArgumentos(TextoProdutoLinha0Coluna0_TelaPrincipal.getText().toString(), "TVS", R.drawable.imagem1); });
        BotaoImagemProdutoLinha0Coluna1_TelaPrincipal.setOnClickListener(View->{
            abrirTelaInformacaoProdutoComArgumentos(TextoProdutoLinha0Coluna1_TelaPrincipal.getText().toString(), "Caixas de som LTDA", R.drawable.imagem2); });
        BotaoImagemProdutoLinha1Coluna0_TelaPrincipal.setOnClickListener(View->{
            abrirTelaInformacaoProdutoComArgumentos(TextoProdutoLinha1Coluna0_TelaPrincipal.getText().toString(), "Fones!", R.drawable.imagem3); });
        BotaoImagemProdutoLinha1Coluna1_TelaPrincipal.setOnClickListener(View->{
            abrirTelaInformacaoProdutoComArgumentos(TextoProdutoLinha1Coluna1_TelaPrincipal.getText().toString(), "Cams Photografic", R.drawable.imagem4); });
    }
}