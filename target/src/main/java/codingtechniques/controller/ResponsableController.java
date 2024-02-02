package codingtechniques.controller;

import codingtechniques.model.Responsable;
import codingtechniques.service.ResponsableServiceImpl;
import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Service
@Getter
@Setter
@RequestMapping("/api/responsables")
public class ResponsableController {

    private final ResponsableServiceImpl responsableService;

    @Autowired
    public ResponsableController(ResponsableServiceImpl responsableService) {
        this.responsableService = responsableService;
    }

    @PostMapping("/add")
    public ResponseEntity<Responsable> addUser(@Validated @RequestBody Responsable user) {
        return new ResponseEntity<>(responsableService.addUser(user), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getAll")
    public List<Responsable> getAllUsers() {
        return responsableService.getUsers();
    }

    @GetMapping("/getMe")
    public ResponseEntity<Responsable> getMe() {
        Responsable authUser = responsableService.getUser(responsableService.getAuthUser());
        return new ResponseEntity<>(authUser, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{userId}")
    public ResponseEntity<Responsable> updateUser(@PathVariable Integer userId, @RequestBody Responsable user) {
        return new ResponseEntity<>(responsableService.updateUser(userId, user), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer userId) {
        responsableService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
