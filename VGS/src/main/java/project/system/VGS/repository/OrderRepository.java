package project.system.VGS.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import project.system.VGS.models.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
}
