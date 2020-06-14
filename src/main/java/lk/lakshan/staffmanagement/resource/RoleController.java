package lk.lakshan.staffmanagement.resource;

import lk.lakshan.staffmanagement.model.Role;
import lk.lakshan.staffmanagement.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class RoleController {

    @Autowired
    private RoleRepository repository;

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getRoles() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping("/roles")
    public ResponseEntity<String> saveRole(@RequestBody Role role) {
        repository.save(role);
        return ResponseEntity.ok("Role " + role.getId() + " added successfully");
    }

    @GetMapping("/roles/{id}")
    public ResponseEntity<Role> findRoleById(@PathVariable int id) {
        Optional<Role> role = repository.findById(id);

        if (!role.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(role.get());
    }

    @PutMapping("roles/{id}")
    public ResponseEntity<String> updateRole(@PathVariable int id, @RequestBody Role newRole) {
        Optional<Role> role = repository.findById(id);
        if (!role.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        role.get().setFirstName(newRole.getFirstName());
        role.get().setLastName(newRole.getLastName());
        role.get().setNicNo(newRole.getNicNo());
        role.get().setOrganization(newRole.getOrganization());
        role.get().setRoleType(newRole.getRoleType());
        role.get().setLastUpdatedTimestamp(LocalDateTime.now());
        repository.save(role.get());
        return ResponseEntity.ok("Role updated successfully");
    }

    @DeleteMapping("/roles/{id}")
    public ResponseEntity deleteRole(@PathVariable int id) {
        if (!repository.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findRoleByNicNo/{nicNo}")
    public ResponseEntity findRoleByNICNo(@PathVariable String nicNo) {
        return ResponseEntity.ok(repository.findRoleByNicNo(nicNo));
    }

    @GetMapping("/findRoleByOrgAndType")
    public ResponseEntity findRoleByOrgAndType(@RequestParam(value = "organization") String organization,
                                               @RequestParam(value = "roleType") String roleType) {
        List<Role> result = repository.findRoleByOrganizationAndRoleType(organization, roleType);
        return ResponseEntity.ok(repository.findRoleByOrganizationAndRoleType(organization, roleType));
    }
}
