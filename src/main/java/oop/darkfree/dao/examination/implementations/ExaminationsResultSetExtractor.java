package oop.darkfree.dao.examination.implementations;

import oop.darkfree.dao.diagnosis.implementations.DBDaoDiagnosis;
import oop.darkfree.dao.doctor.implementations.DBDaoDoctor;
import oop.darkfree.dao.medicalLaboratories.implementations.DBDaoMedLab;
import oop.darkfree.dao.patient.implementations.DBDaoPatient;
import oop.darkfree.models.examination.implementation.Examination;
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
    private DataSource dataSource;
    private DBDaoPatient patient ;
    private DBDaoDoctor doctor ;
    private DBDaoMedLab medLab ;
    private DBDaoDiagnosis diagnosis ;

    public ExaminationsResultSetExtractor(DataSource dataSource) {
        this.dataSource = dataSource;
        this.patient = new DBDaoPatient(dataSource);
        this.doctor = new DBDaoDoctor(dataSource);
        this.medLab = new DBDaoMedLab(dataSource);
        this.diagnosis = new DBDaoDiagnosis(dataSource);
    }

    @Override
    public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        Examination examination = new Examination();
        examination.setId(resultSet.getInt(1));
        examination.setPatient(patient.getPatient(resultSet.getInt("patient_id")));
        examination.setDoctors(Arrays.asList(doctor.getDoctor(resultSet.getInt("doctor_id"))));
        examination.setDiagnoses(Arrays.asList(diagnosis.getDiagnosis(resultSet.getString("diagnosis_name"))));
        examination.setMedLabs(Arrays.asList(medLab.getMedicalLab(resultSet.getString("med_lab_name"))));
        examination.setDate(resultSet.getDate(6));
        return examination;
    }
}
