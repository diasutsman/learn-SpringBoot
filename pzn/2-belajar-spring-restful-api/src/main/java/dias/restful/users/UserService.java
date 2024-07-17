package dias.restful.users;

import dias.restful.shared.security.BCrypt;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final Validator validator;

    public UserService(UserRepository userRepository, Validator validator) {
        this.userRepository = userRepository;
        this.validator = validator;
    }


    @Transactional
    public void register(RegisterUserRequest registerUserRequest) {

        Set<ConstraintViolation<RegisterUserRequest>> constraintViolations = validator.validate(registerUserRequest);
        if (!constraintViolations.isEmpty()) {
            // error
            throw new ConstraintViolationException(constraintViolations);
        }

        if (userRepository.existsById(registerUserRequest.getUsername())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already taken.");
        }

        User user = new User();
        user.setUsername(registerUserRequest.getUsername());
        user.setName(registerUserRequest.getName());
        user.setPassword(BCrypt.hashpw(registerUserRequest.getPassword(), BCrypt.gensalt()));

        userRepository.save(user);
    }

}
