package com.example.csrf_demo.utils;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SetUtils {
    private SetUtils(){}

    public static final <T> Set<T> newHashSet(T... objs) {
        Set<T> set = new HashSet<T>();
        Collections.addAll(set, objs);
        return set;
    }
}

