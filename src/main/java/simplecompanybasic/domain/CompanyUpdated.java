package simplecompanybasic.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import simplecompanybasic.domain.*;
import simplecompanybasic.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class CompanyUpdated extends AbstractEvent {

    private Long code;
    private String name;
    private String industry;
    private Date foundedDate;

    public CompanyUpdated(Company aggregate) {
        super(aggregate);
    }

    public CompanyUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
