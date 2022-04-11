package com.example.myshopapp.Telas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myshopapp.BancodeDados.BancoSQLite;
import com.example.myshopapp.Modulos.Usuario;
import com.example.myshopapp.Modulos.Vendedor;
import com.example.myshopapp.R;

public class TelaCadastroUsuario extends AppCompatActivity {

    ImageButton BotaoImagemVoltar;
    ImageButton BotaoImagemHome;
    ImageButton BotaoImagemVender;
    ImageButton BotaoImagemListarCategorias;
    ImageButton BotaoImagemCarrinho;
    ImageButton BotaoImagemPerfil;
    ImageButton BotaoImagemAjuda;
    TextView TextoCadastro_TelaCadastroUsuario;
    EditText CampoNome_TelaCadastroUsuario;
    EditText CampoCEP_TelaCadastroUsuario;
    EditText CampoEndereco_TelaCadastroUsuario;
    EditText CampoBairro_TelaCadastroUsuario;
    EditText CampoCidade_TelaCadastroUsuario;
    EditText CampoEstado_TelaCadastroUsuario;
    EditText CampoTelefone_TelaCadastroUsuario;
    Button BotaoCadastrar_TelaCadastroUsuario;
    RadioButton BotaoRadioUsuario_TelaCadastroUsuario;
    RadioButton BotaoRadioVendedor_TelaCadastroUsuario;
    EditText CampoEmail_TelaCadastroUsuario;
    EditText CampoDocumento_TelaCadastroUsuario;
    EditText CampoSenha_TelaCadastroUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro_usuario);

        inicializarVariaveis_TelaCadastroUsuario();
        eventos();
    }

    // Metodo que inicializa as variaveis com os IDs do XML da tela:
    public void inicializarVariaveis_TelaCadastroUsuario(){
        BotaoImagemAjuda = findViewById(R.id.botaoImagemAjuda_TelaFixa);
        BotaoImagemPerfil = findViewById(R.id.botaoImagemPerfil_TelaFixa);
        BotaoImagemCarrinho = findViewById(R.id.botaoImagemCarrinho_TelaFixa);
        BotaoImagemListarCategorias = findViewById(R.id.botaoImagemListarCategorias_TelaFixa);
        BotaoImagemVender = findViewById(R.id.botaoImagemVender_TelaFixa);
        BotaoImagemHome = findViewById(R.id.botaoImagemHome_TelaFixa);
        BotaoImagemVoltar = findViewById(R.id.botaoImagemVoltar_TelaFixa);
        TextoCadastro_TelaCadastroUsuario = findViewById(R.id.textoCadastro_TelaCadastroUsuario);
        CampoNome_TelaCadastroUsuario = findViewById(R.id.campoNome_TelaCadastroUsuario);
        CampoCEP_TelaCadastroUsuario = findViewById(R.id.campoCEP_TelaCadastroUsuario);
        CampoEndereco_TelaCadastroUsuario = findViewById(R.id.campoEndereco_TelaCadastroUsuario);
        CampoBairro_TelaCadastroUsuario = findViewById(R.id.campoBairro_TelaCadastroUsuario);
        CampoCidade_TelaCadastroUsuario = findViewById(R.id.campoCidade_TelaCadastroUsuario);
        CampoEstado_TelaCadastroUsuario = findViewById(R.id.campoEstado_TelaCadastroUsuario);
        CampoTelefone_TelaCadastroUsuario = findViewById(R.id.campoTelefone_TelaCadastroUsuario);
        BotaoCadastrar_TelaCadastroUsuario = findViewById(R.id.botaoCadastrar_TelaCadastroUsuario);
        BotaoRadioUsuario_TelaCadastroUsuario = findViewById(R.id.botaoRadioUsuario_TelaCadastroUsuario);
        BotaoRadioVendedor_TelaCadastroUsuario = findViewById(R.id.botaoRadioVendedor_TelaCadastroUsuario);
        CampoEmail_TelaCadastroUsuario = findViewById(R.id.campoEmail_TelaCadastroUsuario);
        CampoDocumento_TelaCadastroUsuario = findViewById(R.id.campoDocumento_TelaCadastroUsuario);
        CampoSenha_TelaCadastroUsuario = findViewById(R.id.campoSenha_TelaCadastroUsuario);
    }

    // Metodo que tem como parametro de entrada uma classe e mostra ela na tela
    public void abrirTela(Class tela){
        Intent it = new Intent(getApplicationContext(), tela);
        startActivity(it);
    }

    public void eventos() {
        BotaoImagemVoltar.setOnClickListener(view -> { abrirTela(TelaLogin.class); });
        BotaoImagemHome.setOnClickListener(view -> { abrirTela(MainActivity.class); });
        BotaoImagemVender.setOnClickListener(view -> { abrirTela(TelaCadastrarProduto.class); });
        BotaoImagemListarCategorias.setOnClickListener(view -> { abrirTela(TelaCategorias.class); });
        BotaoImagemCarrinho.setOnClickListener(view -> { abrirTela(TelaCarrinho.class); });
        BotaoImagemPerfil.setOnClickListener(view -> { abrirTela(TelaPerfil.class); });
        BotaoImagemAjuda.setOnClickListener(view -> { abrirTela(TelaAjuda.class); });

        // Altera o hint do campo documento entre CPF e CNPJ de acordo com o clique nos radiobuttons na tela de cadastro de usuário:
        BotaoRadioVendedor_TelaCadastroUsuario.setOnClickListener(view -> { CampoDocumento_TelaCadastroUsuario.setHint("CNPJ"); });
        BotaoRadioUsuario_TelaCadastroUsuario.setOnClickListener(view -> { CampoDocumento_TelaCadastroUsuario.setHint("CPF"); });

        BotaoCadastrar_TelaCadastroUsuario.setOnClickListener(view -> {
            BancoSQLite db = new BancoSQLite(this);
            // Caso seja escolhido o radiobutton USUARIO, será feito o cadastro na tabela usuario do BD:
            if (BotaoRadioUsuario_TelaCadastroUsuario.isChecked()) {
                if (db.inserirUsuario(
                        new Usuario(
                                CampoNome_TelaCadastroUsuario.getText().toString(),
                                CampoEmail_TelaCadastroUsuario.getText().toString(),
                                CampoDocumento_TelaCadastroUsuario.getText().toString(),
                                CampoTelefone_TelaCadastroUsuario.getText().toString(),
                                CampoSenha_TelaCadastroUsuario.getText().toString(),
                                CampoCEP_TelaCadastroUsuario.getText().toString(),
                                CampoEndereco_TelaCadastroUsuario.getText().toString(),
                                CampoBairro_TelaCadastroUsuario.getText().toString(),
                                CampoCidade_TelaCadastroUsuario.getText().toString(),
                                CampoEstado_TelaCadastroUsuario.getText().toString()))
                ) {
                    Toast.makeText(this, "USUARIO CADASTRADO COM SUCESSO!", Toast.LENGTH_SHORT).show();
                    abrirTela(TelaLogin.class);
                } else {
                    Toast.makeText(this, "NÃO FOI POSSÍVEL EFETUAR O CADASTRO!", Toast.LENGTH_SHORT).show();
                }
            }
            // Caso seja escolhido o radiobutton VENDEDOR, será feito o cadastro na tabela vendedor do BD:
            else if (BotaoRadioVendedor_TelaCadastroUsuario.isChecked()) {
                if (db.inserirVendedor(
                        new Vendedor(
                                CampoNome_TelaCadastroUsuario.getText().toString(),
                                CampoEmail_TelaCadastroUsuario.getText().toString(),
                                CampoDocumento_TelaCadastroUsuario.getText().toString(),
                                CampoTelefone_TelaCadastroUsuario.getText().toString(),
                                CampoSenha_TelaCadastroUsuario.getText().toString(),
                                CampoCEP_TelaCadastroUsuario.getText().toString(),
                                CampoEndereco_TelaCadastroUsuario.getText().toString(),
                                CampoBairro_TelaCadastroUsuario.getText().toString(),
                                CampoCidade_TelaCadastroUsuario.getText().toString(),
                                CampoEstado_TelaCadastroUsuario.getText().toString()))
                ) {
                    Toast.makeText(this, "VENDEDOR CADASTRADO COM SUCESSO!", Toast.LENGTH_SHORT).show();
                    abrirTela(TelaLogin.class);
                } else {
                    Toast.makeText(this, "NÃO FOI POSSÍVEL EFETUAR O CADASTRO!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "ESCOLHA UMA OPÇÃO ENTRE USUÁRIO OU VENDEDOR!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}