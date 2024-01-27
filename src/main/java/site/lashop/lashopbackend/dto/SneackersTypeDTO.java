package site.lashop.lashopbackend.dto;

import site.lashop.lashopbackend.model.SneakersType;
public class SneackersTypeDTO {
    SneakersType sneakersType;
    String title = sneakersType.getBrand() + " " + sneakersType.getModel();

}
