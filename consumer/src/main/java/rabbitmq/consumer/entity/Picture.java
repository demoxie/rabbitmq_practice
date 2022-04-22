package rabbitmq.consumer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Picture {
    private String name;
    private String type;
    private String source;
    private Long size;
}
