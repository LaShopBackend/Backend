package site.lashop.lashopbackend.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import site.lashop.lashopbackend.model.Category;


@Repository
public interface CategoryRepo extends CrudRepository<Category, Long> {
}
