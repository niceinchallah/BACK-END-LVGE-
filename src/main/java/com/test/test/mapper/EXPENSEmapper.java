package com.test.test.mapper;

import com.test.test.DTO.EXPENSEDTO;
import com.test.test.entity.EXPENSE;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EXPENSEmapper {
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static EXPENSEDTO mapToEXPENSEDTO(EXPENSE expense){
        return new EXPENSEDTO(
                expense.getId(),
                expense.getName(),
                expense.getVALUE(),
                expense.getDate()
        );
    }
    public static EXPENSE mapToEXPENSE(EXPENSEDTO expensedto){
        return new EXPENSE(
                expensedto.getId(),
                expensedto.getName(),
                expensedto.getVALUE(),
                expensedto.getDate()
        );
    }
    private static String formatLocalDateToString(LocalDate date) {
        return date != null ? date.format(dateFormatter) : null;
    }

    private static LocalDate parseStringToLocalDate(String dateString) {
        return dateString != null ? LocalDate.parse(dateString, dateFormatter) : null;
    }
}
