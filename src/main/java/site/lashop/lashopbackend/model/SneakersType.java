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
    Long Id;
    @ManyToOne
    Category category;

    String brand;
    String model;
    //List<String> images;
    String color;
    int price;
    String description;
}

