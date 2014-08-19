package com.wipro.wess.ods.log;


public class TestLogs {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        if(Error.isErrorEnabled()){
            Error.PDM_TECHNICAL_ERROR.format(ErrorMinorCode.PDMError001, new Exception("Technical error"));
        }
    }

}
