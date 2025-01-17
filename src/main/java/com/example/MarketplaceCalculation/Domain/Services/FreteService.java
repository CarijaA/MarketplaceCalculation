package com.example.MarketplaceCalculation.Domain.Services;


import com.example.MarketplaceCalculation.Domain.Repository.FreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FreteService {

    @Autowired
    FreteRepository freteRepository;

    public Double calcularFrete(Double peso, int reputacao, int tipoEnvio, int regiao) {
        Double valorFrete = freteRepository.buscarFretePorPesoReputacaoTipoEnvioERegiao(peso, reputacao, tipoEnvio, regiao);

        return valorFrete;
    }

}