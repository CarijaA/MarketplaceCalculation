package com.example.MarketplaceCalculation.Domain.Dto;

import com.example.MarketplaceCalculation.Domain.Entity.Enum.MarketplacesNomes;
import jakarta.validation.constraints.NotNull;

public record CalculationDto(
        MarketplacesNomes marketplaceNome,
        @NotNull int reputacao, // 1- Verde, 2- Amarelo, 3- Vermelho
        @NotNull int regiao, // 1- Sudeste, 2- Demais
        @NotNull int tipoEnvio, // 1- Full, 2- Outros
        @NotNull double custoProduto,
        @NotNull double precoVenda,
        @NotNull double promocaoVenda,
        @NotNull double taxaFixa,
        @NotNull double marketplaceTaxa,
        @NotNull double notaFiscalTaxa,
        @NotNull double pesoProduto
) {
}
