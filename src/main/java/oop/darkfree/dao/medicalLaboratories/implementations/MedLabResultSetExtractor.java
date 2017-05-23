package oop.darkfree.dao.medicalLaboratories.implementations;

import oop.darkfree.models.medicalLaboratories.implementation.MedicalLab;
import oop.darkfree.models.medicalLaboratories.interfaces.ExtremePoint;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by darkfree on 11.05.17.
 */
public class MedLabResultSetExtractor implements ResultSetExtractor {
    @Override
    public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        MedicalLab medicalLab = new MedicalLab();
        medicalLab.setLabName(resultSet.getString(1));
        medicalLab.setRes(resultSet.getString(2));
        medicalLab.setExtrPoint(ExtremePoint.valueOf(resultSet.getString(3)));
        medicalLab.setPrice(resultSet.getDouble(4));
        return medicalLab;
    }
}
