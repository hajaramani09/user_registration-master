package codingtechniques.controller;

import codingtechniques.model.Reservation;
import codingtechniques.service.ReservationServiceImpl;
import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Service
@Setter
@Getter
@RequestMapping("/api/reservation")
public class ReservationController {

    
    @Autowired
    private  ReservationServiceImpl reservationService;

    
    public ReservationController( ReservationServiceImpl reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<Iterable<Reservation>> getAllReservations() {
        Iterable<Reservation> reservations = reservationService.findAllReservations();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Reservation> addReservation(@Validated @RequestBody Reservation reservation) {
        Reservation savedReservation = reservationService.addReservation(reservation);
        return new ResponseEntity<>(savedReservation, HttpStatus.CREATED);
    }
}
