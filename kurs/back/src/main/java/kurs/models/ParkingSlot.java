package kurs.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "parking_slot")
@Data
public class ParkingSlot implements Serializable {


    @Id
    @GeneratedValue
    private Long id;
    @JsonProperty
    @Column
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-dd-mm' 'hh:mm:ss", timezone = "Europe/Moscow")
    private Timestamp time_before;
    @Column
    @JsonProperty
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-dd-mm' 'hh:mm:ss", timezone = "Europe/Moscow")
    private Timestamp time_after;
    @Column
    @JsonProperty
    private Integer price_per_hour;
    @JsonProperty
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private SlotsStatus slotsStatus;
    @Column
    @JsonProperty
    private String photo_path;
    @Column
    @JsonProperty
    private String location;

}
