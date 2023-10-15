package br.com.kauanhenrique.todolist.Utils;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class Utils {

    public static void copyNonNullProperties(Object source, Object target){
        BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
    }

    //Campos Nulos
    //Toda propriedade nula será atribuido para o "BeanUtils"
    public static String[]getNullPropertyNames(Object source){
        final BeanWrapper src = new BeanWrapperImpl(source);// (BeanWrapper) Interface que fornece acesso as propriedades de um objeto

        PropertyDescriptor[] pds = src.getPropertyDescriptors(); //Obter propriedades do objeto

        Set<String> emptyNames = new HashSet<>();

        for (PropertyDescriptor pd: pds){
            Object srcValue = src.getPropertyValue(pd.getName());
            if(srcValue == null){
                emptyNames.add(pd.getName());
            }
            }
            String[] result = new String[emptyNames.size()];
            return emptyNames.toArray(result);
        }
    }
