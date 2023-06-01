package com.asv.demo.adapters.controllers;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MessageRequest {
    private String id;
    private String text;
    private String createdAt;
}
