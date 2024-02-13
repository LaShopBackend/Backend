package practic.la_shop.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import practic.la_shop.models.Account;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Account, Long> {

    Account findById(long id);

    Optional<Account> findByEmail(String email);

    void deleteAccountByEmail(String email);
    @Transactional
    default void changePassword(String email, String newPassword) {
        Account account = findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(String.format("user with email: %s not found", email)));
        if (account != null) {
            account.setPassword(newPassword);
            save(account);
        }
    }



}
