package net.aydini.mom.samom.filler;

import java.lang.reflect.Field;

import net.aydini.mom.common.annotation.MapedField;
import net.aydini.mom.common.service.filler.FieldFiller;
import net.aydini.mom.common.service.maper.ObjectMaper;
import net.aydini.mom.filler.FillerFactory;
import net.aydini.mom.samom.holder.ApplicationContextHolder;
import net.aydini.mom.util.string.StringUtil;

public class SpringAwareFillerFactory extends FillerFactory {

	@Override
	public FieldFiller getFieldFiller(Field field, ObjectMaper objectMaper) {
		if (!field.isAnnotationPresent(MapedField.class))
			return getSimpleFieldFiller(objectMaper);
		String beanName = StringUtil.toLowerFirstLetter(field.getAnnotation(MapedField.class).maper().getSimpleName());
		if (ApplicationContextHolder.getApplicationContext().containsBean(beanName))
			return new SpringAwareFieldFiller(objectMaper);
		return createAnnotatedFieldFiller(objectMaper);
	}

}
