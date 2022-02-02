package monprojet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import monprojet.entity.Country;

// This will be AUTO IMPLEMENTED by Spring 

public interface CountryRepository extends JpaRepository<Country, Integer> {
        /**
         * Calcule les population du pays
         * 
         * @param id id du pays
         * @return population
         */
        @Query(value = "SELECT SUM(population)"
                        + "FROM City "
                        + "WHERE country_id = :id ", nativeQuery = true)
        public Integer getPopulation(Integer id);

        // Une méthode sans paramètre, qui renvoie une liste (nom du pays, population)
        @Query(value = "SELECT country.name, SUM(city.population) as population "
                        + "FROM Country "
                        + "INNER JOIN City ON Country.id = City.country_id "
                        + "GROUP BY country.name", nativeQuery = true)
        public List<VillePopulation> countryList();

}
