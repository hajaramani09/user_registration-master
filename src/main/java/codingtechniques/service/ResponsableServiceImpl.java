package codingtechniques.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
 
import org.springframework.web.server.ResponseStatusException;
import codingtechniques.model.Responsable;
import codingtechniques.repositories.ResponsableRepositories;

@Service
public class ResponsableServiceImpl {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.driver"); 
        } catch (Exception e) {
            e.printStackTrace(); 
        }
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
    public ResponsableRepositories userInterface;

    public Integer getAuthUser() {
        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) SecurityContextHolder
                .getContext().getAuthentication();
        return (Integer) auth.getPrincipal();
    }

    public List<Responsable> getUsers() {
        List<Responsable> users = new ArrayList<Responsable>();
        userInterface.findAll().forEach(users::add);
        return users;
    }

    public Responsable addUser(Responsable user) {
        if (user.getEmail() == null || user.getEmail().equals(""))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email invalide");
        if (userInterface.findByEmail(user.getEmail()).isPresent())
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Utilisateur déjà enregistré");

        return userInterface.save(user);
    }

    public Responsable getUser(String email, String pwd) throws ResponseStatusException {
        // check with ldap
        if (email == null || email.equals("") || pwd == null || pwd.equals(""))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email ou mot de passe non valide");
        Optional<Responsable> user = userInterface.findByEmail(email);
        if (!user.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilisateur non trouvé");
        // check admin
        if (email.equals("admin@bs.ocpgroup.ma") && !pwd.equals("#admin@admin#"))
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Email ou mot de passe incorrect");
        return user.get();
    }

    public Responsable getUser(int userId) {
        Optional<Responsable> user = userInterface.findById(userId);
        if (!user.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilisateur non trouvé");
        return user.get();
    }

   
    /**
     * @param userId
     * @param user
     * @return
     */
    public Responsable updateUser(Integer userId, Responsable user) {
        if (user.getEmail() == null || user.getEmail().equals(""))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email invalide");
        Optional<Responsable> checkUser = userInterface.findByEmail(user.getEmail());

        if (checkUser.isPresent() && checkUser.get().getId() != user.getId())

            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email déjà utilisé");
        return userInterface.save(user);
    }

    public Responsable deleteUser(int userId) {
        Responsable user = getUser(userId);
        userInterface.deleteById(userId);
        return user;
    }

    public Responsable generateAdmin() {
        if (userInterface.findByEmail("xxxxxx@gmail.ma").isPresent())
            return null;
        Responsable user = new Responsable(1, "admin", "xxxxxx@gmail.ma");
        return userInterface.save(user);
    }
}
