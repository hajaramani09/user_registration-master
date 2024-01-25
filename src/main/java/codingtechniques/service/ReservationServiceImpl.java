package codingtechniques.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
 
import org.springframework.web.server.ResponseStatusException;

import codingtechniques.model.Reservation;
import codingtechniques.model.Service;
import codingtechniques.repositories.ReservationRepository;

@org.springframework.stereotype.Service

public class ReservationServiceImpl {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Ajoutez les informations de la base de données à l'URL

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/db_jnane";
        String user = "root";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }

    public void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Autowired
    static ReservationRepository userInterface;

    public List<Reservation> getReservation() {
        List<Reservation> users = new ArrayList<Reservation>();
        userInterface.findAll().forEach(users::add);
        return users;
    }

    public Reservation addReservation(Reservation user) {
        if (user.getname() == null || user.getname().equals(""))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nom Complet invalide");

        if (user.getnote() == null || user.getnote().equals(""))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "description invalide");

        if (user.getAdress() == null || user.getAdress().equals(""))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Adress invalide");

        if (user.getEmail() == null || user.getEmail().equals(""))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email invalide");

        if (user.getphone() == null || user.getphone().equals(""))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Numéro de téléphone invalide");

        if (user.getService() == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Service invalide");

        if (userInterface.findByEmail(user.getEmail()).isPresent())
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Réservation déjà enregistrée");

        user.setDate(user.getDate());
        return userInterface.save(user);
    }

    public List<Reservation> findAllReservations() {
        List<Reservation> result = new ArrayList<>();
        String sql = "select * from reservation"; // Supprimez le deuxième "from reservation"
        Reservation resv;
        resv = new Reservation();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet res = stm.executeQuery();
            while (res.next()) {

                resv.setId(res.getInt("id"));
                resv.setAdress(res.getString("Adress"));

                resv.setDate(res.getDate("dR"));
                resv.setphone(res.getString("phone"));
                resv.setEmail(res.getString("email"));

                switch (res.getString("service")) {
                    case "Restaurant":
                        resv.setService(Service.restaurant);
                        break;
                    case "Piscine":
                        resv.setService(Service.piscine);
                        break;
                    case "Salle de Fête":
                        resv.setService(Service.salle_de_Fete);
                        break;
                    case "Activités et détent":
                        resv.setService(Service.activites_et_Detent);
                        break;
                    case "Cuisine Marocaine":
                        resv.setService(Service.cuisine_Marocaine);
                        break;
                    case "Traiteur":
                        resv.setService(Service.traiteur);
                        break;
                    case "Neggafa":
                        resv.setService(Service.neggafa);
                        break;

                    default:
                        resv.setService(Service.bungalows);
                        break;

                }
                resv.setname(res.getString("name"));
                resv.setnote(res.getString("note"));
                result.add(resv);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return result; // Ajoutez le retour de la liste
    }

    public void insert(Reservation reservation) {
        // Implémentez la logique d'insertion ici
    }

    public void update(Reservation reservation) {
        // Implémentez la logique de mise à jour ici
    }

    public void delete(int  id) {

    }

    public void generateAdmin() {
    }
}