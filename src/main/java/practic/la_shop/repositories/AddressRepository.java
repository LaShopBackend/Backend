package practic.la_shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import practic.la_shop.models.Address;


// задается тип модели и тип первичного ключа
public interface AddressRepository extends JpaRepository<Address, Long> {


}
