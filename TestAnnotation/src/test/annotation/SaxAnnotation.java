package test.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ·@Target-作用：用于描述注解的使用范围（即：被描述的注解可以用在什么地方）
 * 所修饰范围|取值Element Type
 * package 包|PACKAGE
 * 类、接口、枚举、Annotation类型       |TYPE
 * 类型成员（方法、构造方法、成员变量、枚举值)|CONSTRUCTOR：用于描述构造器方法、成员变量、枚举|FIELD：用于描述域值）METHOD：用于描述方法
 * 方法参数和本地变量       |LOCAL_VARIABLE：用于描述局部变量|PARAMETER：用于描述参数
 * -@Target（value=ElementType.TYPE）
 */
//@Target(value = ElementType.METHOD)//表示这个注解只能放在方法前面
@Target(value = {ElementType.METHOD,ElementType.ANNOTATION_TYPE,ElementType.PACKAGE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SaxAnnotation {
    String studentName() default "";//参数名，参数类型,默认值
    int age() default 0;
    int id() default -1;//-1表示不存在
    String[] schools();
}
