package com.example.myshopapp.Telas;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myshopapp.R;

public class TelaPlanoPremium extends AppCompatActivity {

    ImageButton BotaoImagemVoltar;
    ImageButton BotaoImagemHome;
    ImageButton BotaoImagemVender;
    ImageButton BotaoImagemListarCategorias;
    ImageButton BotaoImagemCarrinho;
    ImageButton BotaoImagemPerfil;
    ImageButton BotaoImagemAjuda;
    TextView TextoContratoPlanoPremium_TelaPlanoPremium;
    ImageView ImagemContratoPremium_TelaPlanoPremium;
    CheckBox CheckBoxAceitaTermosContratoPremimum_TelaPlanoPremium;
    Button BotaoIrParaPagamento_TelaPlanoPremium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_plano_premium);

        inicializarVariaveis_TelaPlanoPremium();
        eventos();
    }

    public void inicializarVariaveis_TelaPlanoPremium(){
        BotaoImagemAjuda = findViewById(R.id.botaoImagemAjuda_TelaFixa);
        BotaoImagemPerfil = findViewById(R.id.botaoImagemPerfil_TelaFixa);
        BotaoImagemCarrinho = findViewById(R.id.botaoImagemCarrinho_TelaFixa);
        BotaoImagemListarCategorias = findViewById(R.id.botaoImagemListarCategorias_TelaFixa);
        BotaoImagemVender = findViewById(R.id.botaoImagemVender_TelaFixa);
        BotaoImagemHome = findViewById(R.id.botaoImagemHome_TelaFixa);
        BotaoImagemVoltar = findViewById(R.id.botaoImagemVoltar_TelaFixa);
        TextoContratoPlanoPremium_TelaPlanoPremium = findViewById(R.id.textoContratoPlanoPremium_TelaPlanoPremium);
        ImagemContratoPremium_TelaPlanoPremium = findViewById(R.id.imagemContratoPremium_TelaPlanoPremium);
        CheckBoxAceitaTermosContratoPremimum_TelaPlanoPremium = findViewById(R.id.checkBoxAceitaTermosContratoPremimum_TelaPlanoPremium);
        BotaoIrParaPagamento_TelaPlanoPremium = findViewById(R.id.botaoIrParaPagamento_TelaPlanoPremium);
    }

    public void eventos(){
        BotaoImagemVoltar.setOnClickListener(view -> { abrirTela(MainActivity.class); });
        BotaoImagemHome.setOnClickListener(view -> { abrirTela(MainActivity.class); });
        BotaoImagemVender.setOnClickListener(view -> { abrirTela(TelaCadastrarProduto.class);});
        BotaoImagemListarCategorias.setOnClickListener(view -> { abrirTela(TelaCategorias.class); });
        BotaoImagemCarrinho.setOnClickListener(view -> { abrirTela(TelaCarrinho.class); });
        BotaoImagemPerfil.setOnClickListener(view -> { abrirTela(TelaPerfil.class); });
        BotaoImagemAjuda.setOnClickListener(view -> { abrirTela(TelaAjuda.class); });
        BotaoIrParaPagamento_TelaPlanoPremium.setOnClickListener(view -> {
            if(CheckBoxAceitaTermosContratoPremimum_TelaPlanoPremium.isChecked()){
                abrirTela(TelaPagamentoPlanoPremium.class);
            } else{
                CheckBoxAceitaTermosContratoPremimum_TelaPlanoPremium.setTextColor(getResources().getColor(R.color.corErro));
                Toast.makeText(this, "ACEITE OS TERMOS DO CONTRATO PARA PROSSEGUIR!", Toast.LENGTH_SHORT).show();
                CheckBoxAceitaTermosContratoPremimum_TelaPlanoPremium.setOnClickListener(view2 -> {
                    CheckBoxAceitaTermosContratoPremimum_TelaPlanoPremium.setTextColor(getResources().getColor(R.color.black));;
                });
            }
        });
    }

    public void abrirTela(Class tela){
        Intent it_tela = new Intent(getApplicationContext(), tela);
        startActivity(it_tela);
    }
}
