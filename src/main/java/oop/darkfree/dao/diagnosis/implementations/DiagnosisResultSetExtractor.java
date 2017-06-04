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
    private DataSource dataSource;
    private DBDaoMedicine medicine;

    public DiagnosisResultSetExtractor(DataSource dataSource) {
        this.dataSource = dataSource;
        medicine = new DBDaoMedicine(dataSource);
    }

    @Override
    public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setDiagnosis(resultSet.getString(1));
        diagnosis.setMedicine(medicine.getMedicine(resultSet.getString("medicine")));
        diagnosis.setTakingMedicine(resultSet.getString(3));
        diagnosis.setTherapyPeriodByDays(resultSet.getInt(4));
        return diagnosis;
    }
}
