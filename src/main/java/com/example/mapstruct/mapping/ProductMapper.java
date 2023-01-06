package com.example.mapstruct.mapping;

import com.example.mapstruct.dto.ProductDto;
import com.example.mapstruct.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring",imports = UUID.class)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

   // @Mapping(source = "desc",target = "description",defaultValue = "description")
   //    @Mapping(target = "itemId",expression = "java(UUID.randomUUID().toString())")
  //    @Mapping(source = "items",target="itemsList")
   ProductDto modelToDto(Product product);

   List <ProductDto> modelsToDtos(List<Product> product);
    @InheritInverseConfiguration
   // @Mapping(source = "description",target = "desc",defaultValue = "description")
    Product dtoToModel(ProductDto productDto);


}
