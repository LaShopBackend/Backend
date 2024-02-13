package practic.la_shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import practic.la_shop.models.Ordered;

public interface OrderedRepository extends JpaRepository<Ordered, Long> {

}
