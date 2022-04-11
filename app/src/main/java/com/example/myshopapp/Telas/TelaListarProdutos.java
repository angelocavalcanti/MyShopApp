package com.example.myshopapp.Telas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myshopapp.R;

public class TelaListarProdutos extends AppCompatActivity {

    ImageButton BotaoImagemVoltar;
    ImageButton BotaoImagemHome;
    ImageButton BotaoImagemVender;
    ImageButton BotaoImagemListarCategorias;
    ImageButton BotaoImagemCarrinho;
    ImageButton BotaoImagemPerfil;
    ImageButton BotaoImagemAjuda;
    TextView TextoListaProdutos_TelaListarProdutos;
    Button BotaoProdutoImagem1_TelaListarProdutos;
    Button BotaoProdutoImagem2_TelaListarProdutos;
    Button BotaoProdutoImagem3_TelaListarProdutos;
    Button BotaoProdutoImagem4_TelaListarProdutos;
    Button BotaoProdutoImagem5_TelaListarProdutos;
    ImageView ImagemProduto1_TelaListarProdutos;
    ImageView ImagemProduto2_TelaListarProdutos;
    ImageView ImagemProduto3_TelaListarProdutos;
    ImageView ImagemProduto4_TelaListarProdutos;
    ImageView ImagemProduto5_TelaListarProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_listar_produtos);

        inicializarVariaveis_TelaListarProdutos();
        eventos();

        // Recuperando dados da TelaCategorias:
        Intent intent = getIntent();
        String categoria = intent.getStringExtra("categoria");

        if(categoria.equals("Bicicleta")){
            BotaoProdutoImagem1_TelaListarProdutos.setText("Bicicleta Top\nR$1.400,00");
            BotaoProdutoImagem2_TelaListarProdutos.setText("Bicicleta Extra\nR$1.200,00");
            BotaoProdutoImagem3_TelaListarProdutos.setText("Bicicleta Azul\nR$2.400,00");
            BotaoProdutoImagem4_TelaListarProdutos.setText("Bicicleta Infantil\nR$2.155,00");
            BotaoProdutoImagem5_TelaListarProdutos.setText("Bicicleta Infantil rosa\nR$1.900,00");
            BotaoProdutoImagem1_TelaListarProdutos.setOnClickListener(view -> {
                abrirTelaInformacaoProdutoComArgumentos(BotaoProdutoImagem1_TelaListarProdutos.getText().toString(), "Bikes e CIA", R.drawable.bicicleta1); });
            BotaoProdutoImagem2_TelaListarProdutos.setOnClickListener(view -> {
                abrirTelaInformacaoProdutoComArgumentos(BotaoProdutoImagem2_TelaListarProdutos.getText().toString(), "BikeShow", R.drawable.bicicleta2); });
            BotaoProdutoImagem3_TelaListarProdutos.setOnClickListener(view -> {
                abrirTelaInformacaoProdutoComArgumentos(BotaoProdutoImagem3_TelaListarProdutos.getText().toString(), "Bicicletaria", R.drawable.bicicleta3); });
            BotaoProdutoImagem4_TelaListarProdutos.setOnClickListener(view -> {
                abrirTelaInformacaoProdutoComArgumentos(BotaoProdutoImagem4_TelaListarProdutos.getText().toString(), "Top Bikes!!", R.drawable.bicicleta4); });
            BotaoProdutoImagem5_TelaListarProdutos.setOnClickListener(view -> {
                abrirTelaInformacaoProdutoComArgumentos(BotaoProdutoImagem5_TelaListarProdutos.getText().toString(), "Infatil Bikes!!", R.drawable.bicicleta5); });
        }else if(categoria.equals("Celular")){
            ImagemProduto1_TelaListarProdutos.setImageResource(R.drawable.celular1);
            ImagemProduto2_TelaListarProdutos.setImageResource(R.drawable.celular2);
            ImagemProduto3_TelaListarProdutos.setImageResource(R.drawable.celular3);
            ImagemProduto4_TelaListarProdutos.setImageResource(R.drawable.celular4);
            ImagemProduto5_TelaListarProdutos.setImageResource(R.drawable.celular5);
            BotaoProdutoImagem1_TelaListarProdutos.setText("Celular Top\nR$1.400,00");
            BotaoProdutoImagem2_TelaListarProdutos.setText("Celular Extra\nR$1.200,00");
            BotaoProdutoImagem3_TelaListarProdutos.setText("Celular com câmera que gira\nR$2.400,00");
            BotaoProdutoImagem4_TelaListarProdutos.setText("Celular\nR$2.155,00");
            BotaoProdutoImagem5_TelaListarProdutos.setText("Celular\nR$1.900,00");
            BotaoProdutoImagem1_TelaListarProdutos.setOnClickListener(view -> {
                abrirTelaInformacaoProdutoComArgumentos(BotaoProdutoImagem1_TelaListarProdutos.getText().toString(), "Celular e CIA", R.drawable.celular1); });
            BotaoProdutoImagem2_TelaListarProdutos.setOnClickListener(view -> {
                abrirTelaInformacaoProdutoComArgumentos(BotaoProdutoImagem2_TelaListarProdutos.getText().toString(), "CellPhone", R.drawable.celular2); });
            BotaoProdutoImagem3_TelaListarProdutos.setOnClickListener(view -> {
                abrirTelaInformacaoProdutoComArgumentos(BotaoProdutoImagem3_TelaListarProdutos.getText().toString(), "Celulateria", R.drawable.celular3); });
            BotaoProdutoImagem4_TelaListarProdutos.setOnClickListener(view -> {
                abrirTelaInformacaoProdutoComArgumentos(BotaoProdutoImagem4_TelaListarProdutos.getText().toString(), "Top Celulares!!", R.drawable.celular4); });
            BotaoProdutoImagem5_TelaListarProdutos.setOnClickListener(view -> {
                abrirTelaInformacaoProdutoComArgumentos(BotaoProdutoImagem5_TelaListarProdutos.getText().toString(), "Cell show!!", R.drawable.celular5); });
        }else if(categoria.equals("Fone")){
            ImagemProduto1_TelaListarProdutos.setImageResource(R.drawable.fone1);
            ImagemProduto2_TelaListarProdutos.setImageResource(R.drawable.fone2);
            ImagemProduto3_TelaListarProdutos.setImageResource(R.drawable.fone3);
            ImagemProduto4_TelaListarProdutos.setImageResource(R.drawable.fone4);
            ImagemProduto5_TelaListarProdutos.setImageResource(R.drawable.fone5);
            BotaoProdutoImagem1_TelaListarProdutos.setText("Fone Extra\nR$400,00");
            BotaoProdutoImagem2_TelaListarProdutos.setText("Fone Top\nR$200,00");
            BotaoProdutoImagem3_TelaListarProdutos.setText("Fone de ouvido\nR$150,00");
            BotaoProdutoImagem4_TelaListarProdutos.setText("Fone\nR$75,00");
            BotaoProdutoImagem5_TelaListarProdutos.setText("Fone de ouvido show\nR$322,00");
            BotaoProdutoImagem1_TelaListarProdutos.setOnClickListener(view -> {
                abrirTelaInformacaoProdutoComArgumentos(BotaoProdutoImagem1_TelaListarProdutos.getText().toString(), "Fones!!", R.drawable.fone1); });
            BotaoProdutoImagem2_TelaListarProdutos.setOnClickListener(view -> {
                abrirTelaInformacaoProdutoComArgumentos(BotaoProdutoImagem2_TelaListarProdutos.getText().toString(), "Fones e CIA", R.drawable.fone2); });
            BotaoProdutoImagem3_TelaListarProdutos.setOnClickListener(view -> {
                abrirTelaInformacaoProdutoComArgumentos(BotaoProdutoImagem3_TelaListarProdutos.getText().toString(), "FONES DE OUVIDO", R.drawable.fone3); });
            BotaoProdutoImagem4_TelaListarProdutos.setOnClickListener(view -> {
                abrirTelaInformacaoProdutoComArgumentos(BotaoProdutoImagem4_TelaListarProdutos.getText().toString(), "Top Fones!", R.drawable.fone4); });
            BotaoProdutoImagem5_TelaListarProdutos.setOnClickListener(view -> {
                abrirTelaInformacaoProdutoComArgumentos(BotaoProdutoImagem5_TelaListarProdutos.getText().toString(), "Fone show", R.drawable.fone5); });
        }
    }

    public void inicializarVariaveis_TelaListarProdutos(){
        BotaoImagemAjuda = findViewById(R.id.botaoImagemAjuda_TelaFixa);
        BotaoImagemPerfil = findViewById(R.id.botaoImagemPerfil_TelaFixa);
        BotaoImagemCarrinho = findViewById(R.id.botaoImagemCarrinho_TelaFixa);
        BotaoImagemListarCategorias = findViewById(R.id.botaoImagemListarCategorias_TelaFixa);
        BotaoImagemVender = findViewById(R.id.botaoImagemVender_TelaFixa);
        BotaoImagemHome = findViewById(R.id.botaoImagemHome_TelaFixa);
        BotaoImagemVoltar = findViewById(R.id.botaoImagemVoltar_TelaFixa);
        TextoListaProdutos_TelaListarProdutos = findViewById(R.id.textoListaProdutos_TelaListarProdutos);
        BotaoProdutoImagem1_TelaListarProdutos = findViewById(R.id.botaoProdutoImagem1_TelaListarProdutos);
        BotaoProdutoImagem2_TelaListarProdutos = findViewById(R.id.botaoProdutoImagem2_TelaListarProdutos);
        BotaoProdutoImagem3_TelaListarProdutos = findViewById(R.id.botaoProdutoImagem3_TelaListarProdutos);
        BotaoProdutoImagem4_TelaListarProdutos = findViewById(R.id.botaoProdutoImagem4_TelaListarProdutos);
        BotaoProdutoImagem5_TelaListarProdutos = findViewById(R.id.botaoProdutoImagem5_TelaListarProdutos);
        ImagemProduto1_TelaListarProdutos = findViewById(R.id.imagemProduto1_TelaListarProdutos);
        ImagemProduto2_TelaListarProdutos = findViewById(R.id.imagemProduto2_TelaListarProdutos);
        ImagemProduto3_TelaListarProdutos = findViewById(R.id.imagemProduto3_TelaListarProdutos);
        ImagemProduto4_TelaListarProdutos = findViewById(R.id.imagemProduto4_TelaListarProdutos);
        ImagemProduto5_TelaListarProdutos = findViewById(R.id.imagemProduto5_TelaListarProdutos);
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

    // Metodo que recebe 3 paramentros: 1- string com informação sobre o produto; 2- string nome da loja que vende; 3- int caminho da imagem do produto.
    public void abrirTelaInformacaoProdutoComArgumentos(String informacao, String loja, int imagem){
        String  Loja = "Produto vendido e entregue por:\nLoja "+loja;
        Intent detalhesDoProduto = new Intent(this, TelaInformacaoProduto.class);
        detalhesDoProduto.putExtra("informacao", informacao);
        detalhesDoProduto.putExtra("loja", Loja);
        detalhesDoProduto.putExtra("foto_do_produto", imagem);
        startActivity(detalhesDoProduto);
    }
}
