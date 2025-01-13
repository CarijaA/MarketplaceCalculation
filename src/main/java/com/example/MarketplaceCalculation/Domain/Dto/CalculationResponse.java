package com.example.MarketplaceCalculation.Domain.Dto;


import com.example.MarketplaceCalculation.Domain.Entity.Enum.Marketplaces;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonPropertyOrder({
        "marketplaceNome",
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
    private Marketplaces marketplaceNome;

    private double custoProduto;

    private double precoVenda;

    private double promocaoVenda;

    private double precoVendaLiquida;

    private double taxaFixa;

    private double marketplaceTaxa;

    private double notaFiscalTaxa;

    private double ValorFrete;

    private double sobraTotal;

    private double MargemCusto;

    private double MargemVenda;



}
