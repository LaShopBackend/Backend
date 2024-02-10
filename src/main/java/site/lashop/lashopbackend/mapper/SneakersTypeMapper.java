package site.lashop.lashopbackend.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import site.lashop.lashopbackend.dto.SneakersTypeDTO;
import site.lashop.lashopbackend.model.SneakersType;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class SneakersTypeMapper {

    private final CategoryMapper categoryMapper;

    public SneakersTypeDTO toDTO(SneakersType sneakersType) {
        return new SneakersTypeDTO(
                sneakersType.getId(),
                String.format("%s %s", sneakersType.getBrand(), sneakersType.getModel()),
                sneakersType.getPrice(),
                sneakersType.getDescription(),
                sneakersType.getImages(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                categoryMapper.toDTO(sneakersType.getCategory())
        );
    }
}
