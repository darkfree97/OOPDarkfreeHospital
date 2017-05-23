package oop.darkfree.dao.patient.implementations;

import oop.darkfree.dao.patient.interfaces.IDaoPatient;
import oop.darkfree.models.patient.implementation.Patient;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by darkfree on 11.05.17.
 */
public class DBDaoPatient implements IDaoPatient {
    private DataSource dataSource;
    public void setDataSource(DataSource ds) {
        dataSource = ds;
    }

    public DBDaoPatient() {
    }

    public DBDaoPatient(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Patient> getAll() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("SELECT * FROM patients", new PatientRowMapper());
    }

    @Override
    public Patient getPatient(int id) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return (Patient) select.query("SELECT * FROM patients WHERE id=?",new Object[]{id},new PatientRowMapper()).stream().findFirst().get();
    }

    @Override
    public void createPatient(Patient patient) {

    }

    @Override
    public void updatePatient(Patient patient) {

    }

    @Override
    public void deletePatient(int id) {

    }
}
