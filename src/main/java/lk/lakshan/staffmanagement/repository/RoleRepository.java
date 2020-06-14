package lk.lakshan.staffmanagement.repository;

import lk.lakshan.staffmanagement.model.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends MongoRepository <Role, Integer> {
    Page<Role> findByNicNo (@Param("nicNo") String nicNo, Pageable pageable);

}
