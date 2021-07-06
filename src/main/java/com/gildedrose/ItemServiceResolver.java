package com.gildedrose;

import com.gildedrose.model.Item;
import com.gildedrose.service.*;
import com.sun.jdi.InternalException;

import java.util.List;
import java.util.stream.Collectors;

public class ItemServiceResolver {
    private static final List<ItemsService> ITEMS_SERVICES = List.of(
            new RegularItemsService(),
            new AgedBrieService(),
            new TicketsService(),
            new SulfurasService(),
            new ConjuredItemsService());

    public static ItemsService resolveItemService(Item item) {
        List<ItemsService> itemsService = ITEMS_SERVICES
                .stream()
                .filter(service -> service.isApplicable(item))
                .collect(Collectors.toList());

        if (itemsService.size() > 1) {
            throw new InternalException("Too many services resolved");
        } else if (itemsService.isEmpty()) {
            throw new InternalException("Could not find service for item");
        }

        return itemsService.get(0);
    }
}
