package estacionamento.entidades;

import estacionamento.enums.TipoVeiculo;

public class Motos extends Veiculos {

    public Motos(String placa, String modelo) {
        super(placa, modelo, TipoVeiculo.MOTO);
    }
}
