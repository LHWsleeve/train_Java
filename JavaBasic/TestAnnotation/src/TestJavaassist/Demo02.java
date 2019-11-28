package TestJavaassist;

import javassist.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 *测试Javassist API
 */
public class Demo02 {
    public static void main(String[] args) throws NotFoundException, CannotCompileException, IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
//        test01();
//        test02();
//        test03();
        test04();
    }

    /**
     * 处理类基本方法
     */
    public static void test01() throws IOException, CannotCompileException, NotFoundException {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("TestJavaassist.emp");

        byte[] bytes = cc.toBytecode();
        System.out.println(Arrays.toString(bytes));
        System.out.println(cc.getName());//获取类名（包名+类名）
        System.out.println(cc.getSimpleName());//获取简单类名
//        System.out.println(cc.getSuperclass());//获得父类
//        System.out.println(cc.getInterfaces());//获得接口
    }
    //测试产生新的方法
    public static void test02() throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("TestJavaassist.Emp");

        //CtMethod m = CtNewMethod.make("public int add(int a, int b){return a+b;}", cc);
        CtMethod m =new CtMethod(CtClass.intType,"add",
                new CtClass[]{CtClass.intType,CtClass.intType},cc);
        m.setModifiers(Modifier.PUBLIC);
        m.setBody("{System.out.println(\"wwww\");return $1+$2;}");

        cc.addMethod(m);

        //通过反射调用新生成的方法
        Class clazz = cc.toClass();
        Object obj = clazz.newInstance();//通过调用Emp无参构造器，创建新的Emp对象
        Method method = clazz.getDeclaredMethod("add",int.class,int.class);
        Object result = method.invoke(obj,200,300);
        System.out.println(result);

    }

    //
    public static void test03() throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("TestJavaassist.Emp");

     CtMethod cm = cc.getDeclaredMethod("sayHello", new CtClass[]{CtClass.intType});
     //加载方法体前面。当然也可以加后面，甚至某一行
     cm.insertBefore("System.out.println($1);System.out.println(\"start!!\");");
        //通过反射调用新生成的方法
        Class clazz = cc.toClass();
        Object obj = clazz.newInstance();//通过调用Emp无参构造器，创建新的Emp对象
        Method method = clazz.getDeclaredMethod("sayHello",int.class);
        Object result = method.invoke(obj,300);
        System.out.println(result);
    }
//属性操作
    public static void test04() throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("TestJavaassist.Emp");

        //创建新属性
        CtField f1 = new CtField(CtClass.intType,"salary",cc);
        f1.setModifiers(Modifier.PRIVATE);
        cc.addField(f1);

        //增加set和get方法
        CtNewMethod.getter("getsalary", f1);
        CtNewMethod.getter("setsalary", f1);
    }
//构造器方法操作
    public static void test05() throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("TestJavaassist.Emp");

        CtConstructor[] cs = cc.getConstructors();
        for (CtConstructor c:cs){
            System.out.println(c.getName());
        }




    }
    }
