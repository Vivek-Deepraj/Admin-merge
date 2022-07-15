package com.discom.springmvc.utils;

import javassist.*;

import java.io.Serializable;
import java.util.Map;
import java.util.Map.Entry;

public class PojoGenerator {

    public static CtClass generate(String className, Map<String, Class<?>> properties) throws NotFoundException,
            CannotCompileException {

        ClassPool pool = ClassPool.getDefault();

        //System.out.println(pool.find(className));
        try {
            //if(pool.find(className)!=null)
            {
                System.out.println("Is Frozen: " + pool.get(className).isFrozen());
                if (pool.get(className).isFrozen()) {
                    pool.get(className).defrost();
                    pool.get(className).replaceClassName(className, className);
                    pool.get(className).detach();
                    ClassLoader loader = Thread.currentThread().getContextClassLoader();
                    loader.loadClass(className);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        CtClass cc = pool.makeClass(className);

        // add this to define a super class to extend
        // cc.setSuperclass(resolveCtClass(MySuperClass.class));

        // add this to define an interface to implement
        cc.addInterface(resolveCtClass(Serializable.class));

        for (Entry<String, Class<?>> entry : properties.entrySet()) {

            cc.addField(new CtField(resolveCtClass(entry.getValue()), entry.getKey(), cc));

            // add getter
            cc.addMethod(generateGetter(cc, entry.getKey(), entry.getValue()));

            // add setter
            cc.addMethod(generateSetter(cc, entry.getKey(), entry.getValue()));
        }

        return cc;//cc.toClass();
    }

    private static CtMethod generateGetter(CtClass declaringClass, String fieldName, Class fieldClass)
            throws CannotCompileException {

        String getterName = "get" + fieldName.substring(0, 1).toUpperCase()
                + fieldName.substring(1);

        StringBuffer sb = new StringBuffer();
        sb.append("public ").append(fieldClass.getName()).append(" ")
                .append(getterName).append("(){").append("return this.")
                .append(fieldName).append(";").append("}");
        return CtMethod.make(sb.toString(), declaringClass);
    }

    private static CtMethod generateSetter(CtClass declaringClass, String fieldName, Class fieldClass)
            throws CannotCompileException {

        String setterName = "set" + fieldName.substring(0, 1).toUpperCase()
                + fieldName.substring(1);

        StringBuffer sb = new StringBuffer();
        sb.append("public void ").append(setterName).append("(")
                .append(fieldClass.getName()).append(" ").append(fieldName)
                .append(")").append("{").append("this.").append(fieldName)
                .append("=").append(fieldName).append(";").append("}");
        return CtMethod.make(sb.toString(), declaringClass);
    }

    private static CtClass resolveCtClass(Class clazz) throws NotFoundException {
        ClassPool pool = ClassPool.getDefault();
        return pool.get(clazz.getName());
    }
}