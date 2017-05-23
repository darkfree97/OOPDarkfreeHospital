package oop.darkfree.dao.medicalLaboratories.implementations;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by darkfree on 11.05.17.
 */
public class MedLabRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        MedLabResultSetExtractor extractor = new MedLabResultSetExtractor();
        return extractor.extractData(resultSet);
    }
}
