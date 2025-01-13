package com.example.MarketplaceCalculation.Domain.Dto;

import com.example.MarketplaceCalculation.Domain.Entity.Enum.Marketplaces;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CalculationRequest {


    public CalculationRequest(CalculationDto calculationDto) {
        this.marketplaceNome = calculationDto.marketplaceNome();
        this.custoProduto = calculationDto.custoProduto();
        this.precoVenda = calculationDto.precoVenda();
        this.promocaoVenda = calculationDto.promocaoVenda();
        this.taxaFixa = calculationDto.taxaFixa();
        this.marketplaceTaxa = calculationDto.marketplaceTaxa();
        this.notaFiscalTaxa = calculationDto.notaFiscalTaxa();
        this.pesoProduto = calculationDto.pesoProduto();
    }


    private Marketplaces marketplaceNome;

    private double custoProduto;

    private double precoVenda;

    private double promocaoVenda;

    private double taxaFixa;

    private double marketplaceTaxa;

    private double notaFiscalTaxa;

    private double pesoProduto;


}






