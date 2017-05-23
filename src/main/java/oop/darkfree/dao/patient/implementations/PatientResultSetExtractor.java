package oop.darkfree.dao.patient.implementations;

import oop.darkfree.models.patient.implementation.Patient;
import oop.darkfree.models.person.implementation.Person;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by darkfree on 11.05.17.
 */
public class PatientResultSetExtractor implements ResultSetExtractor {
    @Override
    public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        Patient patient = new Patient();
        patient.setPerson(new Person());
        patient.getPerson().setId(resultSet.getInt(1));
        patient.getPerson().setSurname(resultSet.getString(2));
        patient.getPerson().setName(resultSet.getString(3));
        patient.getPerson().setFathername(resultSet.getString(4));
        patient.setYear(resultSet.getInt(5));
        return patient;
    }
}
