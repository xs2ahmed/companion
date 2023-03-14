package com.wefind.companion.candidates;

import java.util.*;

public class ApiResponseEx<T> {
    private String result;
    private Map<String,String> metadata;
    private List<T> data ;

    public ApiResponseEx(String result) {
        this.result = result;
        metadata = new HashMap<>();
    }
    public void addMessage(String key, String value)
    {
        metadata.put(key,value);
    }
    public void addData(List<T> data)
    {
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public Map<String, String> getValues() {
        return metadata;
    }

    public List<T> getData() {
        return data;
    }
}
