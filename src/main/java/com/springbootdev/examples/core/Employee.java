package com.springbootdev.examples.core;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class Employee implements Serializable {

    private String id;
    private String name;
}
