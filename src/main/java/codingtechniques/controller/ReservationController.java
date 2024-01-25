package codingtechniques.controller;

import codingtechniques.repositories.*;
import codingtechniques.service.*;
import codingtechniques.model.Reservation;

//import java.util.List;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Controller
@Repository
@Service
@Component
@RestController


public class ReservationController {

    @Autowired
    static ReservationRepository userInterface;

    @Autowired
    public ReservationServiceImpl instanceService;

    @Autowired
    public Reservation reservation;

@RequestMapping(name = "reservation/registerReservation", method = RequestMethod.GET)
    public ResponseEntity<Reservation> registerReservation(@ModelAttribute Reservation user, Model model) {

        System.out.println(user.toString());

        // Validate

        System.out.println(user.getId());
        System.out.println(user.getAdress());
        System.out.println(user.getDate());
        System.out.println(user.getphone());
        System.out.println(user.getEmail());
        System.out.println(user.getService());
        System.out.println(user.getname());
        System.out.println(user.getnote());

        Reservation reservation_inserted = userInterface.save(user);
        model.addAttribute("message", reservation_inserted.getEmail() + "inserted.");

        return new ResponseEntity<Reservation>(instanceService.addReservation(user), null, HttpStatus.CREATED);
    }

    /*@GetMapping("/*")
    public List<Reservation> afficherFormulaire(Reservation reservation) {
        return instanceService.findAllReservations();
    }*/

   /* @GetMapping("/reservation")("/*")

    public Iterable<Reservation> afficherlisteUser(Model model) {
        model.addAttribute("reservation", userInterface.findAll());
        return userInterface.findAll();

    } */

    @RequestMapping(method = RequestMethod.POST, value = "reservation/addReservation")
    public ResponseEntity<Reservation> addReservation(@Validated @RequestBody Reservation reservation) {
        return new ResponseEntity<Reservation>(instanceService.addReservation(reservation), null, HttpStatus.OK);
    }

    

}
