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
        // Dados iniciais
        double custoProduto = calculationDto.custoProduto();
        double precoVenda = calculationDto.precoVenda();
        double promocaoVenda = calculationDto.promocaoVenda();

        // Calcula o preço de venda líquida
        double precoVendaLiquida = precoVenda - ((precoVenda * promocaoVenda) / 100);

        // Calcula a taxa fixa
        double taxaFixa = calcularTaxaFixa(precoVendaLiquida);

        // Outras taxas
        double taxaMarketplace = calculationDto.marketplaceTaxa();
        double taxaNotaFiscal = (calculationDto.notaFiscalTaxa() * precoVendaLiquida) / 100;

        // Cálculo do frete
        int reputacao = calculationDto.tipoVendedor();
        int tipoEnvio = calculationDto.tipoEnvio();
        double valorFrete = freteService.calcularFrete(calculationDto.pesoProduto(), reputacao, tipoEnvio, calculationDto.regiao());

        // Calcula a sobra total e as margens
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
        response.setTipoVendedor(reputacao);

        return response;
    }

    private double calcularTaxaFixa(double precoVendaLiquida) {
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
