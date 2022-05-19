package com.trybe.acc.java.sistemadevotacao;

import java.util.Scanner;

/**
 * Classe Principal.
 */
public class Principal {
  /**
   * Metodo Main.
   */
  public static void main(String[] args) {
    GerenciamentoVotacao gerenciamento = new GerenciamentoVotacao();
    Scanner scanner = new Scanner(System.in);
    short log = 0;
    do {
      imprime("Cadastrar pessoa candidata?");
      imprime("1 - Sim");
      imprime("2 - Não");
      imprime("Entre com o número correspondente à opção desejada:");
      log = scanner.nextShort();
      if (log == 1) {
        imprime("Entre com o nome da pessoa candidata:");
        String canditadoName = scanner.next();
        imprime("Entre com o número da pessoa candidata:");
        short candidatoNumero = scanner.nextShort();
        gerenciamento.cadastrarPessoaCandidata(canditadoName, candidatoNumero);
      } else if (log != 1 && log != 2) {
        imprime("Entre com uma opção válida!");
      }

    } while (log != 2);

    do {
      log = 0;
      imprime("Cadastrar pessoa eleitora?");
      imprime("1 - Sim");
      imprime("2 - Não");
      imprime("Entre com o número correspondente à opção desejada:");
      log = scanner.nextShort();
      if (log == 1) {
        imprime("Entre com o nome da pessoa eleitora:");
        String eleitorName = scanner.next();
        imprime("Entre com o cpf da pessoa eleitora:");
        String eleitorCpf = scanner.next();
        gerenciamento.cadastrarPessoaEleitora(eleitorName, eleitorCpf);
      } else if (log != 1 && log != 2) {
        imprime("Entre com uma opção válida!");
      }
    } while (log != 2);

    do {
      log = 0;
      imprime("Entre com o número correspondente à opção desejada:");
      imprime("1 - Votar");
      imprime("2 - Resultado Parcial");
      imprime("3 - Finalizar Votação");
      log = scanner.nextShort();
      if (log == 1) {
        imprime("Entre com o cpf da pessoa eleitora:");
        String eleitorCpf = scanner.next();
        imprime("Entre com o número da pessoa candidata:");
        short candidatoNumero = scanner.nextShort();
        gerenciamento.votar(eleitorCpf, candidatoNumero);
      } else if (log == 2) {
        gerenciamento.mostrarResultado();
      } else if (log == 3) {
        gerenciamento.mostrarResultado();
      } else if (log != 1 && log != 2 && log != 3) {
        imprime("Entre com uma opção válida!");
      }
    } while (log != 3);

    scanner.close();
  }

  static void imprime(String mensagem) {
    System.out.println(mensagem);
  }
}
