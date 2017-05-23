package oop.darkfree.dao.examination.implementations;

import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by darkfree on 11.05.17.
 */
public class ExaminationRowMapper implements RowMapper {
    DataSource dataSource;

    public ExaminationRowMapper(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        ExaminationsResultSetExtractor extractor = new ExaminationsResultSetExtractor(dataSource);
        return extractor.extractData(resultSet);
    }
}
