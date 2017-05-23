package oop.darkfree.dao.doctor.implementations;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by darkfree on 11.05.17.
 */
public class DoctorRowMapper implements RowMapper{
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        DoctorResultSetExtractor extractor = new DoctorResultSetExtractor();
        return extractor.extractData(resultSet);
    }
}
