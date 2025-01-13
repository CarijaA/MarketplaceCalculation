package com.example.MarketplaceCalculation.Domain.Repository;

import com.example.MarketplaceCalculation.Domain.Entity.Fretes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FreteRepository extends JpaRepository<Fretes, Long> {


    @Query("SELECT f.valorFull FROM Fretes f WHERE :peso >= f.pesoMin AND (:peso < f.pesoMax OR f.pesoMax IS NULL)")
    Double buscarFretePorPeso(@Param("peso") Double peso);
}
