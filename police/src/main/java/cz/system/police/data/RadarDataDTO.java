package cz.system.police.data;

import cz.system.police.domain.PenaltyState;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class RadarDataDTO {
    private Long Id;
    private String driverName;
    private String spz;
    private Integer maxSpeedLimit;
    private Integer carSpeed;
    private Integer exceedSpeedLimit;
    private Date pictureDate;
    private PenaltyState state;
}
