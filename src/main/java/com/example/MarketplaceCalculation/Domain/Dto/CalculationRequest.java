package com.example.MarketplaceCalculation.Domain.Dto;

import com.example.MarketplaceCalculation.Domain.Entity.Enum.MarketplacesNomes;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CalculationRequest {


    public CalculationRequest(CalculationDto calculationDto) {
        this.marketplaceNome = calculationDto.marketplaceNome();
        this.regiao = calculationDto.regiao();
        this.tipoEnvio = calculationDto.tipoEnvio();
        this.reputacao = calculationDto.reputacao();
        this.custoProduto = calculationDto.custoProduto();
        this.precoVenda = calculationDto.precoVenda();
        this.promocaoVenda = calculationDto.promocaoVenda();
        this.taxaFixa = calculationDto.taxaFixa();
        this.marketplaceTaxa = calculationDto.marketplaceTaxa();
        this.notaFiscalTaxa = calculationDto.notaFiscalTaxa();
        this.pesoProduto = calculationDto.pesoProduto();
    }


    private MarketplacesNomes marketplaceNome;


    private int regiao;

    private int reputacao;

    private int tipoEnvio;

    private double custoProduto;

    private double precoVenda;

    private double promocaoVenda;

    private double taxaFixa;

    private double marketplaceTaxa;

    private double notaFiscalTaxa;

    private double pesoProduto;


}






