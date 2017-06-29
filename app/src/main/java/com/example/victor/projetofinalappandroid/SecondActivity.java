package com.example.victor.projetofinalappandroid;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina......: M4DADM
//Programação de Computadores e Dispositivos Móveis
//Aluno...........: Victor Hugo Billi de Oliveira Dias
//******************************************************

public class SecondActivity extends AppCompatActivity {

    Button btvoltar, btInserir, btListar;
    private DBHelper dh;
    EditText etNome, etCpf, etIda, etTel, etEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        this.dh = new DBHelper(this);
        etNome = (EditText) findViewById(R.id.etnome);
        etCpf = (EditText) findViewById(R.id.etcpf);
        etIda = (EditText) findViewById(R.id.etida);
        etTel = (EditText) findViewById(R.id.ettel);
        etEmail = (EditText) findViewById(R.id.etemail);
        btInserir = (Button) findViewById(R.id.btinserir);
        btListar = (Button) findViewById(R.id.btlistar);
        btvoltar = (Button) findViewById(R.id.btvoltar);

        //código para adicionar ao banco
        btInserir.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v)
                {
                    if(etNome.getText().length()>0 && etCpf.getText().length()>0 && etIda.getText().length()>0 && etTel.getText().length()>0 && etEmail.getText().length()>0){
                        dh.insert(etNome.getText().toString(), etCpf.getText().toString(), etIda.getText().toString(), etTel.getText().toString(), etEmail.getText().toString());
                        AlertDialog.Builder adb = new AlertDialog.Builder(SecondActivity.this);
                        adb.setTitle("Sucesso");
                        adb.setMessage("Inserido com Sucesso!");
                        adb.show();

                        etNome.setText(" ");
                        etCpf.setText(" ");
                        etIda.setText(" ");
                        etTel.setText(" ");
                        etEmail.setText(" ");
                    }
                    else {
                        AlertDialog.Builder adb = new AlertDialog.Builder(SecondActivity.this);
                        adb.setTitle("Erro");
                        adb.setMessage("Todo os campos devem ser preenchidos!");
                        adb.show();

                        etNome.setText(" ");
                        etCpf.setText(" ");
                        etIda.setText(" ");
                        etTel.setText(" ");
                        etEmail.setText(" ");
                    }
                }
        });

        //código para listar
        btListar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                List<Contato> contatos = dh.queryGetAll();
                if(contatos == null){
                    AlertDialog.Builder adb = new AlertDialog.Builder(SecondActivity.this);
                    adb.setTitle("Mensagem");
                    adb.setMessage("Não há registros Salvos!");
                    adb.show();
                    return;
                }
                for(int i=0; i < contatos.size(); i++){
                    Contato contato = (Contato) contatos.get(i);

                    AlertDialog.Builder adb = new AlertDialog.Builder(SecondActivity.this);
                    adb.setTitle("Registro " + i);
                    adb.setMessage("Nome: " + contato.getNome() + "\nCPF: " + contato.getCpf() + "\nIdade: " + contato.getIda() + "\nTelefone: " + contato.getTel() + "\nEmail: " + contato.getEmail());
                    adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    adb.show();
                }
            }
        });




        //codigo para voltar para tela inicial Activity1
        btvoltar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                chamaPrimeiraTela();
            }
             });
            }

    //funçao para voltar para tela inicial Activity1
        void chamaPrimeiraTela(){
        Intent intent = new Intent();
        intent.setClass(SecondActivity.this, MainActivity.class);
        startActivity(intent);
        finish();

         }
}
