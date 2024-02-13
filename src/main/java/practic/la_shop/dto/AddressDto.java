package practic.la_shop.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import practic.la_shop.models.Address;
import practic.la_shop.models.Orders;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDto {

    private long id;
    private String address;
    private long accountId;
    private List<Long> ordersList;

    public static AddressDto from(Address address) {

        return AddressDto.builder()
                .id(address.getId())
                .address(address.getAddress())
                .accountId(address.getAccountId().getId())
                .ordersList(address.getOrders().stream().map(Orders::getId).toList())
                .build();
    }

    public static List<AddressDto> from(List<Address> addresses) {
        return addresses.stream().map(AddressDto::from).toList();
    }

}
