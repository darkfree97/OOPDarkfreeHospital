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
    private static Examination temp;

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
        temp=null;
        examinations.forEach(p->{
            if(p.getId()==key){
                temp = p;
            }
        });
        examinations.set(examinations.indexOf(temp),examination);
    }

    @Override
    public void deleteExamination(int id) {
        temp=null;
        examinations.forEach(p->{
            if(p.getId()==id){
                temp = p;
            }
        });
        examinations.remove(temp);
    }

    @Override
    public void showAll() {
        examinations.forEach(p-> System.out.println(p));
    }
}
