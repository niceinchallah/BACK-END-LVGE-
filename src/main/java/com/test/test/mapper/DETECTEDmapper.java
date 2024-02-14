package com.test.test.mapper;

import com.test.test.DTO.DETECTEDDTO;
import com.test.test.entity.DETECTED;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class DETECTEDmapper {
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static DETECTEDDTO mapToDETECTEDDTO(DETECTED detected){
        return new DETECTEDDTO(
                detected.getId(),
                detected.getPhoto(),
                detected.getDate()
        );
    }
    public static DETECTED mapToDETECTED(DETECTEDDTO detecteddto){
        return new DETECTED(
                detecteddto.getId(),
                detecteddto.getPhoto(),
                detecteddto.getDate()
        );
    }
    private static String formatLocalDateToString(LocalDate date) {
        return date != null ? date.format(dateFormatter) : null;
    }

    private static LocalDate parseStringToLocalDate(String dateString) {
        return dateString != null ? LocalDate.parse(dateString, dateFormatter) : null;
    }
}
