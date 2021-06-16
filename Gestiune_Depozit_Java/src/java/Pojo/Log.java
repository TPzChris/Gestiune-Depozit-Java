/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

import java.sql.Date;

/**
 *
 * @author papad
 */
public class Log {
    
    private int idLog;
    private String operation;
    private Date dataAct;
    private int idLogin;

    public Log() {
    }

    public Log(int idLog, String operation, Date dataAct, int idLogin) {
        this.idLog = idLog;
        this.operation = operation;
        this.dataAct = dataAct;
        this.idLogin = idLogin;
    }

    public int getIdLog() {
        return idLog;
    }

    public void setIdLog(int idLog) {
        this.idLog = idLog;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    public Date getDataAct() {
        return dataAct;
    }

    public void setDataAct(Date dataAct) {
        this.dataAct = dataAct;
    }
    
    
    
}
