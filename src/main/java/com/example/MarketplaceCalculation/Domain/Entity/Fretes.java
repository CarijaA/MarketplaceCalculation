package com.example.MarketplaceCalculation.Domain.Entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class Fretes {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "valor", nullable = false)
        private Double valor;

        @Column(name = "regiao", nullable = false)
        private int regiao; // Exemplo: "Sul/Sudeste" = 1 ou "Restante do País" = 2

        @Column(name = "pesomin", nullable = false)
        private Double pesoMin;

        @Column(name = "pesomax", nullable = false)
        private Double pesoMax;

        @Column(name = "tipoenvio", nullable = false)
        private int tipoEnvio; // Exemplo: "Full" = 1 ou "Outros" = 2

        @Column (name = "reputacao", nullable = false)
        private int reputacao; // Exemplo: "Verde" = 1 , "Amarela" = 2 e "Vermelha" = 3
}
