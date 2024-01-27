package site.lashop.lashopbackend.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import site.lashop.lashopbackend.model.Item;

@Repository
public interface ItemRepo extends CrudRepository<Item, Long> {
}
