package practic.la_shop.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductOnly {

    private ProductDto chosenProduct;

    private List<ProductDto> relatedProducts;
}
