package com.foody.restaurentlisting.repo;

import com.foody.restaurentlisting.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurentRepo extends JpaRepository<Restaurant, Integer> {
}
