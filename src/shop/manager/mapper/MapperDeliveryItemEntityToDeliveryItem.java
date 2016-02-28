package shop.manager.mapper;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import shop.manager.deliveries.model.DeliveryItem;
import shop.serwer.dao.model.deliveries.DeliveryItemEntity;

public class MapperDeliveryItemEntityToDeliveryItem
    extends CustomMapper<DeliveryItemEntity, DeliveryItem> {
    
    @Override
    public void mapAtoB(DeliveryItemEntity deliveryItemEntity, DeliveryItem deliveryItem, MappingContext context) {

    }
}
