package dias.restful.users.services;

import dias.restful.shared.security.BCrypt;
import dias.restful.shared.services.ValidationService;
import dias.restful.users.User;
import dias.restful.users.UserRepository;
import dias.restful.users.models.LoginUserRequest;
import dias.restful.users.models.TokenResponse;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service

public class AuthService {
    private final UserRepository userRepository;

    private final ValidationService validationService;

    public AuthService(UserRepository userRepository, ValidationService validationService) {
        this.userRepository = userRepository;
        this.validationService = validationService;
    }


    @Transactional
    public TokenResponse login(LoginUserRequest request) {
        validationService.validate(request);

        User user = userRepository.findById(request.getUsername())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED, "Username or password is wrong")
                );

        if (!BCrypt.checkpw(request.getPassword(), user.getPassword())) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "Username or password is wrong");
        }

        user.setToken(UUID.randomUUID().toString());
        user.setTokenExpiredAt(next30Days());
        userRepository.save(user);

        return TokenResponse.builder()
                .token(user.getToken())
                .expiredAt(user.getTokenExpiredAt())
                .build();
    }

    private Long next30Days() {
        return System.currentTimeMillis() + (1000 * 60 * 24 * 30);
    }
}
