/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.second;

import java.util.Date;
import javax.persistence.Entity;

/**
 *
 * @author Michael
 */
@Entity
public class Employee extends Person{
    private int soScrNr;
    private float wage;
    private String taxClass;

    public Employee(int soScrNr, float wage, String taxClass, String firstName, String lastName, Date birthDate, int age, boolean isMarried) {
        super(firstName, lastName, birthDate, age, isMarried);
        this.soScrNr = soScrNr;
        this.wage = wage;
        this.taxClass = taxClass;
    }

    public Employee(){}

    public int getSoScrNr() {
        return soScrNr;
    }

    public void setSoScrNr(int soScrNr) {
        this.soScrNr = soScrNr;
    }

    public float getWage() {
        return wage;
    }

    public void setWage(float wage) {
        this.wage = wage;
    }

    public String getTaxClass() {
        return taxClass;
    }

    public void setTaxClass(String taxClass) {
        this.taxClass = taxClass;
    }
    
}
