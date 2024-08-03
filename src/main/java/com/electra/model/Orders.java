package com.electra.model;

import java.util.Date;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Orders {
    private Long id;
    private int productId;
    private int customerId;
    private Date orderDate;
}
