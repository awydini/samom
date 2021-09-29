package net.aydini.mom.samom.filler;

import java.lang.reflect.Field;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;

import net.aydini.mom.common.annotation.MapedField;
import net.aydini.mom.common.exception.MomBaseException;
import net.aydini.mom.common.service.maper.Maper;
import net.aydini.mom.common.service.maper.ObjectMaper;
import net.aydini.mom.filler.AnnotatedFieldFiller;
import net.aydini.mom.samom.holder.ApplicationContextHolder;
import net.aydini.mom.util.reflection.ReflectionUtil;
import net.aydini.mom.util.string.StringUtil;

/**
 * 
 * @@author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 */
public class SpringAwareFieldFiller  extends AnnotatedFieldFiller{

	private static final Logger log = LoggerFactory.getLogger( SpringAwareFieldFiller.class.getName() );

    SpringAwareFieldFiller(ObjectMaper objectMapper)
    {
        super(objectMapper);
    }

	@Override
	@SuppressWarnings("unchecked")
    protected Optional<Maper<Object,Object>> getMapedFieldMaper(MapedField mapedField)
    {
        if (!hasMaper(mapedField)) return Optional.empty();
        try
        {
            return Optional.of(ApplicationContextHolder.getApplicationContext().getBean(mapedField.maper()));
        }
        catch(NoSuchBeanDefinitionException e)
        {
            log.warn("bean with name {} not found.",StringUtil.toLowerFirstLetter(mapedField.maper().getSimpleName()));
            log.warn("trying to instantiate {} with default constructor." , mapedField.maper().getSimpleName());
        }
        return Optional.of((Maper<Object,Object>) ReflectionUtil.instantiate(mapedField.maper()));
    }

    @Override
    protected void onSetValueError(Exception exception, Field targetObjectField, Object object)
            throws MomBaseException {
        log.error("error setting {} to  field {}.cause : {}", object ,targetObjectField.getName(),exception);
        throw new MomBaseException(exception.getMessage(),exception);

    }

    @Override
    protected void onGetValueError(Exception exception, Field field) throws MomBaseException {
        log.error("error reading value of field {}.cause : {}",field.getName() ,exception);
        throw new MomBaseException(exception.getMessage(),exception);
    }
}
