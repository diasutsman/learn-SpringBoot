package dias.restful.users.controllers;

import dias.restful.shared.responses.WebResponse;
import dias.restful.users.models.RegisterUserRequest;
import dias.restful.users.services.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(
            path = "/users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> register(@RequestBody RegisterUserRequest registerUserRequest) {

        userService.register(registerUserRequest);
        return WebResponse.<String>builder().data("OK").build();
    }

}
