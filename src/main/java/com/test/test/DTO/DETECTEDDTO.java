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
public class DETECTEDDTO {
    private long id;
    private byte[] photo;
    private LocalDate date;
}
