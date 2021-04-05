package com.BDB.AppLocation.Dto;

public class ResponseDto {
    private String msm;
    private boolean valid;

    public ResponseDto(String msm, boolean valid) {
        this.msm = msm;
        this.valid = valid;
    }

    public String getMsm() {
        return msm;
    }

    public void setMsm(String msm) {
        this.msm = msm;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
