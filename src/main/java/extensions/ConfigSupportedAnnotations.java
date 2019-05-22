package com.tests.qa.testbase.extensions;


import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.Annotations;
import webElement.Locators;

import java.lang.reflect.Field;

/**
 * Overrides the @FindBy.
 *
 * @author Nilmi
 */
public class ConfigSupportedAnnotations extends Annotations {

    public ConfigSupportedAnnotations(Field field) {
        super(field);
    }

    @Override
    public By buildBy() {
        FindBy findBy = this.getField().getAnnotation(FindBy.class);
        By by = Locators.getBy(findBy.how(), findBy.using());
        return by == null ? super.buildBy() : by;
    }

}
