package org.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class Dispatch {
    @Id
    private Long id;
    private Integer length;
    private Integer width;
    private Integer height;
    private Integer sumWeight;
    private String name;
    private Type type;
    @OneToMany
    @JoinColumn(name = "dispatch_id", referencedColumnName = "id" )
    private List<Good> goods;
}
