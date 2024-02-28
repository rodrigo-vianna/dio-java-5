package br.com.rodrigovianna.dominio;

import java.util.LinkedHashSet;
import java.util.Set;

public class Dev {
  private String nome;
  private Set<Conteudo> conteudosInscritos = new LinkedHashSet();
  private Set<Conteudo> conteudosConcluidos = new LinkedHashSet();

  public Dev(String nome) {
    this.nome = nome;
  }

  public void inscreverBootcamp(Bootcamp bootcamp) {
    this.conteudosInscritos.addAll(bootcamp.getConteudos());
    bootcamp.getDevsInscritos().add(this);
  }

  public void progredir() {
    this.conteudosInscritos.stream().findFirst().ifPresentOrElse(conteudo -> {
      this.conteudosConcluidos.add(conteudo);
      this.conteudosInscritos.remove(conteudo);
    }, () -> System.out.println("Você não tem mais conteúdos para progredir"));
  }

  public double calcularTotalXp() {
    return this.conteudosConcluidos.stream().mapToDouble(Conteudo::calcularXp).sum();
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Set<Conteudo> getConteudosInscritos() {
    return conteudosInscritos;
  }

  public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
    this.conteudosInscritos = conteudosInscritos;
  }

  public Set<Conteudo> getConteudosConcluidos() {
    return conteudosConcluidos;
  }

  public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
    this.conteudosConcluidos = conteudosConcluidos;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((nome == null) ? 0 : nome.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Dev other = (Dev) obj;
    if (nome == null) {
      if (other.nome != null)
        return false;
    } else if (!nome.equals(other.nome))
      return false;
    return true;
  }

}
