package cz.system.police.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class RadarData {

    private String driverName;
    private String spz;
    private Integer maxSpeedLimit;
    private Integer carSpeed;
    private Date pictureDate;

}
