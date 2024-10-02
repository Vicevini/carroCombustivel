package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@Entity
@Data
public class Abastecimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "carro_id")
    private Carro carro;

    private BigDecimal kmAtual;
    private LocalDate dataAbastecimento;
    private String combustivel;
    private BigDecimal litrosAbastecidos;
    private BigDecimal precoTotal;
    private BigDecimal precoPorLitro;
    private BigDecimal consumoMedio;

    @PrePersist
    public void calcularPrecoPorLitro() {
    this.precoPorLitro = precoTotal.divide(litrosAbastecidos, 2, RoundingMode.HALF_UP);
}

}
