package com.example.MarketplaceCalculation.Domain.Entity.Enum;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Marketplaces {

    MERCADOLIVRE;
   // SHOPEE, // coming soon
   // MAGALU;  // coming soon


    @JsonCreator
    public static Marketplaces fromString(String value) {
        for (Marketplaces nomeMarketplace : Marketplaces.values()) {
            if (nomeMarketplace.name().equalsIgnoreCase(value)) {
                return nomeMarketplace;
            }
        }
        throw new IllegalArgumentException("Marketplace inválido: " + value);
    }

}

