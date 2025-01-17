package com.example.MarketplaceCalculation.Domain.Repository;

import com.example.MarketplaceCalculation.Domain.Entity.Fretes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FreteRepository extends JpaRepository<Fretes, Long> {

    @Query(value = "SELECT TOP 1 valor " +
            "FROM Fretes " +
            "WHERE :peso >= pesoMin " +
            "AND (:peso < pesoMax OR pesoMax = 9999.99) " +
            "AND reputacao = :reputacao " +
            "AND tipoEnvio = :tipoEnvio " +
            "AND regiao = :regiao " +
            "ORDER BY valor ASC", nativeQuery = true)
    Double buscarFretePorPesoReputacaoTipoEnvioERegiao(@Param("peso") Double peso,
                                                       @Param("reputacao") int reputacao,
                                                       @Param("tipoEnvio") int tipoEnvio,
                                                       @Param("regiao") int regiao);

}
