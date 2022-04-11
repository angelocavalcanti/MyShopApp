package com.example.myshopapp.Telas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myshopapp.BancodeDados.BancoSQLite;
import com.example.myshopapp.Modulos.Produto;
import com.example.myshopapp.R;

public class TelaCadastrarProduto extends AppCompatActivity {

    ImageButton BotaoImagemVoltar;
    ImageButton BotaoImagemHome;
    ImageButton BotaoImagemVender;
    ImageButton BotaoImagemListarCategorias;
    ImageButton BotaoImagemCarrinho;
    ImageButton BotaoImagemPerfil;
    ImageButton BotaoImagemAjuda;
    TextView TextoCadastro_TelaCadastroProduto;
    EditText CampoCodBarras_TelaCadastroProduto;
    Spinner SpinnerCategorias_TelaCadastroProduto;
    EditText CampoNomeProduto_TelaCadastroProduto;
    EditText CampoQuantidade_TelaCadastroProduto;
    EditText CampoDescricaoProduto_TelaCadastroProduto;
    EditText CampoMarcaProduto_TelaCadastroProduto;
    EditText CampoPrecoCustoProduto_TelaCadastroProduto;
    EditText CampoPrecoVendaProduto_TelaCadastroProduto;
    Button BotaoCadastrar_TelaCadastroProduto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastrar_produto);

        inicializarVariaveis_TelaCadastrarProduto();
        eventos();
    }

    public void inicializarVariaveis_TelaCadastrarProduto() {
        BotaoImagemAjuda = findViewById(R.id.botaoImagemAjuda_TelaFixa);
        BotaoImagemPerfil = findViewById(R.id.botaoImagemPerfil_TelaFixa);
        BotaoImagemCarrinho = findViewById(R.id.botaoImagemCarrinho_TelaFixa);
        BotaoImagemListarCategorias = findViewById(R.id.botaoImagemListarCategorias_TelaFixa);
        BotaoImagemVender = findViewById(R.id.botaoImagemVender_TelaFixa);
        BotaoImagemHome = findViewById(R.id.botaoImagemHome_TelaFixa);
        BotaoImagemVoltar = findViewById(R.id.botaoImagemVoltar_TelaFixa);
        TextoCadastro_TelaCadastroProduto = findViewById(R.id.textoCadastro_TelaCadastroProduto);
        CampoCodBarras_TelaCadastroProduto = findViewById(R.id.campoCodBarras_TelaCadastroProduto);
        SpinnerCategorias_TelaCadastroProduto = findViewById(R.id.spinnerCategorias_TelaCadastroProduto);
        CampoNomeProduto_TelaCadastroProduto = findViewById(R.id.campoNomeProduto_TelaCadastroProduto);
        CampoQuantidade_TelaCadastroProduto = findViewById(R.id.campoQuantidade_TelaCadastroProduto);
        CampoDescricaoProduto_TelaCadastroProduto = findViewById(R.id.campoDescricaoProduto_TelaCadastroProduto);
        CampoMarcaProduto_TelaCadastroProduto = findViewById(R.id.campoMarcaProduto_TelaCadastroProduto);
        CampoPrecoCustoProduto_TelaCadastroProduto = findViewById(R.id.campoPrecoCustoProduto_TelaCadastroProduto);
        CampoPrecoVendaProduto_TelaCadastroProduto = findViewById(R.id.campoPrecoVendaProduto_TelaCadastroProduto);
        BotaoCadastrar_TelaCadastroProduto = findViewById(R.id.botaoCadastrar_TelaCadastroProduto);
    }

    public void eventos(){
        BotaoImagemVoltar.setOnClickListener(view -> { abrirTela(MainActivity.class); });
        BotaoImagemHome.setOnClickListener(view -> { abrirTela(MainActivity.class); });
        BotaoImagemVender.setOnClickListener(view -> { abrirTela(TelaCadastrarProduto.class);});
        BotaoImagemListarCategorias.setOnClickListener(view -> { abrirTela(TelaCategorias.class); });
        BotaoImagemCarrinho.setOnClickListener(view -> { abrirTela(TelaCarrinho.class); });
        BotaoImagemPerfil.setOnClickListener(view -> { abrirTela(TelaPerfil.class); });
        BotaoImagemAjuda.setOnClickListener(view -> { abrirTela(TelaAjuda.class); });

        BotaoCadastrar_TelaCadastroProduto.setOnClickListener(view -> {
            BancoSQLite db = new BancoSQLite(this);
            if (db.inserirProduto(
                    new Produto(
                            CampoCodBarras_TelaCadastroProduto.getText().toString(),
                            SpinnerCategorias_TelaCadastroProduto.getSelectedItem().toString(),
                            CampoNomeProduto_TelaCadastroProduto.getText().toString(),
                            CampoQuantidade_TelaCadastroProduto.getText().toString(),
                            CampoDescricaoProduto_TelaCadastroProduto.getText().toString(),
                            CampoMarcaProduto_TelaCadastroProduto.getText().toString(),
                            CampoPrecoCustoProduto_TelaCadastroProduto.getText().toString(),
                            CampoPrecoVendaProduto_TelaCadastroProduto.getText().toString()))
            ) {
                Toast.makeText(this, "PRODUTO CADASTRADO COM SUCESSO!", Toast.LENGTH_SHORT).show();
                abrirTela(MainActivity.class);
            } else {
                Toast.makeText(this, "NÃO FOI POSSÍVEL EFETUAR O CADASTRO!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void abrirTela(Class tela){
        Intent it_tela = new Intent(getApplicationContext(), tela);
        startActivity(it_tela);
    }
}