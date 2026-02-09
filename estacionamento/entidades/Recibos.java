package estacionamento.entidades;

import java.time.LocalDateTime;

public record Recibos(
        String placa,
        LocalDateTime entrada,
        LocalDateTime saida,
        double valor
) {}
