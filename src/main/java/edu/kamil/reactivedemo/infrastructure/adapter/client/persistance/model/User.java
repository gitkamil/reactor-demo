package edu.kamil.reactivedemo.infrastructure.adapter.client.persistance.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("users")
@Data
public class User {
    @Id
    private Long id;
    private String name;

}