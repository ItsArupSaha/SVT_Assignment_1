public class Q2_LoginManager {
    private final AuthenticationService authenticationService;

    public Q2_LoginManager(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    public boolean login(String username, String password) {
        if (username == null || password == null) {
            throw new IllegalArgumentException("Username or password cannot be null");
        }
        return authenticationService.authenticate(username, password);
    }
}

interface AuthenticationService {
    boolean authenticate(String username, String password);
}