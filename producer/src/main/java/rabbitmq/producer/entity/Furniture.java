package rabbitmq.producer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Furniture {
    private String color;
    private String material;
    private String name;
    private Integer price;
    private Long size;
}
