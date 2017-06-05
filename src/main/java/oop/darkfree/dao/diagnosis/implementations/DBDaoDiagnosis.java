package oop.darkfree.dao.diagnosis.implementations;

import oop.darkfree.dao.diagnosis.interfaces.IDaoDiagnosis;
import oop.darkfree.models.diagnosis.implementation.Diagnosis;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by darkfree on 10.05.17.
 */
public class DBDaoDiagnosis implements IDaoDiagnosis {
    private DataSource dataSource;
    public void setDataSource(DataSource ds) {
        dataSource = ds;
    }

    public DBDaoDiagnosis() {
    }

    public DBDaoDiagnosis(DataSource dataSource) {

        this.dataSource = dataSource;
    }

    @Override
    public List<Diagnosis> getAll() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("SELECT * FROM diagnoses", new DiagnosisRowMapper(dataSource));
    }

    @Override
    public Diagnosis getDiagnosis(String name) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return ((List<Diagnosis>) select.query("SELECT * FROM diagnoses", new DiagnosisRowMapper(dataSource))).stream().filter(p->p.getDiagnosis().equals(name)).findFirst().get();
    }

    @Override
    public void createDiagnosis(Diagnosis diagnosis) {
        JdbcTemplate insert = new JdbcTemplate(dataSource);
        insert.update("INSERT INTO diagnoses (diagnosis, medicine, tackingMedicine, therapyPeriodByDays) VALUES(?,?,?,?)", new Object[] {
                diagnosis.getDiagnosis(),
                diagnosis.getMedicine().getName(),
                diagnosis.getTakingMedicine(),
                diagnosis.getTherapyPeriodByDays()
        });
    }

    @Override
    public void updateDiagnosis(String key, Diagnosis diagnosis) {
        JdbcTemplate update = new JdbcTemplate(dataSource);
        update.update("UPDATE diagnoses SET diagnosis = ?, medicine = ?, tackingMedicine = ?, therapyPeriodByDays = ? WHERE diagnosis = ?",new Object[] {
                diagnosis.getDiagnosis(),
                diagnosis.getMedicine().getName(),
                diagnosis.getTakingMedicine(),
                diagnosis.getTherapyPeriodByDays(),
                key
        });
    }

    @Override
    public void deleteDiagnosis(String name) {
        JdbcTemplate delete = new JdbcTemplate(dataSource);
        delete.update("DELETE FROM diagnoses WHERE diagnosis = ?",
                new Object[] { name });
    }
}
