package org.example.app.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Employee {

    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private String position;

    @NonNull
    private String phone;

    public boolean hasId() {
        return id != null;
    }
}
