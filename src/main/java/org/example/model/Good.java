package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    private Integer weight;
    @ManyToOne
    @JoinColumn(name = "dispatch_id",referencedColumnName = "id")
    @JsonIgnore
    private Dispatch dispatch;
}
