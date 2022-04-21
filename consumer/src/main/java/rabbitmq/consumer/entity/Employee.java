package rabbitmq.consumer.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Employee {
    @JsonProperty
    private String employeeId;
    @JsonProperty
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthdate;
    
    private String name;
    public Employee(){

    }

    public Employee(String employeeId, LocalDate birthdate, String name) {
        super();
        this.employeeId = employeeId;
        this.birthdate = birthdate;
        this.name = name;
    }
}
