package practic.la_shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import practic.la_shop.models.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {

}
