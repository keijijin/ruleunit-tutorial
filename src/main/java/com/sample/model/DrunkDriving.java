package com.sample.model;

import org.kie.api.definition.type.ClassReactive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ClassReactive
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrunkDriving {
    private Double alcohol;
    private Integer point;
}
