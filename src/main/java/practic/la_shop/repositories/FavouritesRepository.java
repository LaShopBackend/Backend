package practic.la_shop.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import practic.la_shop.models.Favourites;
import practic.la_shop.models.Product;

import java.util.List;
import java.util.Optional;

public interface FavouritesRepository extends JpaRepository<Favourites, Long> {

    @Query("SELECT f.product FROM Favourites f WHERE f.account.id = :accountId")
    List<Product> findProductsByAccountId(@Param("accountId") long accountId);

    @Transactional
    void deleteByAccountIdAndProductId(long userId, long productId);

    Optional<Favourites> findByAccountIdAndProductId(long userId, long productId);
}
