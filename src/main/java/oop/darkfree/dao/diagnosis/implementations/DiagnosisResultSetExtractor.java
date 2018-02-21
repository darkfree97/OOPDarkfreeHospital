package oop.darkfree.dao.diagnosis.implementations;

import oop.darkfree.dao.medicine.implementations.DBDaoMedicine;
import oop.darkfree.models.diagnosis.implementation.Diagnosis;
import oop.darkfree.models.medicine.implementation.Medicine;
import oop.darkfree.models.medicine.interfaces.EMedicineType;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by darkfree on 10.05.17.
 */
public class DiagnosisResultSetExtractor implements ResultSetExtractor {

    @Override
    public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setDiagnosis(resultSet.getString(1));
        diagnosis.setMedicine(
                new Medicine(
                        resultSet.getString("name"),
                        EMedicineType.valueOf(resultSet.getString("medicine_type")),
                        resultSet.getString("appointment"),
                        resultSet.getDouble("price")));
        diagnosis.setTakingMedicine(resultSet.getString("tackingMedicine"));
        diagnosis.setTherapyPeriodByDays(resultSet.getInt("therapyPeriodByDays"));
        return diagnosis;
    }
}
