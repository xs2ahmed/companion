package com.wefind.companion.candidates;

import java.util.List;

public class ApiResponse<T>
{
    //Success or failure
    private  String result;
    //reason of failure.
    private  String reason;
    //any descriptions
    private  String description;

    //actual data requested or expected in response only valid in case of success of desired call
    private List<T> data;

    //used in case of success
    public ApiResponse(String response, String description, List<T> data) {
        this.result = response;
        this.description = description;
        this.data = data;
    }
    //normally used in case of failure,
    public ApiResponse(String response, String description, String reason) {
        this.result = response;
        this.description = description;
        this.reason= reason;
    }


    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
