package com.discom.springmvc.model;

import com.discom.springmvc.utils.PojoGenerator;
import javassist.CtClass;

import java.util.HashMap;
import java.util.Map;


public class DynamicModel {

    static PojoGenerator pojoGenerator = new PojoGenerator();
    Class[] field = {DynamicField.class};

    public static CtClass generatePojo(String[] fields) throws Exception {
        Map<String, Class<?>> props = new HashMap<String, Class<?>>();
        //props.put("foo", Integer.class);
        for (String field : fields) {
            props.put(field.trim(), String.class);
        }
        return pojoGenerator.generate("DynamicModel", props);
    }

}