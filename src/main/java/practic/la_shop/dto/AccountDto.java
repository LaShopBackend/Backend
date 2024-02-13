package practic.la_shop.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import practic.la_shop.models.Address;
import practic.la_shop.models.Card;
import practic.la_shop.models.Orders;
import practic.la_shop.models.Account;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private int personalSale;
    private String role;
    private String accountState;
    private List<Long> addresses;
    private List<Long> cards;
    private List<Long> orders;

    public static AccountDto from(Account account) {
        return AccountDto.builder()
                .id(account.getId())
                .firstName(account.getFirstName())
                .lastName(account.getLastName())
                .email(account.getEmail())
                .phoneNumber(account.getPhoneNumber())
                .password(account.getPassword())
                .personalSale(account.getPersonalSale())
                .role(account.getRole().name())
                .accountState(account.getAccountState().name())
                .addresses(account.getAddresses().stream().map(Address::getId).toList())
                .cards(account.getCards().stream().map(Card::getId).toList())
                .orders(account.getOrders().stream().map(Orders::getId).toList())
                .build();
    }

    public static List<AccountDto> from(List<Account> accounts) {
        return accounts.stream().map(AccountDto::from).toList();
    }
}
