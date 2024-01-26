package site.lashop.lashopbackend.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import site.lashop.lashopbackend.model.SneakersType;

@Repository
public interface SneakersTypeRepo extends CrudRepository<SneakersType, Long> {
}
