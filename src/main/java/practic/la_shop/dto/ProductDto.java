package practic.la_shop.dto;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import practic.la_shop.models.Category;
import practic.la_shop.models.Product;
import practic.la_shop.models.SizesQuantity;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {

    private long id;
    private String brand;
    private String model;
    private long categoryId;
    private List<SizesQuantity> sizes;
    private String color;
    private boolean isSoldOut;

    public static ProductDto from(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .brand(product.getBrand())
                .model(product.getModel())
                .categoryId(product.getCategory().getId())
                .sizes(product.getSizesQuantities())
                .color(product.getColor())
                .isSoldOut(product.isSoldOut())
                .build();
    }

    public static List<ProductDto> from(List<Product> products) {
        return products.stream().map(ProductDto::from).toList();
    }

}
