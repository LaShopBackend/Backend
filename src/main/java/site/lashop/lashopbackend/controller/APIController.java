package site.lashop.lashopbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import site.lashop.lashopbackend.dto.SneakersTypeDTO;
import site.lashop.lashopbackend.mapper.SneakersTypeMapper;
import site.lashop.lashopbackend.model.Category;
import site.lashop.lashopbackend.model.SneakersType;
import site.lashop.lashopbackend.service.CategoryService;
import site.lashop.lashopbackend.service.ItemService;
import site.lashop.lashopbackend.service.SneakersTypeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class APIController {

    private final SneakersTypeService sneakersTypeService;
    private final ItemService itemService;
    private final CategoryService categoryService;
    private final SneakersTypeMapper sneakersTypeMapper;

    @GetMapping("/api/models")
    public Iterable<SneakersTypeDTO> getModels() {

        SneakersType sneakersType = new SneakersType();
        sneakersType.setBrand("New Balance");
        sneakersType.setModel("530");
        sneakersType.setDescription("Топ за свои деньги");
        sneakersType.setImages(List.of("https://main-cdn.sbermegamarket.ru/hlr-system/963/692/005/615/355/600012504434b0.jpeg"));
        sneakersType.setColor("Blue");
        sneakersType.setPrice(1000);
        Category category = new Category();
        category.setDisplayName("Sneakers");
        category.setDescription("фифифифифиффиифиdjclillaudhs");
        categoryService.saveCategory(category);
        sneakersType.setCategory(category);
        sneakersTypeService.saveSneakersType(sneakersType);
        return List.of(sneakersTypeMapper.toDTO(sneakersType));
    }


//    @GetMapping("/api/items")
//    public Iterable<ItemDTO> getItems() {
//        Item krossovkaSabina = new Item(sneakersType, new Size(1, 2, 3, 4, 5));*/
//        SneakersType sneakersType = new SneakersType();
//        sneakersType.setBrand("New Balance");
//        sneakersType.setModel("530");
//        sneakersType.setImages(List.of("https://main-cdn.sbermegamarket.ru/hlr-system/963/692/005/615/355/600012504434b0.jpeg"));
//        sneakersType.setColor("Blue");
//        Category category = new Category();
//        category.setDisplayName("Sneakers");
//        category.setDescription("фифифифифиффиифиdjclillaudhs");
//        categoryService.saveCategory(category);
//        sneakersType.setCategory(category);
//        Item item = new Item();
//        item.setSneakersType(sneakersType);
//        item.setSizeUs(10);
//        sneakersTypeService.saveSneakersType(sneakersType);
//        itemService.saveItem(item);
//        return  List.of(item);
//    }
}
