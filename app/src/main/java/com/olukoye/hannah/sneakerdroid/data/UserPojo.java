package com.olukoye.hannah.sneakerdroid.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")


public class UserPojo {


    @SerializedName("first_name")
    @Expose
    public String first_name;
    @SerializedName("last_name")
    @Expose
    public String last_name;
    @SerializedName("phone_number")
    @Expose
    public String phone_number;
    @SerializedName("project_code")
    @Expose
    public String project_code;
    @SerializedName("app_version")
    @Expose
    public String app_version;
    @SerializedName("message")
    @Expose
    public String message;
    public Map<String, Object> device_details = new HashMap<String, Object>();
    public Map<String, Object> participant_details = new HashMap<String, Object>();

    public String getFirst_name() {
            return first_name;
    }
    public void setFirst_name() {
        this.first_name = first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public void setLast_name() {
        this.last_name = last_name;
    }
    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getProject_code() {
        return project_code;
    }

    public void setProject_code(String project_code) {
        this.project_code = project_code;
    }

    public String getApp_version() {
        return app_version;
    }

    public void setApp_version(String app_version) {
        this.app_version = app_version;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getDevice_details() {
        return device_details;
    }

    public void setDevice_details(Map<String, Object> device_details) {
        this.device_details = device_details;
    }

    public Map<String, Object> getParticipant_details() {
        return this.participant_details;
    }

    public void setParticipant_details(String name, Object value) {
        this.participant_details.put(name, value);
    }
}
