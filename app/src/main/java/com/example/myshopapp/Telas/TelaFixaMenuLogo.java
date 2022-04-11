package com.example.myshopapp.Telas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.myshopapp.R;

public class TelaFixaMenuLogo extends AppCompatActivity {

    ImageView ImagemLogo_TelaFixa;
    ImageButton BotaoImagemVoltar_TelaFixa;
    ImageButton BotaoImagemHome_TelaFixa;
    ImageButton BotaoImagemVender_TelaFixa;
    ImageButton BotaoImagemListarCategorias_TelaFixa;
    ImageButton BotaoImagemCarrinho_TelaFixa;
    ImageButton BotaoImagemPerfil_TelaFixa;
    ImageButton BotaoImagemAjuda_TelaFixa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_fixa_menu_logo);

        ImagemLogo_TelaFixa = findViewById(R.id.imagemLogo_TelaFixa);
        BotaoImagemVoltar_TelaFixa = findViewById(R.id.botaoImagemVoltar_TelaFixa);
        BotaoImagemHome_TelaFixa = findViewById(R.id.botaoImagemHome_TelaFixa);
        BotaoImagemVender_TelaFixa = findViewById(R.id.botaoImagemVender_TelaFixa);
        BotaoImagemListarCategorias_TelaFixa = findViewById(R.id.botaoImagemListarCategorias_TelaFixa);
        BotaoImagemCarrinho_TelaFixa = findViewById(R.id.botaoImagemCarrinho_TelaFixa);
        BotaoImagemPerfil_TelaFixa = findViewById(R.id.botaoImagemPerfil_TelaFixa);
        BotaoImagemAjuda_TelaFixa = findViewById(R.id.botaoImagemAjuda_TelaFixa);
    }
}