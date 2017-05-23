package oop.darkfree.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by darkfree on 23.05.17.
 */
@Controller
public class IndexController {
    //@RequestMapping("/")
    public String getIndex(ModelMap modelMap){
        modelMap.put("var","Index");
        return "index";
    }
}
