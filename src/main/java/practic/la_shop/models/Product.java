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
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String brand;

    private String model;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

//    @ElementCollection
//    private List<SizesQuantity> sizes;

    @OneToMany(mappedBy = "product")
    private List<SizesQuantity> sizesQuantities;

    private String color;

    @Column(name = "is_sold_out")
    private boolean isSoldOut;
}
