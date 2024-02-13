package practic.la_shop.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import practic.la_shop.models.Account;
import practic.la_shop.repositories.UserRepository;


@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(String.format("user with email: %s not found", email)));
        return new AccountUserDetails(account);
    }
}
