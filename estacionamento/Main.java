package estacionamento;

import estacionamento.entidades.*;
import estacionamento.enums.StatusVaga;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Vagas> vagas = new ArrayList<>();
    private static List<Estadias> estadiasAtivas = new ArrayList<>();
    private static List<Recibos> historicoRecibos = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= 5; i++) {
            vagas.add(new Vagas(i));
        }

        int opcao;

        do {
            System.out.println("\n=== SISTEMA DE ESTACIONAMENTO ===");
            System.out.println("1 - Registrar entrada de veículo");
            System.out.println("2 - Registrar saída de veículo");
            System.out.println("3 - Listar vagas");
            System.out.println("4 - Listar veículos estacionados");
            System.out.println("5 - Listar recibos");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> registrarEntrada(sc);
                case 2 -> registrarSaida(sc);
                case 3 -> listarVagas();
                case 4 -> listarEstadias();
                case 5 -> listarRecibos();
                case 0 -> System.out.println("Encerrando sistema...");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }

    // ENTRADA
    private static void registrarEntrada(Scanner sc) {
        if (buscarVagaLivre() == null) {
            System.out.println("Não há vagas disponíveis.");
            return;
        }

        System.out.print("Placa do veículo: ");
        String placa = sc.nextLine();

        System.out.print("Modelo do veículo: ");
        String modelo = sc.nextLine();

        System.out.print("Tipo (1-Carro / 2-Moto): ");
        int tipo = sc.nextInt();
        sc.nextLine();

        Veiculos veiculo;
        if (tipo == 1) {
            veiculo = new Carros(placa, modelo);
        } else {
            veiculo = new Motos(placa, modelo);
        }

        Vagas vaga = buscarVagaLivre();
        vaga.ocupar();

        Estadias estadia = new Estadias(veiculo, vaga);
        estadiasAtivas.add(estadia);

        System.out.println("Veículo estacionado na vaga " + vaga.getNumero());
    }

    // SAÍDA
    private static void registrarSaida(Scanner sc) {
        System.out.print("Informe a placa do veículo: ");
        String placa = sc.nextLine();

        Estadias estadia = buscarEstadiaPorPlaca(placa);

        if (estadia == null) {
            System.out.println("Veículo não encontrado.");
            return;
        }

        estadia.registrarSaida();
        double valor = estadia.calcularTarifa();

        Recibos recibo = new Recibos(
                placa,
                estadia.getEntrada(),
                estadia.getSaida(),
                valor
        );

        historicoRecibos.add(recibo);
        estadiasAtivas.remove(estadia);

        System.out.println("\n=== RECIBO ===");
        System.out.println("Placa: " + recibo.placa());
        System.out.println("Entrada: " + recibo.entrada());
        System.out.println("Saída: " + recibo.saida());
        System.out.println("Valor pago: R$ " + recibo.valor());
    }

    // LISTAGENS
    private static void listarVagas() {
        System.out.println("\nVagas:");
        for (Vagas vaga : vagas) {
            System.out.println("Vaga " + vaga.getNumero() + " - " + vaga.getStatus());
        }
    }

    private static void listarEstadias() {
        System.out.println("\nVeículos estacionados:");
        for (Estadias e : estadiasAtivas) {
            System.out.println(
                    "Placa: " + e.getVeiculos().getPlaca() +
                            " | Modelo: " + e.getVeiculos().getModelo() +
                            " | Vaga: " + e.getVagas().getNumero() +
                            " | Entrada: " + e.getEntrada()
            );
        }
    }

    private static void listarRecibos() {
        System.out.println("\nRecibos:");
        for (Recibos r : historicoRecibos) {
            System.out.println(
                    "Placa: " + r.placa() +
                            " | Valor: R$ " + r.valor() +
                            " | Saída: " + r.saida()
            );
        }
    }

    // AUXILIARES
    private static Vagas buscarVagaLivre() {
        for (Vagas vaga : vagas) {
            if (vaga.getStatus() == StatusVaga.LIVRE) {
                return vaga;
            }
        }
        return null;
    }

    private static Estadias buscarEstadiaPorPlaca(String placa) {
        for (Estadias e : estadiasAtivas) {
            if (e.getVeiculos().getPlaca().equalsIgnoreCase(placa)) {
                return e;
            }
        }
        return null;
    }
}
