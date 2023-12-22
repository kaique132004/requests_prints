package com.example.demo.requests_archives;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;

public record RequestReq(
        String id_request,
        String name_archive_request,
        String method_payment_request,
        String status_payment
) {
}
