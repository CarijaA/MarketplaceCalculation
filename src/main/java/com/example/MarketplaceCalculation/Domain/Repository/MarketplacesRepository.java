package com.example.MarketplaceCalculation.Domain.Repository;

import com.example.MarketplaceCalculation.Domain.Entity.MarketplaceMercadoLivre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MarketplacesRepository extends JpaRepository<MarketplaceMercadoLivre, Long> {
}
