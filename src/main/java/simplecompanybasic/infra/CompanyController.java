package simplecompanybasic.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import simplecompanybasic.domain.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/companies")
@Transactional
public class CompanyController {

    @Autowired
    CompanyRepository companyRepository;

    @RequestMapping(
        value = "companies/{id}/createcompany",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Company createCompany(
        @PathVariable(value = "id") Long id,
        @RequestBody CreateCompanyCommand createCompanyCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /company/createCompany  called #####");
        Optional<Company> optionalCompany = companyRepository.findById(id);

        optionalCompany.orElseThrow(() -> new Exception("No Entity Found"));
        Company company = optionalCompany.get();
        company.createCompany(createCompanyCommand);

        companyRepository.save(company);
        return company;
    }

    @RequestMapping(
        value = "companies/{id}/updatecompany",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Company updateCompany(
        @PathVariable(value = "id") Long id,
        @RequestBody UpdateCompanyCommand updateCompanyCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /company/updateCompany  called #####");
        Optional<Company> optionalCompany = companyRepository.findById(id);

        optionalCompany.orElseThrow(() -> new Exception("No Entity Found"));
        Company company = optionalCompany.get();
        company.updateCompany(updateCompanyCommand);

        companyRepository.save(company);
        return company;
    }
}
//>>> Clean Arch / Inbound Adaptor
