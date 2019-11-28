package TestJavaassist;

import javassist.*;

import java.io.IOException;

/**
 * 测试使用JAVAassist生成一个新类
 */
public class Demo01 {
    public static void main(String[] args) throws CannotCompileException, NotFoundException, IOException {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.makeClass("TestJavaassist.Emp");
        //创建属性
        CtField f = CtField.make("private int empo;", cc);
        CtField f2 = CtField.make("private String name;", cc);
        cc.addField(f);
        cc.addField(f2);
        //创建方法
        CtMethod m1 = CtMethod.make("\n" +
                "    public int getEmpo() {\n" +
                "        return empo;\n" +
                "    }",cc);

        CtMethod m2 = CtMethod.make("public void setEmpo(int empo) {\n" +
                "        this.empo = empo;\n" +
                "    }",cc);
        cc.addMethod(m1);
        cc.addMethod(m2);
        //创建构造器
        CtConstructor constructor = new CtConstructor(new CtClass[]{CtClass.intType,pool.get("java.lang.String")},cc);
        constructor.setBody("{this.empo = empo;this.name= name;}");
        cc.addConstructor(constructor);
        cc.writeFile("C:\\Users\\liuha\\Documents\\GitHub\\train_Java\\TestAnnotation\\src\\TestJavaassist\\MYjava");//将上面构造好的类写入到这个路径中
        System.out.println("生成类成功");



    }
}
