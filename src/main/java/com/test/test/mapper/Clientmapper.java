package com.test.test.mapper;

import com.test.test.DTO.ClientDTO;
import com.test.test.entity.Client;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class Clientmapper {
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static ClientDTO mapToClientDTO(Client client) {
        return new ClientDTO(
                client.getId(),
                client.getName(),
                client.getBrand(),
                client.getModel(),
                client.getDate(),
                client.getPhotoUrl() // Utilisation de l'URL de la photo
        );
    }

    public static Client mapToClient(ClientDTO clientDTO) {
        return new Client(
                clientDTO.getId(),
                clientDTO.getName(),
                clientDTO.getBrand(),
                clientDTO.getModel(),
                clientDTO.getDate(),
                null // Pas besoin de mapper la photo ici, car elle est stockée sous forme d'URL
        );
    }

    private static String formatLocalDateToString(LocalDate date) {
        return date != null ? date.format(dateFormatter) : null;
    }

    private static LocalDate parseStringToLocalDate(String dateString) {
        return dateString != null ? LocalDate.parse(dateString, dateFormatter) : null;
    }
}
