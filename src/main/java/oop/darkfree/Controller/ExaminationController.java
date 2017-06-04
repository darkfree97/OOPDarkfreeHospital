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
import java.util.Properties;


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
