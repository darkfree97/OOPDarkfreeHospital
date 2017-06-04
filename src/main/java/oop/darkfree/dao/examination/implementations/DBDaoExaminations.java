package oop.darkfree.dao.examination.implementations;

import oop.darkfree.dao.examination.interfaces.IDaoExamination;
import oop.darkfree.models.examination.implementation.Examination;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by darkfree on 11.05.17.
 */
public class DBDaoExaminations implements IDaoExamination {
    private DataSource dataSource;
    public void setDataSource(DataSource ds) {
        dataSource = ds;
    }

    public DBDaoExaminations() {
    }

    public DBDaoExaminations(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Examination> getAll() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("SELECT * FROM examinations", new ExaminationRowMapper(dataSource));
    }

    @Override
    public Examination getExamination(int id) {
        return null;
    }

    @Override
    public void createExamination(Examination examination) {

    }

    @Override
    public void updateExamination(Examination examination) {

    }

    @Override
    public void deleteExamination(int id) {

    }

    @Override
    public void showAll() {
    }
}
