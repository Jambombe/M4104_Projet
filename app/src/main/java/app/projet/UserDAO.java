package app.projet;

import java.util.List;

public class UserDAO {

    public static List<User> allUsers(){
        return User.listAll(User.class);
    }

    public static void updateDB() {
//        User u = new User("Je suis", "le test", "image");
//        u.save();
    }
}
