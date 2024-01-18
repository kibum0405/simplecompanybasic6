package simplecompanybasic.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import simplecompanybasic.domain.*;

@Component
public class CompanyHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Company>> {

    @Override
    public EntityModel<Company> process(EntityModel<Company> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/createcompany")
                .withRel("createcompany")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/updatecompany")
                .withRel("updatecompany")
        );

        return model;
    }
}
