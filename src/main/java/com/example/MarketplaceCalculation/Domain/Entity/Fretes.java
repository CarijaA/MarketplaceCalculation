package com.example.MarketplaceCalculation.Domain.Entity;


import com.example.MarketplaceCalculation.Domain.Dto.CalculationDto;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "tabela_frete")
public class Fretes {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "peso_min", nullable = false)
    private Double pesoMin;

    @Column(name = "peso_max")
    private Double pesoMax;

    @Column(name = "valor_full", nullable = false)
    private Double valorFull;

    @Column(name = "valor_outros", nullable = false)
    private Double valorOutros;
}
