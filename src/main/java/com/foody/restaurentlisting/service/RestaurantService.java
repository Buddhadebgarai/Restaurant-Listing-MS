package com.foody.restaurentlisting.service;


import com.foody.restaurentlisting.dto.RestaurantDTO;
import com.foody.restaurentlisting.entity.Restaurant;
import com.foody.restaurentlisting.mapper.RestaurantMapper;
import com.foody.restaurentlisting.repo.RestaurentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurentRepo restaurentRepo;

    public List<RestaurantDTO> getAllRestaurant() {
        List<Restaurant> restaurantList = restaurentRepo.findAll();
        return restaurantList.stream().map(RestaurantMapper.INSTANCE::mapRestaurantToRestaurantDTO).toList();
    }

    public RestaurantDTO addRestaurent(RestaurantDTO restaurantDTO) {

        Restaurant restaurantAdded = restaurentRepo.save(RestaurantMapper.INSTANCE.mapRestaurentDTOToRestaurent(restaurantDTO));
        return  RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurantAdded);
    }

    public ResponseEntity<RestaurantDTO> getRestaurantById(Integer id) {
        Optional<Restaurant> restaurant = restaurentRepo.findById(id);
        return restaurant.map(value -> new ResponseEntity<>(RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(value), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
}
