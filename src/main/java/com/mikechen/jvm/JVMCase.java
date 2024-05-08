package com.mikechen.jvm;

/**
 * JVM内存模型详解
 *
 * @author mikechen
 */

public class JVMCase {

        // 常量
        public final static String MAN_SEX_TYPE = "man";

        //静态变量
        public static String WOMAN_SEX_TYPE = "woman";

        public static void main(String[] args) {
            Teacher teacher = new Teacher();

            teacher.setName("mikechen");
            teacher.setSexType(MAN_SEX_TYPE);
            teacher.setAge(35);

            JVMCase jvmcase = new JVMCase();

            // 调用非静态方法
            jvmcase.sayHello(teacher);

            // 调用静态方法
            print(teacher);
        }

        // 常规静态方法
        public static void print(Teacher teacher) {
            System.out.println("name: " + teacher.getName() + " sex:" + teacher.getSexType());
        }


            // 非静态方法
        public void sayHello(Teacher teacher) {
            System.out.println(teacher.getName() + "say: hello");
        }
}

class Teacher{

        String name;
        String sexType;
        int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSexType() {
            return sexType;
        }












        public void setSexType(String sexType) {
            this.sexType = sexType;
        }

        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
}


