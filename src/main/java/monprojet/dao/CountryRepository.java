package monprojet.dao;

import java.util.List;

import monprojet.dto.PopParPays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import monprojet.entity.City;
import monprojet.entity.Country;

// This will be AUTO IMPLEMENTED by Spring 

public interface CountryRepository extends JpaRepository<Country, Integer> {
    /**
     * Calculer la population totale d'un pays
     * @param countryID la clé du pays
     * @return la somme des populations des villes du pays
     */
    @Query("SELECT SUM(c.population) FROM City c WHERE c.country.id = :countryID")
    Integer popTotale(Integer countryID);

    /**
     * Calcule la population pour chaque pays
     * @param
     * @return la liste des pays avec leur population
     */
    @Query("SELECT c.country.name as nom, SUM(c.population) AS pop "
            + "FROM City c "
            + "GROUP BY nom ")
    List<PopParPays> populationParPays();
}
