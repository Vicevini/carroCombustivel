// Carro.java
package com.example.demo.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
}
