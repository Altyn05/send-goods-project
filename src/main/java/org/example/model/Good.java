package org.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Good {
    @Id
    private Long id;
    private String name;
    private BigDecimal price;
    private Integer weight;
}
