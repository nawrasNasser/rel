package com.app.model.product;

import lombok.*;
import java.util.*;
import javax.persistence.*;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "products")
public class Product  {
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    private String  productCode;
    private String  productName;
    private String  description;
    private BigDecimal    standardCost;
    private BigDecimal    listPrice;
    private Integer targetLevel;
    private Integer reorderLevel;
    private Integer minimumReorderQuantity;
    private String  quantityPerUnit;
    private Boolean discontinued;
    @ApiModelProperty(allowableValues = "Camera, Laptop, Tablet, Phone") private String category;
    public Product(){}
}
