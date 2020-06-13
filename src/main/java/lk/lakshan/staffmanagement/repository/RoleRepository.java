package lk.lakshan.staffmanagement.repository;

import lk.lakshan.staffmanagement.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository <Role, Integer> {
}
