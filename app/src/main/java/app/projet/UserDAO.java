package app.projet;


import java.util.List;

public class UserDAO {

    public static List<User> allUsers(){
        return User.listAll(User.class);
    }

    public static User getUserFromId(int id){
        return User.findById(User.class, id);
    }
}
