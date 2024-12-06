public class Q1_UserService {
    private UserRepository userRepository;

    public Q1_UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Q1_User findUserById(int id) {
        return userRepository.findUserById(id);
    }
}

interface UserRepository {
    Q1_User findUserById(int id);
}
