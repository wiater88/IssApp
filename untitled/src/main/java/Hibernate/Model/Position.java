package Hibernate.Model;


import API.PositionNow.PositionNow;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.IOException;
import java.net.URL;

@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "Position")
@Data

public class Position extends BaseEntity {

    @Column(name = "Czas_Sprawdzenia")
    private String timestamp;

    @Column(name = "latitude")
    private String latitude;

    @Column
    private String longitude;

    public Position(String timestamp, String latitude, String longitude) {
        this.timestamp = timestamp;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Position() {
    }

}

