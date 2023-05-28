package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Filter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id","length","width","height","sumWeight","name"})

public class Dispatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer length;
    private Integer width;
    private Integer height;
    private Integer sumWeight;
    private String name;
    @Enumerated(EnumType.STRING)
    private Type type;

    @OneToMany(mappedBy = "dispatch")
    @Builder.Default
    @JsonIgnore
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Good> goods = new ArrayList<>();
}
