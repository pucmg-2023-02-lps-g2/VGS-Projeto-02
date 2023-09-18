package project.system.VGS.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import project.system.VGS.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
