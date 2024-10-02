package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Abastecimento;
import com.example.demo.model.Carro;


public interface AbastecimentoRepository extends JpaRepository<Abastecimento, Long> {
    Abastecimento findFirstByCarroOrderByDataAbastecimentoDesc(Carro carros);
}
