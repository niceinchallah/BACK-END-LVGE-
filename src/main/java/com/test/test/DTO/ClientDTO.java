package com.test.test.DTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
    private long id;
    private String name;
    private String brand;
    private String model;
    private LocalDate date;
    private byte[] photo;  // Mettez à jour le type de données pour stocker l'image en tant que tableau de bytes
}
