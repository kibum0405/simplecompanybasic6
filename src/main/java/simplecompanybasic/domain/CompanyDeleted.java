package simplecompanybasic.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import simplecompanybasic.domain.*;
import simplecompanybasic.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class CompanyDeleted extends AbstractEvent {

    private Long code;

    public CompanyDeleted(Company aggregate) {
        super(aggregate);
    }

    public CompanyDeleted() {
        super();
    }
}
//>>> DDD / Domain Event
