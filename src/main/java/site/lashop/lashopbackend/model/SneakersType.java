package site.lashop.lashopbackend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
public class SneakersType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long sneakersTypeId;
    @ManyToOne
    Category category;

    String brand;
    String model;
    String imageUrl;
    String color;
}

