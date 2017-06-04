package oop.darkfree.Controller;

import javafx.util.Pair;
import oop.darkfree.dao.examination.implementations.DBDaoExaminations;
import oop.darkfree.models.doctor.interfaces.IDoctor;
import oop.darkfree.models.examination.interfaces.IExamination;
import oop.darkfree.models.medicalLaboratories.interfaces.IMedicalLab;
import oop.darkfree.servise.examination.imlementations.SExamination;
import oop.darkfree.servise.examination.interfaces.ISExamination;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by darkfree on 04.06.17.
 */
@RestController
public class BussinessController {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    ISExamination service;

    public BussinessController() {
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/oop");
        dataSource.setUsername("root");
        dataSource.setPassword("Qawasadedrdf102030");
        service = new SExamination(new DBDaoExaminations(dataSource));
    }

    @RequestMapping(value = "/get/good/doctor", method = RequestMethod.POST)
    public List<IDoctor> getNominantsToBonus(@RequestParam("count") String count){
        try {
            return service.getNominantToBonus(Integer.parseInt(count));
        }
        catch (NumberFormatException exp){
            return null;
        }
    }

    @RequestMapping("/get/profit/all")
    public Double getProfitAll(){
        return service.getAllProfit();
    }

    @RequestMapping(value = "/get/profit/date", method = RequestMethod.POST)
    public Pair<Date,Double> getDateProfit(@RequestParam("date") String date){
        Pair<Date,Double> result = new Pair<>(java.sql.Date.valueOf(date),service.getProfitByDate(java.sql.Date.valueOf(date)));
        return result;
    }

    @RequestMapping("/get/top/five")
    public List<IExamination> getTopFive(){
        return service.getFiveTheMostCost();
    }

    @RequestMapping(value = "/get/bad/labs", method = RequestMethod.POST)
    public List<IMedicalLab> getBadLabs(@RequestParam("count") String count){
        return service.getLossesLabs(Integer.parseInt(count));
    }
}
