package estacionamento.entidades;

import estacionamento.enums.TipoVeiculo;

public class Carros extends Veiculos {

    public Carros(String placa, String modelo) {
            super(placa, modelo, TipoVeiculo.CARRO);
    }
}