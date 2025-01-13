package com.example.MarketplaceCalculation.Domain.Entity.Enum;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum MarketplacesNomes {

    MERCADOLIVRE;
   // SHOPEE, // coming soon
   // MAGALU;  // coming soon


    @JsonCreator
    public static MarketplacesNomes fromString(String value) {
        for (MarketplacesNomes nomeMarketplace : MarketplacesNomes.values()) {
            if (nomeMarketplace.name().equalsIgnoreCase(value)) {
                return nomeMarketplace;
            }
        }
        throw new IllegalArgumentException("Marketplace inválido: " + value);
    }

}

