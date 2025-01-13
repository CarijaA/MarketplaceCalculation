package com.example.MarketplaceCalculation.Domain.Entity;


import com.example.MarketplaceCalculation.Domain.Entity.Enum.MarketplacesNomes;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;


@Entity
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Marketplaces {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @NotNull
    MarketplacesNomes marketplaceNome;
    @NotNull
    Double custoProduto;

    @NotNull
    Double precoVenda;

    @NotNull
    Double precoFrete;


}
