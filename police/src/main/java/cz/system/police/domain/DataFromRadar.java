package cz.system.police.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "DATA_FROM_RADAR")
public class DataFromRadar {

    @Id
    @GeneratedValue
    private Long Id;
    private String driverName;
    private String spz;
    private Integer maxSpeedLimit;
    private Integer carSpeed;
    private Integer exceedSpeedLimit;
    private Date pictureDate;
    private PenaltyState state;
}
