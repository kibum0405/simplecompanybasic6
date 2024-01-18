package simplecompanybasic.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import simplecompanybasic.domain.*;
import simplecompanybasic.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class BasicCreated extends AbstractEvent {

    private Long code;
    private String name;
    private String industry;
    private Date foundedDate;

    public BasicCreated(Company aggregate) {
        super(aggregate);
    }

    public BasicCreated() {
        super();
    }
}
//>>> DDD / Domain Event
