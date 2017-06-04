package oop.darkfree.dao.examination.interfaces;

import oop.darkfree.models.examination.implementation.Examination;

import java.util.List;

/**
 * Created by Darkfree on 28.03.2017.
 */
public interface IDaoExamination {
    List<Examination> getAll();
    Examination getExamination(int id);
    void createExamination(Examination examination);
    void updateExamination(Integer key, Examination examination);
    void deleteExamination(int id);
    void showAll();
}
