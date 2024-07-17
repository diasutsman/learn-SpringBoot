package dias.restful.users.services;

import dias.restful.shared.security.BCrypt;
import dias.restful.shared.services.ValidationService;
import dias.restful.users.User;
import dias.restful.users.UserRepository;
import dias.restful.users.models.RegisterUserRequest;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class UserService {


    private final UserRepository userRepository;

    private final ValidationService validationService;

    public UserService(UserRepository userRepository, ValidationService validationService) {
        this.userRepository = userRepository;
        this.validationService = validationService;
    }

    @Transactional
    public void register(RegisterUserRequest request) {

        validationService.validate(request);

        if (userRepository.existsById(request.getUsername())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already taken.");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setName(request.getName());
        user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));

        userRepository.save(user);
    }

}
