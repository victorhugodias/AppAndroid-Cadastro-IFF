package com.example.victor.projetofinalappandroid;

//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina......: M4DADM
//Programação de Computadores e Dispositivos Móveis
//Aluno...........: Victor Hugo Billi de Oliveira Dias
//******************************************************





import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {

    Button btsegundatela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btsegundatela = (Button) findViewById(R.id.btsegundatela);
        btsegundatela.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                chamaSegundaTela();
            }
        });
    }

    void chamaSegundaTela(){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, SecondActivity.class);
        startActivity(intent);
        finish();

    }
}
