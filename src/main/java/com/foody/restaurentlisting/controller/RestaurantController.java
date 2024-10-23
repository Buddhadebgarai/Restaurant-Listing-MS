package com.foody.restaurentlisting.controller;

import com.foody.restaurentlisting.dto.RestaurantDTO;
import com.foody.restaurentlisting.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/getAllRestaurants")
    public ResponseEntity<List<RestaurantDTO>> fetchAllRestaurants()
    {
        List<RestaurantDTO> reatuarantlist = restaurantService.getAllRestaurant();
        return new ResponseEntity<>(reatuarantlist, HttpStatus.OK);
    }

    @PostMapping(value = "/addRestaurant",consumes ="application/json",produces ="application/json" )
    public ResponseEntity<RestaurantDTO> addRestaurant(@RequestBody RestaurantDTO restaurantDTO)
    {
        RestaurantDTO restaurantDTOAdded = restaurantService.addRestaurent(restaurantDTO);
        return new ResponseEntity<>(restaurantDTOAdded,HttpStatus.CREATED);
    }
    @GetMapping("/getRestaurantById/{id}")
    public ResponseEntity<RestaurantDTO> getRestaurantById(@PathVariable Integer id)
    {
        return restaurantService.getRestaurantById(id);

    }
}
