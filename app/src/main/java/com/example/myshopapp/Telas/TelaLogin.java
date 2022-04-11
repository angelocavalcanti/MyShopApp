package com.example.myshopapp.Telas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;
import com.example.myshopapp.BancodeDados.BancoSQLite;
import com.example.myshopapp.Modulos.Usuario;
import com.example.myshopapp.Modulos.Vendedor;
import com.example.myshopapp.R;

public class TelaLogin extends AppCompatActivity {

    ImageView ImagemLogo_TelaLogin;
    EditText CampoEmail_TelaLogin;
    EditText CampoSenha_TelaLogin;
    Button BotaoEsqueceuSenha_TelaLogin;
    Button BotaoEntrar_TelaLogin;
    Button BotaoCadastrese_TelaLogin;
    RadioButton BotaoRadioUsuario_TelaLogin;
    RadioButton BotaoRadioVendedor_TelaLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        inicializarVariaveis_TelaLogin();
        eventoBotao_TelaLogin();
    }

    public void inicializarVariaveis_TelaLogin(){
        ImagemLogo_TelaLogin = findViewById(R.id.imagemLogo_TelaLogin);
        CampoEmail_TelaLogin = findViewById(R.id.campoEmail_TelaLogin);
        CampoSenha_TelaLogin = findViewById(R.id.campoSenha_TelaLogin);
        BotaoEsqueceuSenha_TelaLogin = findViewById(R.id.botaoEsqueceuSenha_TelaLogin);
        BotaoEntrar_TelaLogin = findViewById(R.id.botaoEntrar_TelaLogin);
        BotaoCadastrese_TelaLogin = findViewById(R.id.botaoCadastrese_TelaLogin);
        BotaoRadioUsuario_TelaLogin = findViewById(R.id.botaoRadioUsuario_TelaLogin);
        BotaoRadioVendedor_TelaLogin = findViewById(R.id.botaoRadioVendedor_TelaLogin);
        BotaoEsqueceuSenha_TelaLogin = findViewById(R.id.botaoEsqueceuSenha_TelaLogin);
    }

    public void eventoBotao_TelaLogin(){
        BotaoCadastrese_TelaLogin.setOnClickListener(view -> { abrirTela(TelaCadastroUsuario.class); });
        BotaoEntrar_TelaLogin.setOnClickListener(view -> {
            if(CampoEmail_TelaLogin.getText().toString().isEmpty() || CampoSenha_TelaLogin.getText().toString().isEmpty()) {
                Toast.makeText(this, "PREENCHA OS CAMPOS E-MAIL E SENHA PARA PROSSEGUIR!", Toast.LENGTH_LONG).show();
            }else {
                if (BotaoRadioUsuario_TelaLogin.isChecked()) {
                    BancoSQLite db = new BancoSQLite(this);
                    try {
                        Usuario usuario = db.selecionarUsuario(CampoEmail_TelaLogin.getText().toString());
                        if (usuario.getSenha().equals(CampoSenha_TelaLogin.getText().toString())) {
                            Intent it = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(it);
                        } else {
                            Toast.makeText(this, "CLIENTE NÃO CADASTRADO!", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        Toast.makeText(this, "CLIENTE NÃO CADASTRADO!", Toast.LENGTH_SHORT).show();
                    }
                } else if (BotaoRadioVendedor_TelaLogin.isChecked()) {
                    BancoSQLite db = new BancoSQLite(this);
                    try {
                        Vendedor vendedor = db.selecionarVendedor(CampoEmail_TelaLogin.getText().toString());
                        if (vendedor.getSenha().equals(CampoSenha_TelaLogin.getText().toString())) {
                            Intent it = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(it);
                        } else {
                            Toast.makeText(this, "VENDEDOR NÃO CADASTRADO!", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        Toast.makeText(this, "VENDEDOR NÃO CADASTRADO!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

// ==== Botão de esquecer senha deverá ser implementado futuramente para enviar redefinição de senha ao e-mail do usuário cadastrado: =====
        BotaoEsqueceuSenha_TelaLogin.setOnClickListener(view -> {
            if(CampoEmail_TelaLogin.getText().toString().isEmpty()) {
                Toast.makeText(this, "PREENCHA O CAMPO E-MAIL PARA REDEFINIR SUA SENHA!", Toast.LENGTH_SHORT).show();
            }else if (BotaoRadioUsuario_TelaLogin.isChecked()) {
                BancoSQLite db = new BancoSQLite(this);
                try {
                    Usuario usuario = db.selecionarUsuario(CampoEmail_TelaLogin.getText().toString());
                    if (!(usuario == null)) {
// ====== Implementar aqui código para enviar redefinição de senha para o e-mail do CLIENTE cadastrado. ========
                        Toast.makeText(this, "REDEFINIÇÃO DE SENHA DE CLIENTE ENVIADA PARA O E-MAIL INFORMADO!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "======CLIENTE NÃO CADASTRADO!", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(this, "CLIENTE NÃO CADASTRADO!", Toast.LENGTH_SHORT).show();
                }
            }else if (BotaoRadioVendedor_TelaLogin.isChecked()){
                BancoSQLite db = new BancoSQLite(this);
                try {
                    Vendedor vendedor = db.selecionarVendedor(CampoEmail_TelaLogin.getText().toString());
                    if (!(vendedor == null)) {
// ====== Implementar aqui código para enviar redefinição de senha para o e-mail do VENDEDOR cadastrado. =======
                        Toast.makeText(this, "REDEFINIÇÃO DE SENHA DE VENDEDOR ENVIADA PARA O E-MAIL INFORMADO!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "VENDEDOR NÃO CADASTRADO!", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(this, "VENDEDOR NÃO CADASTRADO!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void abrirTela(Class tela){
        Intent it_tela = new Intent(getApplicationContext(), tela);
        startActivity(it_tela);
    }
}