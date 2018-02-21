package oop.darkfree.dao.examination.implementations;

import oop.darkfree.dao.diagnosis.implementations.DBDaoDiagnosis;
import oop.darkfree.dao.doctor.implementations.DBDaoDoctor;
import oop.darkfree.dao.examination.interfaces.IDaoExamination;
import oop.darkfree.dao.medicalLaboratories.implementations.DBDaoMedLab;
import oop.darkfree.dao.patient.implementations.DBDaoPatient;
import oop.darkfree.models.diagnosis.implementation.Diagnosis;
import oop.darkfree.models.doctor.implementation.Doctor;
import oop.darkfree.models.examination.implementation.Examination;
import oop.darkfree.models.medicalLaboratories.implementation.MedicalLab;
import oop.darkfree.models.patient.implementation.Patient;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by darkfree on 11.05.17.
 */
public class DBDaoExaminations implements IDaoExamination {
    private DataSource dataSource;

    public DBDaoExaminations() {
    }

    public DBDaoExaminations(DataSource dataSource) {

        this.dataSource = dataSource;
    }

    public void setDataSource(DataSource ds) {
        dataSource = ds;
    }

    @Override
    public List<Examination> getAll() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("SELECT * FROM examinations,doctors,patients,diagnoses,medecine,med_labs\n" +
                "WHERE doctors.id=examinations.doctor_id\n" +
                "AND patients.id=examinations.patient_id\n" +
                "AND diagnoses.id=examinations.diagnosis_id\n" +
                "AND medecine.id=diagnoses.medicine_id\n" +
                "AND med_labs.id=examinations.med_lab_id", new ExaminationRowMapper());
    }

    @Override
    public Examination getExamination(int id) {
        return getAll().stream().filter(p->p.getId().intValue()==id).findFirst().get();
    }

    @Override
    public void createExamination(Examination examination) {
        JdbcTemplate insert = new JdbcTemplate(dataSource);
        insert.update("INSERT INTO examinations (patient_id,doctor_id,diagnosis_name,med_lab_name,date) VALUES(?,?,?,?,?)",
                new Object[]{
                examination.getPatient().getPerson().getId(),
                examination.getDoctors().stream().findFirst().get().getPerson().getId(),
                examination.getDiagnoses().stream().findFirst().get().getDiagnosis(),
                examination.getMedLabs().stream().findFirst().get().getLabName(),
                examination.getDate()
                });

//        try {
//            patient.createPatient((Patient) examination.getPatient());
//            doctor.createDoctor((Doctor) examination.getDoctors().stream().findFirst().get());
//            diagnosis.createDiagnosis((Diagnosis) examination.getDiagnoses().stream().findFirst().get());
//            medLab.createMedicalLab((MedicalLab) examination.getMedLabs().stream().findFirst().get());
//        }catch (Exception e){}

    }

    @Override
    public void updateExamination(Integer key, Examination examination) {
        JdbcTemplate update = new JdbcTemplate(dataSource);
        update.update("UPDATE examinations SET patient_id = ?, doctor_id = ?, diagnosis_name = ?, med_lab_name = ?, date = ? WHERE id = ?",new Object[] {
                examination.getPatient().getPerson().getId(),
                examination.getDoctors().stream().findFirst().get().getPerson().getId(),
                examination.getDiagnoses().stream().findFirst().get().getDiagnosis(),
                examination.getMedLabs().stream().findFirst().get().getLabName(),
                examination.getDate(),
                key
        });
    }

    @Override
    public void deleteExamination(int id) {
        JdbcTemplate delete = new JdbcTemplate(dataSource);
        delete.update("DELETE FROM examinations WHERE id = ?",
                new Object[] { id });
    }

    @Override
    public void showAll() {
        getAll().forEach(p-> System.out.println(p));
    }
}
