package oop.darkfree.dao.patient.implementations;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by darkfree on 11.05.17.
 */
public class PatientRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        PatientResultSetExtractor extractor = new PatientResultSetExtractor();
        return extractor.extractData(resultSet);
    }
}
