package site.lashop.lashopbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.lashop.lashopbackend.model.Item;
import site.lashop.lashopbackend.repo.ItemRepo;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepo itemRepo;

    public void saveItem(Item item) {
        itemRepo.save(item);
    }
}
