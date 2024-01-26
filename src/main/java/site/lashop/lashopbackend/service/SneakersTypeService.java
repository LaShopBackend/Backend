package site.lashop.lashopbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.lashop.lashopbackend.model.SneakersType;
import site.lashop.lashopbackend.repo.SneakersTypeRepo;

@Service
public class SneakersTypeService {

    private final SneakersTypeRepo sneakersTypeRepo;

    @Autowired
    public SneakersTypeService(SneakersTypeRepo sneakersTypeRepo) {
        this.sneakersTypeRepo = sneakersTypeRepo;
    }

    public void saveSneakersType(SneakersType sneakersType) {
        sneakersTypeRepo.save(sneakersType);
    }
}
