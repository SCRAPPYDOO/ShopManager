package shop.manager.mapper;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

public class MapperIntegerToIntegerProperty extends CustomMapper<Integer, IntegerProperty> {
  
  @Override
  public void mapAtoB(Integer integer, IntegerProperty integerProperty, MappingContext context) {
    integerProperty = new SimpleIntegerProperty(integer);
  }
}
