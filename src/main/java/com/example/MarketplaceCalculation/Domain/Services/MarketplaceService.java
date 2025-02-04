package com.example.MarketplaceCalculation.Domain.Services;

import com.example.MarketplaceCalculation.Domain.Dto.CalculationDto;
import com.example.MarketplaceCalculation.Domain.Dto.CalculationResponse;
import com.example.MarketplaceCalculation.Domain.Entity.Marketplaces;
import com.example.MarketplaceCalculation.Domain.Repository.MarketplacesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketplaceService {

    @Autowired
    MarketplacesRepository marketplacesRepository;

    @Autowired
    FreteService freteService;

    public void saveMarketplace(Marketplaces marketplaceCalculation) {
        marketplacesRepository.save(marketplaceCalculation);
    }

    public CalculationResponse calculationFee(CalculationDto calculationDto) {

        if (calculationDto.custoProduto() < 0 || calculationDto.precoVenda() < 0) {
            throw new IllegalArgumentException("Valores negativos não são permitidos");
        }

        double custoProduto = calculationDto.custoProduto();
        double precoVenda = calculationDto.precoVenda();
        double promocaoVenda = calculationDto.promocaoVenda();
        double precoVendaLiquida = precoVenda - ((precoVenda * promocaoVenda) / 100);
        double taxaFixa = calcularTaxaFixa(precoVendaLiquida);
        double taxaMarketplace = calculationDto.marketplaceTaxa();
        double taxaNotaFiscal = (calculationDto.notaFiscalTaxa() * precoVendaLiquida) / 100;
        double valorFrete = freteService.calcularFrete(calculationDto.pesoProduto(), calculationDto.reputacao(),
                calculationDto.tipoEnvio(), calculationDto.regiao());
        double sobraTotal = precoVendaLiquida - custoProduto - taxaMarketplace - taxaFixa - taxaNotaFiscal - valorFrete;
        double margemCusto = (sobraTotal / custoProduto) * 100;
        double margemVenda = (sobraTotal / precoVendaLiquida) * 100;

        // Monta a resposta
        CalculationResponse response = new CalculationResponse();
        response.setMarketplaceNome(calculationDto.marketplaceNome());
        response.setCustoProduto(custoProduto);
        response.setPrecoVenda(precoVenda);
        response.setPromocaoVenda(promocaoVenda);
        response.setTaxaFixa(taxaFixa);
        response.setMarketplaceTaxa(taxaMarketplace);
        response.setNotaFiscalTaxa(taxaNotaFiscal);
        response.setPrecoVendaLiquida(precoVendaLiquida);
        response.setValorFrete(valorFrete);
        response.setSobraTotal(sobraTotal);
        response.setMargemCusto(margemCusto);
        response.setMargemVenda(margemVenda);
        response.setReputacao(calculationDto.reputacao());
        response.setTipoEnvio(calculationDto.tipoEnvio());
        response.setRegiao(calculationDto.regiao());

        return response;
    }

    public double calcularTaxaFixa(double precoVendaLiquida) {
        if (precoVendaLiquida <= 29) {
            return 6.25;
        } else if (precoVendaLiquida <= 50) {
            return 6.50;
        } else if (precoVendaLiquida <= 79) {
            return 6.75;
        } else {
            return 0.00;
        }
    }
}
