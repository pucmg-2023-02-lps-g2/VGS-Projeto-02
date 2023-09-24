package project.system.VGS.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "vehicles")
public class Vehicle {

    @Id
    private String licensePlate ;
    private String brand;
    private String model;
    private int year;
    private BigDecimal pricePerHour;
    private boolean isAvaliable;
}
