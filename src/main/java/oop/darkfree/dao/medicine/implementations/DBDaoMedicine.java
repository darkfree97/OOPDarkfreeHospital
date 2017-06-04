package oop.darkfree.dao.medicine.implementations;

import oop.darkfree.dao.medicine.interfaces.IDaoMedicine;
import oop.darkfree.models.medicine.implementation.Medicine;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by darkfree on 04.06.17.
 */
public class DBDaoMedicine implements IDaoMedicine {
    DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DBDaoMedicine() {
    }

    public DBDaoMedicine(DataSource dataSource) {

        this.dataSource = dataSource;
    }

    @Override
    public List<Medicine> getAll() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("SELECT * FROM medecine", new MedicineRowMapper());
    }

    @Override
    public Medicine getMedicine(String name) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return ((List<Medicine>) select.query("SELECT * FROM medecine", new MedicineRowMapper())).stream().filter(p->p.getName().equals(name)).findFirst().get();
    }

    @Override
    public void createMedicine(Medicine medicine) {

    }

    @Override
    public void updateMedicine(String key, Medicine medicine) {

    }

    @Override
    public void deleteMedicine(String name) {

    }
}
