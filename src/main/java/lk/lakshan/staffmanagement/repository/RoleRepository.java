package lk.lakshan.staffmanagement.repository;

import lk.lakshan.staffmanagement.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoleRepository extends MongoRepository <Role, Integer> {
    Role findRoleByNicNo (@Param("nicNo") String nicNo);

    @Query(fields = "{_id: 0, firstName: 1, lastName: 1, nicNo: 1}")
    List<Role> findRoleByOrganizationAndRoleType(@Param("organization") String organization,
                                                 @Param("roleType") String roleType);
}
