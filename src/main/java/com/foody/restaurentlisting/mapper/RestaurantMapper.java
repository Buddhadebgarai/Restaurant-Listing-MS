package com.foody.restaurentlisting.mapper;

import com.foody.restaurentlisting.dto.RestaurantDTO;
import com.foody.restaurentlisting.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {

    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    RestaurantDTO mapRestaurantToRestaurantDTO(Restaurant restaurant);
    Restaurant mapRestaurentDTOToRestaurent(RestaurantDTO restaurantDTO);

}
