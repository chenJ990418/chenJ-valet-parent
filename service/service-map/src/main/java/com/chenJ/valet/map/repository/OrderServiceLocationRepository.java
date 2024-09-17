package com.chenJ.valet.map.repository;

import com.chenJ.valet.model.entity.map.OrderServiceLocationDo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderServiceLocationRepository extends MongoRepository<OrderServiceLocationDo, String> {

}
