package estacionamento.entidades;

import estacionamento.enums.StatusVaga;

public class Vagas {

    private int numero;
    private StatusVaga status;

    public Vagas(int numero) {
        this.numero = numero;
        this.status = StatusVaga.LIVRE;
    }

    public int getNumero() {
        return numero;
    }

    public StatusVaga getStatus() {
        return status;
    }

    public void ocupar() {
        status = StatusVaga.OCUPADA;
    }

    public void liberar() {
        status = StatusVaga.LIVRE;
    }
}
