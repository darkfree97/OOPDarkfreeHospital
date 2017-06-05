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
        JdbcTemplate insert = new JdbcTemplate(dataSource);
        insert.update("INSERT INTO medecine (name, medicine_type, appointment, price) VALUES(?,?,?,?)",new Object[] {
                medicine.getName(),
                medicine.getType(),
                medicine.getAppointment(),
                medicine.getPrice()
        });

    }

    @Override
    public void updateMedicine(String key, Medicine medicine) {
        JdbcTemplate update = new JdbcTemplate(dataSource);
        update.update("UPDATE medecine SET name = ?, medicine_type = ?, appointment = ?, price = ? WHERE name = ?",new Object[] {
                medicine.getName(),
                medicine.getType(),
                medicine.getAppointment(),
                medicine.getPrice(),
                key
        });
    }

    @Override
    public void deleteMedicine(String name) {
        JdbcTemplate delete = new JdbcTemplate(dataSource);
        delete.update("DELETE FROM medecine WHERE name = ?",
                new Object[] { name });
    }
}
