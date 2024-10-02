
package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.AbastecimentoRepository;
import com.example.demo.repository.CarroRepository;
import com.example.demo.model.Abastecimento;
import com.example.demo.model.Carro;


import java.math.BigDecimal;
import java.time.LocalDate;


@Service
public class AbastecimentoService {

    @Autowired
    AbastecimentoRepository abastecimentoRepository;

    @Autowired
    private CarroRepository carroRepository;

    public Abastecimento registrarAbastecimento(Long carroId, BigDecimal kmAtual, BigDecimal litrosAbastecidos, BigDecimal precoTotal, String combustivel, LocalDate dataAbastecimento) {
        Carro carro = carroRepository.findById(carroId).orElseThrow(() -> new RuntimeException("Carro não encontrado"));

        Abastecimento ultimoAbastecimento = abastecimentoRepository.findFirstByCarroOrderByDataAbastecimentoDesc(carro);
        BigDecimal consumoMedio = null;

        if (ultimoAbastecimento != null) {
            BigDecimal kmAnterior = ultimoAbastecimento.getKmAtual();
            BigDecimal kmPercorrida = kmAtual.subtract(kmAnterior);
            consumoMedio = kmPercorrida.divide(litrosAbastecidos, 2, BigDecimal.ROUND_HALF_UP);
        }

        Abastecimento abastecimento = new Abastecimento();
        abastecimento.setCarro(carro);
        abastecimento.setKmAtual(kmAtual);
        abastecimento.setLitrosAbastecidos(litrosAbastecidos);
        abastecimento.setPrecoTotal(precoTotal);
        abastecimento.setCombustivel(combustivel);
        abastecimento.setConsumoMedio(consumoMedio);
        abastecimento.setDataAbastecimento(dataAbastecimento);


        return abastecimentoRepository.save(abastecimento);
    }
}
