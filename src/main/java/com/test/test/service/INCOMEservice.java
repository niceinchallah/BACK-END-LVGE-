package com.test.test.service;

import com.test.test.DTO.INCOMEDTO;

import java.util.List;

public interface INCOMEservice {
    INCOMEDTO createINCOME(INCOMEDTO incomedto);
    INCOMEDTO getINCOMEbyid(Long INCOMEid);
    List<INCOMEDTO> getAllINCOMES();
    INCOMEDTO updateINCOME(Long INCOMEid,INCOMEDTO updatedINCOME);
    void deleteINCOME(Long INCOMEid);
}
