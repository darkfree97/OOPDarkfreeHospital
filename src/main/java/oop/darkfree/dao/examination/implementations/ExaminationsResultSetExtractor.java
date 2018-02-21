package oop.darkfree.dao.examination.implementations;

import oop.darkfree.dao.diagnosis.implementations.DBDaoDiagnosis;
import oop.darkfree.dao.doctor.implementations.DBDaoDoctor;
import oop.darkfree.dao.medicalLaboratories.implementations.DBDaoMedLab;
import oop.darkfree.dao.patient.implementations.DBDaoPatient;
import oop.darkfree.models.diagnosis.implementation.Diagnosis;
import oop.darkfree.models.doctor.implementation.Doctor;
import oop.darkfree.models.examination.implementation.Examination;
import oop.darkfree.models.medicalLaboratories.implementation.MedicalLab;
import oop.darkfree.models.medicalLaboratories.interfaces.ExtremePoint;
import oop.darkfree.models.medicine.implementation.Medicine;
import oop.darkfree.models.medicine.interfaces.EMedicineType;
import oop.darkfree.models.patient.implementation.Patient;
import oop.darkfree.models.person.implementation.Person;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * Created by darkfree on 11.05.17.
 */
public class ExaminationsResultSetExtractor implements ResultSetExtractor {
    @Override
    public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        Examination examination = new Examination();
        examination.setId(resultSet.getInt("examinations.id"));
        Patient patient = new Patient();
        patient.setPerson(new Person());
        patient.getPerson().setId(resultSet.getInt("patients.id"));
        patient.getPerson().setSurname(resultSet.getString("p_surname"));
        patient.getPerson().setName(resultSet.getString("p_name"));
        patient.getPerson().setFathername(resultSet.getString("p_fathername"));
        patient.setYear(resultSet.getInt("year"));
        Doctor doctor = new Doctor();
        doctor.setPerson(new Person(
                resultSet.getInt("doctors.id"),
                resultSet.getString("d_surname"),
                resultSet.getString("d_name"),
                resultSet.getString("d_fathername")));
        doctor.setProfession(resultSet.getString("profession"));
        doctor.setExperience(resultSet.getInt("expiriense"));
        doctor.setValueOfExam(resultSet.getDouble("value_of_exam"));
        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setDiagnosis(resultSet.getString(1));
        diagnosis.setMedicine(
                new Medicine(
                        resultSet.getString("name"),
                        EMedicineType.valueOf(resultSet.getString("medicine_type")),
                        resultSet.getString("appointment"),
                        resultSet.getDouble("price")));
        diagnosis.setTakingMedicine(resultSet.getString("tackingMedicine"));
        diagnosis.setTherapyPeriodByDays(resultSet.getInt("therapyPeriodByDays"));
        MedicalLab medicalLab = new MedicalLab();
        medicalLab.setLabName(resultSet.getString("med_lab_name"));
        medicalLab.setRes(resultSet.getString("result_of_exm"));
        medicalLab.setExtrPoint(ExtremePoint.valueOf(resultSet.getString("extreme_point")));
        medicalLab.setPrice(resultSet.getDouble("price"));
        examination.setPatient(patient);
        examination.setDoctors(Arrays.asList(doctor));
        examination.setDiagnoses(Arrays.asList(diagnosis));
        examination.setMedLabs(Arrays.asList(medicalLab));
        examination.setDate(resultSet.getDate(6));
        return examination;
    }
}
