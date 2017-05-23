package oop.darkfree.dao.doctor.implementations;

import oop.darkfree.models.doctor.implementation.Doctor;
import oop.darkfree.models.person.implementation.Person;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by darkfree on 11.05.17.
 */
public class DoctorResultSetExtractor implements ResultSetExtractor {
    @Override
    public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        Doctor doctor = new Doctor();
        doctor.setPerson(new Person(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)));
        doctor.setProfession(resultSet.getString(5));
        doctor.setExperience(resultSet.getInt(6));
        doctor.setValueOfExam(resultSet.getDouble(7));
        return doctor;
    }
}
