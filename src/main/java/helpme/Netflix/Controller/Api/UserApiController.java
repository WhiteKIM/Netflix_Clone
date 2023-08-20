package helpme.Netflix.Controller.Api;

import helpme.Netflix.DTO.ResponseEntity;
import helpme.Netflix.Repository.UserRepository;
import helpme.Netflix.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserApiController {
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login() {
        return new ResponseEntity<>(HttpStatus.OK.value(), "로그인 성공");
    }

    @PostMapping("/join")
    public ResponseEntity<String> join() {
        return new ResponseEntity<>(HttpStatus.OK.value(), "회원가입 완료");
    }
}
