package com.aula.sistema_alunos;

// Essa classe define o que um Aluno tem no nosso sistema [cite: 32]
public class Aluno {
    private Long id;
    private String nome;
    private String curso;

    // Construtor vazio (obrigatório para o Spring)
    public Aluno() {}

    // Getters e Setters (para o sistema conseguir ler e escrever os dados)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }
}