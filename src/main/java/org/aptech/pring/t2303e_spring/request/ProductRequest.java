package org.aptech.pring.t2303e_spring.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    private String name;
    private Long price;
    private Integer qty;
    private String description;

}
