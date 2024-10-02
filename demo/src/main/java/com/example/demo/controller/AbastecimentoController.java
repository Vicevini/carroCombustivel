package com.example.demo.controller;
import com.example.demo.model.Abastecimento;
import com.example.demo.model.Carro;
import com.example.demo.repository.AbastecimentoRepository;
import com.example.demo.repository.CarroRepository;
import com.example.demo.service.AbastecimentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@RestController
@RequestMapping("/api/abastecimentos")
public class AbastecimentoController {

    @Autowired
    private AbastecimentoService abastecimentoService;

    @PostMapping
    public Abastecimento registrarAbastecimento(
            @RequestParam Long carroId,
            @RequestParam BigDecimal kmAtual,
            @RequestParam BigDecimal litrosAbastecidos,
            @RequestParam BigDecimal precoTotal,
            @RequestParam String combustivel,
            @RequestParam LocalDate dataAbastecimento) {

        return abastecimentoService.registrarAbastecimento(carroId, kmAtual, litrosAbastecidos, precoTotal, combustivel, dataAbastecimento );
    }
}
