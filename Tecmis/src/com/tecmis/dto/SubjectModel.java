package com.tecmis.dto;

import java.util.Map;

public class SubjectModel {

    private final Map<String, String> subjectnamemap = Map.of(
            "ICT01 Theory", "ICT01_t_attendance",
            "ICT02 Theory", "ICT02_t_attendance",
            "ICT02 Practical", "ICT02_p_attendance",
            "ICT03 Theory", "ICT03_t_attendance",
            "ICT03 Practical", "ICT03_p_attendance",
            "ICT04 Theory", "ICT04_t_attendance",
            "ICT04 Practical", "ICT04_p_attendance"
    );

    private final Map<String, String> subjectcodemap = Map.of(
            "ICT01_t_attendance", "ICT01 Theory",
            "ICT02_t_attendance", "ICT02 Theory",
            "ICT02_p_attendance", "ICT02 Practical",
            "ICT03_t_attendance", "ICT03 Theory",
            "ICT03_p_attendance", "ICT03 Practical",
            "ICT04_t_attendance", "ICT04 Theory",
            "ICT04_p_attendance", "ICT04 Practical"
    );

    public Map<String, String> getSubjectNameMap(){
        return subjectnamemap;
    }
    public Map<String, String> getSubjectCodeMap(){
        return subjectcodemap;
    }

    public String getSingleSubjectNameMap(String key){

        return subjectnamemap.get(key);
        // return ICT01_t_attendance
    }
    public String getSingleSubjectCodeMap(String key){
        // return ICT01 Theory
        return subjectcodemap.get(key);
    }



}
