package com.example.MarketplaceCalculation.Domain.Repository;

import com.example.MarketplaceCalculation.Domain.Entity.Marketplaces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MarketplacesRepository extends JpaRepository<Marketplaces, Long> {
}
