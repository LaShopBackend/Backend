package site.lashop.lashopbackend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    String color;
    int price;
    String description;
    @ElementCollection
    List<String> images;
}

