package com.ttrzcinski.utils;


public class StringHasValue {
    public boolean hasValue(String given) {
        IStringHasValue newTradeChecker = (String str) -> str != null && str.trim().length() > 0;
        return newTradeChecker.hasValue(given);
    }
}