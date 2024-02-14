package com.test.test.service;

import com.test.test.DTO.DETECTEDDTO;

import java.util.List;

public interface DETECTEDservice {
    DETECTEDDTO createDETECTED(DETECTEDDTO detecteddto);
    DETECTEDDTO getDETECTEDbyid(Long DETECTEDID);
    List<DETECTEDDTO> getAllDETECTED();
    DETECTEDDTO updateDETECTED(Long DETECTEDid,DETECTEDDTO updatedDETECTED);
    void deleteDETECTED(Long DETECTEDid);
}
