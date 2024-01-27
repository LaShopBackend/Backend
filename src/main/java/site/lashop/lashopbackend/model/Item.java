package site.lashop.lashopbackend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long Id;
    @ManyToOne
    SneakersType sneakersType;

    double sizeUs;
}
