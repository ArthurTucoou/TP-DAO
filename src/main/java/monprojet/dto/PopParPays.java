package monprojet.dto;

import org.springframework.data.jpa.repository.JpaRepository;
import monprojet.entity.City;

public interface PopParPays {

    String getName();
    Integer getPopulation();


}
