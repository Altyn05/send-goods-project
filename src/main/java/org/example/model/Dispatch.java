package org.example.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@Data
@AllArgsConstructor
@Builder
public class Dispatch {
    @Id
    private Long id;
    private Integer length;
    private Integer width;
    private Integer height;
    private Integer sumWeight;
    private String name;
    private Type type;

    @EqualsAndHashCode.Exclude
    @OneToMany
    @JoinColumn(name = "dispatch_id", referencedColumnName = "id")
    @Builder.Default
    private List<Good> goods = new ArrayList<>();
}
