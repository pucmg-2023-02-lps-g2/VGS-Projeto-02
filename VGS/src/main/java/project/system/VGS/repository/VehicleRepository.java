package project.system.VGS.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import project.system.VGS.models.Vehicle;

@Repository
public interface VehicleRepository extends MongoRepository<Vehicle, String> {
}
