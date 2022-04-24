package com.lpy.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liangpengyu
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrivateMethod {
    private int age;

    private int ageAdd(){
        return this.age++;
    }
}
