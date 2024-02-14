package com.test.test.mapper;

import com.test.test.DTO.INCOMEDTO;
import com.test.test.entity.INCOME;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class INCOMEmapper {
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static INCOMEDTO mapToINCOMEDTO(INCOME income){
        return new INCOMEDTO(
                income.getId(),
                income.getName(),
                income.getVALUE(),
                income.getDate()
        );
    }
    public static INCOME mapToINCOME(INCOMEDTO incomedto){
        return new INCOME(
                incomedto.getId(),
                incomedto.getName(),
                incomedto.getVALUE(),
                incomedto.getDate()
        );
    }
    private static String formatLocalDateToString(LocalDate date) {
        return date != null ? date.format(dateFormatter) : null;
    }

    private static LocalDate parseStringToLocalDate(String dateString) {
        return dateString != null ? LocalDate.parse(dateString, dateFormatter) : null;
    }
}
