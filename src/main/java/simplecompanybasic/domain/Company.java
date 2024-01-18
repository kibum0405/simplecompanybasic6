package simplecompanybasic.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import simplecompanybasic.BasicApplication;
import simplecompanybasic.domain.CompanyDeleted;

@Entity
@Table(name = "Company_table")
@Data
//<<< DDD / Aggregate Root
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long code;

    private String name;

    private String industry;

    private Date foundedDate;

    @PostPersist
    public void onPostPersist() {
        CompanyDeleted companyDeleted = new CompanyDeleted(this);
        companyDeleted.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {}

    public static CompanyRepository repository() {
        CompanyRepository companyRepository = BasicApplication.applicationContext.getBean(
            CompanyRepository.class
        );
        return companyRepository;
    }

    //<<< Clean Arch / Port Method
    public void createCompany(CreateCompanyCommand createCompanyCommand) {
        //implement business logic here:

        BasicCreated basicCreated = new BasicCreated(this);
        basicCreated.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void updateCompany(UpdateCompanyCommand updateCompanyCommand) {
        //implement business logic here:

        CompanyUpdated companyUpdated = new CompanyUpdated(this);
        companyUpdated.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
