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
        doctor.setPerson(new Person(
                resultSet.getInt("id"),
                resultSet.getString("d_surname"),
                resultSet.getString("d_name"),
                resultSet.getString("d_fathername")));
        doctor.setProfession(resultSet.getString("profession"));
        doctor.setExperience(resultSet.getInt("expiriense"));
        doctor.setValueOfExam(resultSet.getDouble("value_of_exam"));
        return doctor;
    }
}
