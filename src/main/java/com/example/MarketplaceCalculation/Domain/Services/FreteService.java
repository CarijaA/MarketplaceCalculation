package com.example.MarketplaceCalculation.Domain.Services;


import com.example.MarketplaceCalculation.Domain.Repository.FreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FreteService {


    @Autowired
    FreteRepository freteRepository;


    public double calcularFrete(double peso) {
        Double valorFrete = freteRepository.buscarFretePorPeso(peso);
        if (valorFrete == null) {
            throw new IllegalArgumentException("Peso fora dos limites suportados: " + peso);
        }
        return valorFrete;
    }


}
