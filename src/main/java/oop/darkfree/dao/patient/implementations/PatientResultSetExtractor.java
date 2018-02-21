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
        patient.getPerson().setId(resultSet.getInt("id"));
        patient.getPerson().setSurname(resultSet.getString("p_surname"));
        patient.getPerson().setName(resultSet.getString("p_name"));
        patient.getPerson().setFathername(resultSet.getString("p_fathername"));
        patient.setYear(resultSet.getInt("year"));
        return patient;
    }
}
