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
        medicalLab.setLabName(resultSet.getString("med_lab_name"));
        medicalLab.setRes(resultSet.getString("result_of_exm"));
        medicalLab.setExtrPoint(ExtremePoint.valueOf(resultSet.getString("extreme_point")));
        medicalLab.setPrice(resultSet.getDouble("price"));
        return medicalLab;
    }
}
