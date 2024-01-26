package site.lashop.lashopbackend.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import site.lashop.lashopbackend.model.Size;

@Repository
public interface SizeRepo extends CrudRepository<Size, Long> {
}
