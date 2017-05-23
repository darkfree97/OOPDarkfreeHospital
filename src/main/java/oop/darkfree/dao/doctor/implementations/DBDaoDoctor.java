package oop.darkfree.dao.doctor.implementations;

import oop.darkfree.dao.doctor.interfaces.IDaoDoctor;
import oop.darkfree.models.doctor.implementation.Doctor;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by darkfree on 11.05.17.
 */
public class DBDaoDoctor implements IDaoDoctor{
    private DataSource dataSource;
    public void setDataSource(DataSource ds) {
        dataSource = ds;
    }

    public DBDaoDoctor() {
    }

    public DBDaoDoctor(DataSource dataSource) {

        this.dataSource = dataSource;
    }

    @Override
    public List<Doctor> getAll() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("SELECT * FROM doctors", new DoctorRowMapper());
    }

    @Override
    public Doctor getDoctor(int id) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return (Doctor) select.query("SELECT * FROM doctors WHERE id=?",new Object[]{id},new DoctorRowMapper()).stream().findFirst().get();
    }

    @Override
    public void createDoctor(Doctor doctor) {
        JdbcTemplate insert = new JdbcTemplate(dataSource);
        insert.update("INSERT INTO doctors (id,d_surname,d_name,d_fathername,profession,expiriense,value_of_exam) VALUES(?,?,?,?,?,?,?)",
                new Object[]{
                doctor.getPerson().getId(),
                doctor.getPerson().getSurname(),
                doctor.getPerson().getName(),
                doctor.getPerson().getFathername(),
                doctor.getProfession(),
                doctor.getExperience(),
                doctor.getCostOfExam()});
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        JdbcTemplate delete = new JdbcTemplate(dataSource);
        delete.update("FROM doctors WHERE id = ? UPDATE FIRST (d_surname,d_name,d_fathername,profession,expiriense,value_of_exam) VALUES(?,?,?,?,?,?) ",
                new Object[]{
                        doctor.getPerson().getId(),
                        doctor.getPerson().getSurname(),
                        doctor.getPerson().getName(),
                        doctor.getPerson().getFathername(),
                        doctor.getProfession(),
                        doctor.getExperience(),
                        doctor.getCostOfExam()});
    }

    @Override
    public void deleteDoctor(int id) {
        JdbcTemplate delete = new JdbcTemplate(dataSource);
        delete.update("DELETE FROM doctors WHERE id = ?",new Object[] { id });
    }
}
