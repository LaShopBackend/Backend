package site.lashop.lashopbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
public class SneakersType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long sneakersTypeId;

    String brand;
    String model;
    String imageUrl;
    String color;
}

