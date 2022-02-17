package com.greenfoxacademy.normalexam.models;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public enum Type {
    APPETIZER("appetizer"),
    SOUP("soup"),
    MAIN_COURSE("main course"),
    DESSERT("dessert"),
    UNKNOWN("unknown");

    private final String displayName;

    Type(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static Type parse(String label) {
        for (Type type : Type.values()) {
            if (type.displayName.equals(label)) {
                return type;
            }
        }
        return Type.UNKNOWN;
    }

    public static List<Type> allTypes(){
        List<Type> types = Arrays.stream(Type.values()).collect(Collectors.toList());
        types.remove(Type.UNKNOWN);
        return types;
    }

}
