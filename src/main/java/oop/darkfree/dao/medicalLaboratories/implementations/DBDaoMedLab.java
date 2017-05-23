package oop.darkfree.dao.medicalLaboratories.implementations;

import oop.darkfree.dao.medicalLaboratories.interfaces.IDaoMedLab;
import oop.darkfree.models.medicalLaboratories.implementation.MedicalLab;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by darkfree on 11.05.17.
 */
public class DBDaoMedLab implements IDaoMedLab{
    private DataSource dataSource;
    public void setDataSource(DataSource ds) {
        dataSource = ds;
    }

    public DBDaoMedLab() {
    }

    public DBDaoMedLab(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<MedicalLab> getAll() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("SELECT * FROM med_labs", new MedLabRowMapper());
    }

    @Override
    public MedicalLab getMedicalLab(String name) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return ((List<MedicalLab>)select.query("SELECT * FROM med_labs",new MedLabRowMapper())).stream().filter(p->p.getLabName().equals(name)).findFirst().get();
    }

    @Override
    public void createMedicalLab(MedicalLab medicalLab) {

    }

    @Override
    public void updateMedicalLab(MedicalLab medicalLab) {

    }

    @Override
    public void deleteMedicalLab(String name) {

    }
}
