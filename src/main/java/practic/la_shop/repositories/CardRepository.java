package practic.la_shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import practic.la_shop.models.Card;

public interface CardRepository extends JpaRepository<Card, Long> {

}
