package com.example.demo.entity;

import com.example.demo.requests_archives.RequestReq;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.Date;

@Table(name = "requests")
@Entity(name = "requests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_request")
public class EntityRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id_request;

    private Timestamp date_request;

    private String name_archive_request;

    private String method_payment_request;

    private String status_payment;

    public EntityRequest (RequestReq requestReq){

        Timestamp ts = Timestamp.from(ZonedDateTime.now().toInstant());
        this.date_request = ts;
        this.name_archive_request = requestReq.name_archive_request();
        this.method_payment_request = requestReq.method_payment_request();
        this.status_payment = "Processing";
    }
}
