package net.aydini.mom.samom.maper;

import java.lang.reflect.Field;

import net.aydini.mom.common.service.filler.FieldFiller;
import net.aydini.mom.mapper.MegaObjectMaper;
import net.aydini.mom.samom.filler.SpringAwareFillerFactory;

/**
 * 
 * @@author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 */
public class SpringAwareObjectMapper extends MegaObjectMaper {

    @Override
    protected FieldFiller getFieldFiller(Field field) {
        return new SpringAwareFillerFactory().getFieldFiller(field, this);
    }

}