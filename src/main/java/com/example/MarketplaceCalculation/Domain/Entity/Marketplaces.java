package com.example.MarketplaceCalculation.Domain.Entity;


import com.example.MarketplaceCalculation.Domain.Entity.Enum.MarketplacesNomes;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Marketplaces {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    int reputacao;

    MarketplacesNomes marketplaceNome;

    Double custoProduto;

    Double precoVenda;

    Double precoFrete;


}
