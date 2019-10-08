package org.cm.pro.mongo;


import org.bson.Document;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MongoUtils {
    static public <T> Document ConvertDocument(T obj, List includeList,List excludeList) throws Exception{
        Document doc=new Document();
        Class<?> objClass=obj.getClass();
        Field[] fields= objClass.getDeclaredFields();
        String fieldName;
        Method getMethod;
        Object fieldValue;
        for(Field f:fields){
            fieldName=f.getName();
            //include filter
            if(includeList!=null&&!includeList.contains(fieldName))continue;
            //exclude filter
            if(excludeList!=null&&excludeList.contains(fieldName))continue;

            getMethod=objClass.getMethod("get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1));
            fieldValue=getMethod.invoke(obj);
            // null value filter
            if(fieldValue==null)continue;
            doc.append(fieldName,getMethod.invoke(obj));
        }
        return doc;
    }

    static public <T> Document ConvertDocument(T obj,List useList)throws Exception{
        return ConvertDocument(obj,useList,null);
    };

    static public <T> Document ConvertDocument(T obj) throws Exception{
        return ConvertDocument(obj,null,null);
    }
}
