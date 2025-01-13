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

        double custoProduto = calculationDto.custoProduto();
        double precoVenda = calculationDto.precoVenda();
        double promocaoVenda = calculationDto.promocaoVenda();
        double precoVendaLiquida = precoVenda - ((precoVenda * promocaoVenda) / 100);
        double taxaFixaBase = calculationDto.taxaFixa();
        // double taxaFixa = (precoVendaLiquida <= 79) ? taxaFixaBase : 0.00; ------ Melhoria Futura
        double taxaFixa;

        if (precoVendaLiquida <= 29) {
            taxaFixa = 6.25;
        } else if (precoVendaLiquida <= 50) {
            taxaFixa = 6.50;
        } else if (precoVendaLiquida <= 79) {
            taxaFixa = 6.75;
        } else {
            taxaFixa = 0.0; // Para valores acima de 79, sem custo fixo
        }
        double taxaMarketplace = calculationDto.marketplaceTaxa();
        double taxaNotaFiscal = (calculationDto.notaFiscalTaxa() * precoVendaLiquida) / 100;
        double valorFrete = (precoVendaLiquida >= 79) ? freteService.calcularFrete(calculationDto.pesoProduto()) : 0.00;
        double sobraTotal = precoVendaLiquida - custoProduto - taxaMarketplace - taxaFixa - taxaNotaFiscal - valorFrete;
        double margemCusto = (sobraTotal / custoProduto) * 100;
        double margemVenda = (sobraTotal / precoVendaLiquida) * 100;

        CalculationResponse response = new CalculationResponse();
        response.setMarketplaceNome(calculationDto.marketplaceNome());
        response.setCustoProduto(calculationDto.custoProduto());
        response.setPrecoVenda(precoVenda);
        response.setPromocaoVenda(promocaoVenda);
        response.setTaxaFixa(taxaFixa);
        response.setMarketplaceTaxa(taxaMarketplace);
        response.setNotaFiscalTaxa(taxaNotaFiscal);
        response.setPrecoVendaLiquida(precoVendaLiquida);
        response.setValorFrete(valorFrete);  // todos anúncios acima de 79 oferecem frete grátis
        response.setSobraTotal(sobraTotal);
        response.setMargemCusto(margemCusto);
        response.setMargemVenda(margemVenda);
        return response;

    }

}
