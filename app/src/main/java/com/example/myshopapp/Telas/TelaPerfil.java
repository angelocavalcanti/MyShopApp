package com.example.myshopapp.Telas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myshopapp.BancodeDados.BancoSQLite;
import com.example.myshopapp.Modulos.Usuario;
import com.example.myshopapp.R;

public class TelaPerfil extends AppCompatActivity {

    ImageButton BotaoImagemVoltar;
    ImageButton BotaoImagemHome;
    ImageButton BotaoImagemVender;
    ImageButton BotaoImagemListarCategorias;
    ImageButton BotaoImagemCarrinho;
    ImageButton BotaoImagemPerfil;
    ImageButton BotaoImagemAjuda;
    ImageView ImagemFotoPerfil_TelaPerfil;
    TextView TextoInformacaoPerfil_TelaPerfil;
    TextView TextoCEP_TelaPerfil;
    TextView TextoEndereco_TelaPerfil;
    TextView TextoBairro_TelaPerfil;
    TextView TextoCidade_TelaPerfil;
    TextView TextoEstado_TelaPerfil;
    Button BotaoTornesePremium_TelaPerfil;
    Button Botaosair_TelaPerfil;
    Button BotaoCadastrarProduto_TelaPerfil;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_perfil);

        inicializarVariaveis_TelaPerfil();
        eventos();
        habilitarAnimacaoBotaoTornesePremium();

        // Pega as informações do ID 1 de cliente do BD:
        BancoSQLite db = new BancoSQLite(this);
        Usuario usuario = db.selecionarUsuarioporID("1");

        String textoInformacoesPrincipais = usuario.getNome() + "\n" + usuario.getEmail() + "\n" + usuario.getDocumento() + "\n" + usuario.getTelefone();
        TextoInformacaoPerfil_TelaPerfil.setText(textoInformacoesPrincipais);
        TextoCEP_TelaPerfil.setText("CEP: " + usuario.getCep());
        TextoEndereco_TelaPerfil.setText("Endereço: " + usuario.getEndereco());
        TextoBairro_TelaPerfil.setText("Bairro: " + usuario.getBairro());
        TextoCidade_TelaPerfil.setText("Cidade: " + usuario.getCidade());
        TextoEstado_TelaPerfil.setText("Estado: " + usuario.getEstado());
    }

    public void inicializarVariaveis_TelaPerfil(){
        BotaoImagemAjuda = findViewById(R.id.botaoImagemAjuda_TelaFixa);
        BotaoImagemPerfil = findViewById(R.id.botaoImagemPerfil_TelaFixa);
        BotaoImagemCarrinho = findViewById(R.id.botaoImagemCarrinho_TelaFixa);
        BotaoImagemListarCategorias = findViewById(R.id.botaoImagemListarCategorias_TelaFixa);
        BotaoImagemVender = findViewById(R.id.botaoImagemVender_TelaFixa);
        BotaoImagemHome = findViewById(R.id.botaoImagemHome_TelaFixa);
        BotaoImagemVoltar = findViewById(R.id.botaoImagemVoltar_TelaFixa);
        Botaosair_TelaPerfil = findViewById(R.id.botaosair_TelaPerfil);
        ImagemFotoPerfil_TelaPerfil = findViewById(R.id.imagemFotoPerfil_TelaPerfil);
        TextoInformacaoPerfil_TelaPerfil = findViewById(R.id.textoInformacaoPerfil_TelaPerfil);
        TextoCEP_TelaPerfil = findViewById(R.id.textoCEP_TelaPerfil);
        TextoEndereco_TelaPerfil = findViewById(R.id.textoEndereco_TelaPerfil);
        TextoBairro_TelaPerfil = findViewById(R.id.textoBairro_TelaPerfil);
        TextoCidade_TelaPerfil = findViewById(R.id.textoCidade_TelaPerfil);
        TextoEstado_TelaPerfil = findViewById(R.id.textoEstado_TelaPerfil);
        BotaoTornesePremium_TelaPerfil = findViewById(R.id.botaoTornesePremium_TelaPerfil);
        BotaoCadastrarProduto_TelaPerfil = findViewById(R.id.botaoCadastrarProduto_TelaPerfil);
    }

    public void eventos(){
        BotaoImagemVoltar.setOnClickListener(view -> { abrirTela(MainActivity.class); });
        BotaoImagemHome.setOnClickListener(view -> { abrirTela(MainActivity.class); });
        BotaoImagemVender.setOnClickListener(view -> { abrirTela(TelaCadastrarProduto.class);});
        BotaoImagemListarCategorias.setOnClickListener(view -> { abrirTela(TelaCategorias.class); });
        BotaoImagemCarrinho.setOnClickListener(view -> { abrirTela(TelaCarrinho.class); });
        BotaoImagemPerfil.setOnClickListener(view -> { abrirTela(TelaPerfil.class); });
        BotaoImagemAjuda.setOnClickListener(view -> { abrirTela(TelaAjuda.class); });
        Botaosair_TelaPerfil.setOnClickListener(view -> { abrirTela(TelaLogin.class); });
        BotaoCadastrarProduto_TelaPerfil.setOnClickListener(view ->{ abrirTela(TelaCadastrarProduto.class); });
        BotaoTornesePremium_TelaPerfil.setOnClickListener(view ->{ abrirTela(TelaPlanoPremium.class); });
    }

    public void abrirTela(Class tela){
        Intent it_tela = new Intent(getApplicationContext(), tela);
        startActivity(it_tela);
    }

    public void habilitarAnimacaoBotaoTornesePremium(){
        // Animação para o botão de "Torne-se Premium" na Tela de perfil do cliente ficar piscando.
        animation = new AlphaAnimation(0,1); // Altera alpha de visível a invisível.
        animation.setDuration(1000); // Duração - um segundo.
        animation.setInterpolator(new LinearInterpolator());
        animation.setRepeatCount(Animation.INFINITE); // Repetir infinitamente.
        animation.setRepeatMode(Animation.REVERSE); // Inverte a animação no final para que o botão vá desaparecendo.
        BotaoTornesePremium_TelaPerfil.startAnimation(animation);
    }
}