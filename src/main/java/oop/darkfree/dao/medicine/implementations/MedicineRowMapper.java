package oop.darkfree.dao.medicine.implementations;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by darkfree on 04.06.17.
 */
public class MedicineRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        MedicineResultSetExtractor extractor = new MedicineResultSetExtractor();
        return extractor.extractData(resultSet);
    }
}
