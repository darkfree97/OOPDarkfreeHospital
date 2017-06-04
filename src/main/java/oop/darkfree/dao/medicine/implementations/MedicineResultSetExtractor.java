package oop.darkfree.dao.medicine.implementations;

import oop.darkfree.models.medicine.implementation.Medicine;
import oop.darkfree.models.medicine.interfaces.EMedicineType;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by darkfree on 04.06.17.
 */
public class MedicineResultSetExtractor implements ResultSetExtractor {
    @Override
    public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        Medicine medicine = new Medicine();
        medicine.setName(resultSet.getString("name"));
        medicine.setType(EMedicineType.valueOf(resultSet.getString("medicine_type")));
        medicine.setAppointment(resultSet.getString("appointment"));
        medicine.setPrice(resultSet.getDouble("price"));
        return medicine;
    }
}
