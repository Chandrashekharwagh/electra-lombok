package com.electra.model;


import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Supplier {
    private Long id;
    private String name;
    private String contactInfo;
}
