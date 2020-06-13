package lk.lakshan.staffmanagement.resource;

import lk.lakshan.staffmanagement.model.Role;
import lk.lakshan.staffmanagement.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RoleController {

    @Autowired
    private RoleRepository repository;

    @PostMapping("/roles")
    public ResponseEntity saveRole(@RequestBody Role role) {
        return ResponseEntity.ok(repository.save(role));
    }

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getRoles() {
        return ResponseEntity.ok(repository.findAll());
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
    public ResponseEntity<Role> updateRole(@PathVariable int id, @RequestBody Role role) {
        if (!repository.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(repository.save(role));
    }

    @DeleteMapping("/roles/{id}")
    public ResponseEntity deleteRole(@PathVariable int id) {
        if (!repository.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    /*@GetMapping("/roles?organization={organization}")
    public List<Role> findRoleByNICNo(@PathVariable String organization, Pageable pageable) {
        return repository.findRoleByOrganization(organization, pageable);
    }*/
}
