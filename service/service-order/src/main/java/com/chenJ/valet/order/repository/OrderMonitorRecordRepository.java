package com.chenJ.valet.order.repository;


import com.chenJ.valet.model.entity.order.OrderMonitorRecordDo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMonitorRecordRepository extends MongoRepository<OrderMonitorRecordDo, String> {

}
