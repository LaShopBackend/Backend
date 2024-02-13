package practic.la_shop.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import practic.la_shop.models.Account;
import practic.la_shop.models.Cart;
import practic.la_shop.models.Product;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {

    // метод вернет все строки которые лежат у пользователя в корзине
    List<Cart> findByAccountId(long accountId);

    Optional<Cart> findByProductIdAndAccountIdAndSize(long productId, long accountId, double size);

    // функция прибавляет количество у товара в корзине
    @Transactional
    default void plusQuantity(long accountId, long productId, double size) {
        Optional<Cart> position = findByProductIdAndAccountIdAndSize(productId, accountId, size);

        position.ifPresent(cart -> {
            cart.setQuantity(cart.getQuantity() + 1);
            save(cart);
        });

        int i = 0;
    }

    // функция уменьшает количество у товара в корзине
    @Transactional
    default void minusQuantity(long accountId, long productId, double size) {
        Optional<Cart> position = findByProductIdAndAccountIdAndSize(productId, accountId, size);

        position.ifPresent(cart -> {
            int quantity = cart.getQuantity() - 1;
            if (quantity > 0) {
                cart.setQuantity(quantity);
                save(cart);
            } else {
                delete(cart);
            }
        });

        int i = 0;
    }

    void deleteById(long id);

    @Transactional
    void deleteByProductIdAndAccountIdAndSize(long productId, long accountId, double size);
}
