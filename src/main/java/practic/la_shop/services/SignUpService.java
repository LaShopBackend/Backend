package practic.la_shop.services;

import practic.la_shop.dto.AccountDto;
import practic.la_shop.models.Account;

import java.util.Optional;


// надо переделать под типо сервис авторизации
public interface SignUpService {

    void signUp(AccountDto accountDto);

    void changePassword(AccountDto accountDto, String password);

    void deleteAccount(AccountDto accountDto);

    Account getAccountById(long id);

    Optional<Account> validEmailAndPassword(String email, String password);


}
