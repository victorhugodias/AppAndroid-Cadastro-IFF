package com.example.victor.projetofinalappandroid;
//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina......: M4DADM
//Programação de Computadores e Dispositivos Móveis
//Aluno...........: Victor Hugo Billi de Oliveira Dias
//******************************************************
/**
 * Created by Victor on 22/06/2017.
 */
public class Contato {
    private String nome;
    private String cpf;
    private String ida;
    private String tel;
    private String email;


    Contato(String nome, String cpf, String ida, String tel, String email)
    {
        this.nome = nome;
        this.cpf = cpf;
        this.ida = ida;
        this.tel = tel;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public String getIda() {
        return ida;
    }

    public void setIda(String ida) {
        this.ida = ida;
    }


    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
