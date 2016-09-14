package com.relaxhaha.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by yangyang on 2016/9/12.
 */
public final class BeanCopyHelper {

    private BeanCopyHelper(){
    }
    public static void copyProperties(Object from, Object to) {
        if(from == null || to == null)
        {
            return ;
        }
        Class<?> classFrom = from.getClass();
        Class<?> classTo = to.getClass();
        copeyFields(from, to, classFrom, classTo, true);
    }
    private static void copeyFields(Object from, Object to, Class<?> classFrom, Class<?> classTo,boolean isNeedToDeep) {
        Field[] fromFields = classFrom.getDeclaredFields();
        Field[] toFields = classTo.getDeclaredFields();
        if(isNeedToDeep){
            if(classFrom.getSuperclass()!=null){
                Field[] superFrom = classFrom.getSuperclass().getDeclaredFields();
                Field[] result=new Field[fromFields.length+superFrom.length];
                System.arraycopy(fromFields,0,result,0,fromFields.length);
                System.arraycopy(superFrom,0,result,fromFields.length,superFrom.length);
                fromFields = result;
            }
            if(classTo.getSuperclass()!=null){
                Field[] superTo = classTo.getSuperclass().getDeclaredFields();
                Field[] result=new Field[toFields.length+superTo.length];
                System.arraycopy(toFields,0,result,0,toFields.length);
                System.arraycopy(superTo,0,result,toFields.length,superTo.length);
                toFields = result;
            }
        }
        for(int i = 0; i < fromFields.length; i++){
            for(int j = 0; j < toFields.length; j++){
                if(fromFields[i].getName().equals(toFields[j].getName())
                        && fromFields[i].getType().equals(toFields[j].getType())){
                    fromFields[i].setAccessible(true);
                    toFields[j].setAccessible(true);
                    try {
                        if( ! Modifier.toString(toFields[j].getModifiers()).contains("final")){ // 如果属性不是final的 fixed 2015－08-31
                            toFields[j].set(to, fromFields[i].get(from));
                        };
                    } catch (Exception e) {
                        throw new RuntimeException("fail to BeanCopyHelper.copyProperties", e);
                    }
                    break;
                }
            }
        }
    }
}
