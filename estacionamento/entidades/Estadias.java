package estacionamento.entidades;

import estacionamento.interfaces.Tarifavel;

import java.time.Duration;
import java.time.LocalDateTime;

public class Estadias implements Tarifavel {

    private Veiculos veiculo;
    private Vagas vaga;
    private LocalDateTime entrada;
    private LocalDateTime saida;

    public Estadias(Veiculos veiculo, Vagas vaga) {
        this.veiculo = veiculo;
        this.vaga = vaga;
        this.entrada = LocalDateTime.now();
    }

    public void registrarSaida() {
        this.saida = LocalDateTime.now();
        vaga.liberar();
    }

    @Override
    public double calcularTarifa() {
        Duration duracao = Duration.between(entrada, saida);
        long horas = Math.max(1, duracao.toHours());

        if (veiculo.getTipo().name().equals("CARRO")) {
            return horas * 5.0;
        } else {
            return horas * 3.0;
        }
    }

    public Veiculos getVeiculos() {
        return veiculo;
    }

    public Vagas getVagas() {
        return vaga;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public LocalDateTime getSaida() {
        return saida;
    }
}
