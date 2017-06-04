package oop.darkfree.dao.examination.implementations;

import oop.darkfree.dao.examination.interfaces.IDaoExamination;
import oop.darkfree.models.examination.implementation.Examination;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Darkfree on 28.03.2017.
 */
public class DaoExamination implements IDaoExamination {
    List<Examination> examinations = new ArrayList<>();

    public DaoExamination() {
    }

    public DaoExamination(List<Examination> examinations) {
        this.examinations = examinations;
    }

    public void setExaminations(List<Examination> examinations) {
        this.examinations = examinations;
    }

    @Override
    public String toString() {
        return "DaoExamination{" +
                "examinations=" + examinations +
                '}';
    }

    @Override
    public List<Examination> getAll() {
        return examinations;
    }

    @Override
    public Examination getExamination(int id) {
        return examinations.stream().filter(item->item.getId()==id).findFirst().get();
    }

    @Override
    public void createExamination(Examination examination) {
        examinations.add(examination);
    }

    @Override
    public void updateExamination(Integer key, Examination examination) {
        examinations.forEach(p->{
            if(p.getId()==key){
                p = examination;
            }
        });
    }

    @Override
    public void deleteExamination(int id) {
        examinations.stream().filter(p->p.getId()==id).forEach(p->examinations.remove(p));
    }

    @Override
    public void showAll() {
        examinations.forEach(p-> System.out.println(p));
    }
}
