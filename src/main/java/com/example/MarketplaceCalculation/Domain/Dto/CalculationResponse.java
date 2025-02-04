package com.example.MarketplaceCalculation.Domain.Dto;


import com.example.MarketplaceCalculation.Domain.Entity.Enum.MarketplacesNomes;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonPropertyOrder({
        "marketplaceNome",
        "reputacao",
        "tipoEnvio",
        "regiao",
        "precoVenda",
        "promocaoVenda",
        "precoVendaLiquida",
        "custoProduto",
        "taxaFixa",
        "marketplaceTaxa",
        "notaFiscalTaxa",
        "valorFrete",
        "sobraTotal",
        "margemVenda",
        "margemCusto"
})
public class CalculationResponse {
    private MarketplacesNomes marketplaceNome;
    private int reputacao;
    private int tipoEnvio;
    private int regiao;
    private double custoProduto;
    private double precoVenda;
    private double promocaoVenda;
    private double precoVendaLiquida;
    private double taxaFixa;
    private double marketplaceTaxa;
    private double notaFiscalTaxa;
    private double valorFrete;
    private double sobraTotal;
    private double margemCusto;
    private double margemVenda;
}

