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
@Document(collection = "orders")
public class Order {

    @Id
    private String id;
    private String renterId;
    private String vehicleId;
    private String startDate;
    private String endDate;
    private BigDecimal total;
}