public class Q2_UserManager {
    private final UserService userService;

    public Q2_UserManager(UserService userService) {
        this.userService = userService;
    }

    public boolean registerUser(String username, String password) {
        if (userService.usernameExists(username)) {
            return false; // User already exists
        }
        return userService.saveUser(username, password);
    }

    public static double celsiusToFahrenheit(double celsius) {
        if(celsius < -273.15) throw new IllegalArgumentException("Temperature below absolute zero");
        return (celsius * 9/5) + 32;
    }
}

interface UserService {
    boolean usernameExists(String username);
    boolean saveUser(String username, String password);
}
