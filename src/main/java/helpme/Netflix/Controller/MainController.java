package helpme.Netflix.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

    @GetMapping("/")
    public String Home() {
        return "main";
    }

    @GetMapping("/details/{id}")
    public String detailForm(@PathVariable long id, Model model) {
//        model.addAttribute("Overview");
        return "Page/DetailForm";
    }
    // 로그인 화면도 팝업으로 보여준다.

    @GetMapping("/join")
    public String joinForm() {
        return "Page/JoinForm";
    }
}
