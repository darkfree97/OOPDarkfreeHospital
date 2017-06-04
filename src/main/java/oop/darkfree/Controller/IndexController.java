package oop.darkfree.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by darkfree on 23.05.17.
 */
@Controller
@RestController
public class IndexController {
    //@RequestMapping("/")
    public String getIndexHtml(ModelMap modelMap){
        modelMap.put("var","Index");
        return "";
    }

    @RequestMapping("/")
    public String getIndex(ModelMap modelMap){
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <!-- Theme Made By www.w3schools.com - No Copyright -->\n" +
                "    <title>Hospital</title>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n" +
                "    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n" +
                "    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n" +
                "    <script src=\"https://unpkg.com/vue\"></script>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            background-color: #1abc9c;\n" +
                "            color: #ffffff;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<div class=\"bg-1\">\n" +
                "    <div class=\"container text-center\">\n" +
                "        <h3>Hospital Log</h3>\n" +
                "        <img src=\"images/hospital-icon-23.png\" class=\"img-circle\" alt=\"Bird\" width=\"350\" height=\"350\">\n" +
                "        <br><br><br><br><br><br><br><br><br><br><br>\n" +
                "        <a href=\"/t_examinations.html\"><button class=\"btn btn-primary btn-block\">Обстеження</button></a>\n" +
                "        <a href=\"/t_patients.html\"><button class=\"btn btn-primary btn-block\">Пацієнти</button></a>\n" +
                "        <a href=\"/t_diagnosis.html\"><button class=\"btn btn-primary btn-block\">Діагнози</button></a>\n" +
                "        <a href=\"/t_doctors.html\"><button class=\"btn btn-primary btn-block\">Лікарі</button></a>\n" +
                "        <a href=\"/t_med_labs.html\"><button class=\"btn btn-primary btn-block\">Лабораторії</button></a>\n" +
                "        <a href=\"/bussiness/index.html\"><button class=\"btn btn-primary btn-block\">Бізнес логіка</button></a>\n" +
                "    </div>\n" +
                "</div>\n" +
                "\n" +
                "</body>\n" +
                "</html>\n" +
                "\n";
    }
}
