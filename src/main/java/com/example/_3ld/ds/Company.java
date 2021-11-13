package com.example._3ld.ds;

import javax.persistence.Entity;

@Entity
public class Company extends User {
    private String companyName;
    private String representative;

    public Company(String login, String password, String companyName, String representative) {
        super(login, password, UserType.Company);
        this.companyName = companyName;
        this.representative = representative;
    }
    public void update(Company company){
        if(company.getId()!=0){this.setId(company.getId());}
        if(company.getLogin()!=null){this.setLogin(company.getLogin());}
        if(company.getPassword()!=null){this.setPassword(company.getPassword());}
        if(company.getCompanyName()!=null) {this.companyName = company.getCompanyName();}
        if(company.getRepresentative()!=null) {this.representative = company.getRepresentative();}
    }

    public Company() {

    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRepresentative() {
        return representative;
    }

    public void setRepresentative(String representative) {
        this.representative = representative;
    }
}
