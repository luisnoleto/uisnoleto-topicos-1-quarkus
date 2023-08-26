package br.unitins.topicos1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Album{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private float preco;
    private String publicador;
    private String gravadora;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco){
        this.preco = preco;
    }

    public String getPublicador() {
        return publicador;
    }

    public void setPublicador(String publicador){
        this.publicador = publicador;
    }

    public String getGravadora() {
        return gravadora;
    }

    public void setGravadora(String gravadora){
        this.gravadora = gravadora;
    }

}