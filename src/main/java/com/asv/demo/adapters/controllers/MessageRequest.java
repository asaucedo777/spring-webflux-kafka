package com.asv.demo.adapters.controllers;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class MessageRequest {
    private String id;
    private String text;
    private String createdAt;
}
