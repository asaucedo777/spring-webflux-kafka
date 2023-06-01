package com.asv.demo.adapters.controllers;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class MessageResponse {
    private String id;
    private String text;
    private String createdAt;
}
