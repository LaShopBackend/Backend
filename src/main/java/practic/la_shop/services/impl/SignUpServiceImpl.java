package practic.la_shop.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import practic.la_shop.dto.AccountDto;
import practic.la_shop.models.Account;
import practic.la_shop.repositories.UserRepository;
import practic.la_shop.services.SignUpService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Account getAccountById(long id) {
        return userRepository.findById(id);
    }



    @Override
    public Optional<Account> validEmailAndPassword(String email, String password) {
        return userRepository.findByEmail(email).filter(user -> passwordEncoder.matches(password, user.getPassword()));
    }

    @Override
    public void signUp(AccountDto accountDto) {
        Account account = Account.builder()
                .firstName(accountDto.getFirstName())
                .lastName(accountDto.getLastName())
                .email(accountDto.getEmail())
                .password(passwordEncoder.encode(accountDto.getPassword()))
                .phoneNumber(accountDto.getPhoneNumber())
                .personalSale(accountDto.getPersonalSale())
                .role(Account.Role.valueOf(accountDto.getRole()))
                .accountState(Account.State.valueOf(accountDto.getAccountState()))
                .build();

        userRepository.save(account);
    }

    @Override
    public void changePassword(AccountDto accountDto, String password) {

        if (accountDto != null)
        // TODO{здесь приебенить пасворд енкодер, когда подрубим security}
            userRepository.changePassword(accountDto.getEmail(), password);
    }

    @Override
    public void deleteAccount(AccountDto accountDto) {
        if (accountDto != null && accountDto.getEmail() != null)
            userRepository.deleteAccountByEmail(accountDto.getEmail());
    }

    public boolean hasUserWithEmail(String email) {
        Optional<Account> account = userRepository.findByEmail(email);
        return account.isPresent();
    }
}
