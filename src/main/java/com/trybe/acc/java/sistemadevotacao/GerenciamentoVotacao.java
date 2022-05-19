package com.trybe.acc.java.sistemadevotacao;

import java.util.ArrayList;

/**
 * Classe GerenciamentoVotacao.
 */
public class GerenciamentoVotacao {

  private ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<PessoaCandidata>();
  private ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<PessoaEleitora>();
  private ArrayList<String> cpfComputado = new ArrayList<String>();
  private int totalVotos;

  /**
   * Methodo cadastra Candidato.
   */
  public void cadastrarPessoaCandidata(String nome, int numero) {
    int total = pessoasCandidatas.size();
    boolean exists = false;
    if (total > 0) {
      for (int i = 0; i < total; i += 1) {
        if (pessoasCandidatas.get(i).numero == numero) {
          exists = true;
        }
      }
    }

    if (exists == true) {
      System.out.println("Número pessoa candidata já utilizado!");
    } else {
      PessoaCandidata newCandidato = new PessoaCandidata(nome, numero);
      pessoasCandidatas.add(newCandidato);
    }
  }

  /**
   * Metodo Cadastrar Eleitores.
   */
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    int total = pessoasEleitoras.size();

    boolean exists = false;
    if (total > 0) {
      for (int i = 0; i < total; i += 1) {
        if (pessoasEleitoras.get(i).cpf.equals(cpf)) {
          exists = true;
        }
      }
    }

    if (exists == true) {
      System.out.println("Pessoa eleitora já cadastrada!");
    } else {
      PessoaEleitora newEleitor = new PessoaEleitora(nome, cpf);
      pessoasEleitoras.add(newEleitor);
    }
  }

  /**
   * Metodo Votar.
   */
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    System.out.println(cpfComputado.contains(cpfPessoaEleitora));

    if (cpfComputado.contains(cpfPessoaEleitora)) {
      System.out.println("Pessoa eleitora já votou!");
    } else {
      cpfComputado.add(cpfPessoaEleitora);
      int total = pessoasCandidatas.size();
      for (int i = 0; i < total; i += 1) {
        if (pessoasCandidatas.get(i).numero == numeroPessoaCandidata) {
          pessoasCandidatas.get(i).receberVoto();
        }
      }
    }
  }

  /**
   * Mostrar Resultados.
   */
  public void mostrarResultado() {
    int votos = cpfComputado.size();
    if (votos == 0) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
    } else {
      int total = pessoasCandidatas.size();
      for (int i = 0; i < total; i += 1) {
        calcularPorcentagemVotos(i);
      }
      System.out.println("Total de votos: " + votos);
    }
  }

  private void calcularPorcentagemVotos(int indice) {
    double totalVotos = cpfComputado.size();
    double votos = pessoasCandidatas.get(indice).getVotos();
    String nome = pessoasCandidatas.get(indice).getNome();

    double porcentagem = (votos / totalVotos) * 100;
    System.out.println("Nome: " + nome + " - " + votos + " votos " + "( " + porcentagem + " )");


  }
}
