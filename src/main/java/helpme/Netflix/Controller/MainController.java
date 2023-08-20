package helpme.Netflix.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String Home() {
        return "main";
    }

    // 상세페이지는 팝업 화면으로 보여주자~

    // 로그인 화면도 팝업으로 보여준다.
}
