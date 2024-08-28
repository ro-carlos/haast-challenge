package com.challenge.utils;

import java.lang.annotation.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Annotation used to determine if class extended by
 * BaseTest is a Web Test or Api Test
 *
 * @author Carlos Rodriguez
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TestInfo {
	TestType testType() default TestType.WEB;
}
