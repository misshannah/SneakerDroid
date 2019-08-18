package com.olukoye.hannah.sneakerdroid.data;

import java.util.HashMap;
import java.util.Map;

public class UserPojo {
    /*
"device_details": {
"device_model": "phone models",
"device_type": "device type",
"hardware": "device hardware",
"manufacturer": "device manufacturer"
}
  */

        private String first_name;
        private String last_name;
        private String phone_number;
        private String project_code;
        private String app_version;
        private String fcm_key;
        private Map<String, Object> device_details = new HashMap<String, Object>();
        private Map<String, Object> participant_details = new HashMap<String, Object>();

    public String getFirst_name() {
            return first_name;
    }
    public void setFirst_name() {
        this.first_name = first_name;
    }

    public Map<String, Object> getParticipant_details() {
        return this.participant_details;
    }

    public void setParticipant_details(String name, Object value) {
        this.participant_details.put(name, value);
    }
}
