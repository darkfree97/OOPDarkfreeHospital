package oop.darkfree.Controller;

import oop.darkfree.dao.diagnosis.implementations.DBDaoDiagnosis;
import oop.darkfree.dao.doctor.implementations.DBDaoDoctor;
import oop.darkfree.dao.examination.implementations.DBDaoExaminations;
import oop.darkfree.dao.medicalLaboratories.implementations.DBDaoMedLab;
import oop.darkfree.dao.patient.implementations.DBDaoPatient;
import oop.darkfree.models.diagnosis.implementation.Diagnosis;
import oop.darkfree.models.doctor.implementation.Doctor;
import oop.darkfree.models.examination.implementation.Examination;
import oop.darkfree.models.medicalLaboratories.implementation.MedicalLab;
import oop.darkfree.models.patient.implementation.Patient;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by Darkfree on 11.04.2017.
 */
@RestController

public class ExaminationController {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();

    public ExaminationController() {
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/oop");
        dataSource.setUsername("root");
        dataSource.setPassword("Qawasadedrdf102030");
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
                "        <a href=\"/t_examinations.html\"><button class=\"btn btn-primary btn-block\">Examinations</button></a>\n" +
                "        <a href=\"/t_patients.html\"><button class=\"btn btn-primary btn-block\">Patients</button></a>\n" +
                "        <a href=\"/t_diagnosis.html\"><button class=\"btn btn-primary btn-block\">Diagnosis</button></a>\n" +
                "        <a href=\"/t_doctors.html\"><button class=\"btn btn-primary btn-block\">Doctors</button></a>\n" +
                "        <a href=\"/t_med_labs.html\"><button class=\"btn btn-primary btn-block\">Med Labs</button></a>\n" +
                "        <a href=\"#\"><button class=\"btn btn-primary btn-block\">Бізнес логіка</button></a>\n" +
                "    </div>\n" +
                "</div>\n" +
                "\n" +
                "</body>\n" +
                "</html>\n" +
                "\n";
    }

    @RequestMapping(value = "/examinations")
    public List<Examination> getExaminations(){
        DBDaoExaminations daoExaminations = new DBDaoExaminations();
        daoExaminations.setDataSource(dataSource);
        return daoExaminations.getAll();
    }


    @RequestMapping(value = "/diagnosis")
    public List<Diagnosis> getDiagnosisSet(){
        DBDaoDiagnosis daoDiagnosis = new DBDaoDiagnosis();
        daoDiagnosis.setDataSource(dataSource);
        return daoDiagnosis.getAll();
    }

    @RequestMapping(value = "/doctors")
    public List<Doctor> getDoctors(){
        DBDaoDoctor daoDoctor = new DBDaoDoctor();
        daoDoctor.setDataSource(dataSource);
        return daoDoctor.getAll();
    }

    @RequestMapping(value = "/patients")
    public List<Patient> getPatients(){
        DBDaoPatient daoPatient = new DBDaoPatient();
        daoPatient.setDataSource(dataSource);
        return daoPatient.getAll();
    }

    @RequestMapping(value = "/medLabs")
    public List<MedicalLab> getMedLabs(){
        DBDaoMedLab daoMedLab = new DBDaoMedLab();
        daoMedLab.setDataSource(dataSource);
        return daoMedLab.getAll();
    }
}
