package shop.manager.mapper;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

public class MapperStringToSimpleStringProperty extends CustomMapper<String, StringProperty>{
  
  @Override
  public void mapAtoB(String string, StringProperty stringProperty, MappingContext context) {
    stringProperty = new SimpleStringProperty(string);
  }


}
