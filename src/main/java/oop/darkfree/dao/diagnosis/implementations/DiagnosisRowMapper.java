package oop.darkfree.dao.diagnosis.implementations;


import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by darkfree on 10.05.17.
 */
public class DiagnosisRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        DiagnosisResultSetExtractor extractor = new DiagnosisResultSetExtractor();
        return extractor.extractData(resultSet);
    }
}
