package practic.la_shop.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String address;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account accountId;

    @OneToMany(mappedBy = "address")
    private List<Orders> orders;
}
