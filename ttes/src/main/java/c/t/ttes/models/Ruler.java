package c.t.ttes.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Rulers")
@Builder
public class Ruler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;
    @Column
    private Integer age;
    @OneToMany(mappedBy = "ruler", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Planet> planetList;
}
