package site.lashop.lashopbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.lashop.lashopbackend.model.SneakersType;
import site.lashop.lashopbackend.repo.SneakersTypeRepo;

@Service
@RequiredArgsConstructor
public class SneakersTypeService {

    private final SneakersTypeRepo sneakersTypeRepo;

    public void saveSneakersType(SneakersType sneakersType) {
        sneakersTypeRepo.save(sneakersType);
    }
}
