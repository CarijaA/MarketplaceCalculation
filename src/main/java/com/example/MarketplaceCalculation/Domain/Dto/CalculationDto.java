package com.example.MarketplaceCalculation.Domain.Dto;

import com.example.MarketplaceCalculation.Domain.Entity.Enum.MarketplacesNomes;
import jakarta.validation.constraints.NotNull;

public record CalculationDto(MarketplacesNomes marketplaceNome,
                             @NotNull int  tipoVendedor,
                             @NotNull int regiao,
                             @NotNull int  tipoEnvio,
                             @NotNull double custoProduto,
                             @NotNull double precoVenda,
                             @NotNull double promocaoVenda,
                             @NotNull double precoVendaLiquida,
                             @NotNull double taxaFixa, // produtos abaixo de 79,00 pagam R$6,00
                             @NotNull double marketplaceTaxa,
                             @NotNull double notaFiscalTaxa,
                             @NotNull double pesoProduto) {
}
