package com.alo.digital.herramientas.demonios.sendEmail.email;

public class EmailPojo {

    String userName;
    String empresaName;
    String empresaLogo;

    public EmailPojo() {
    }

    public EmailPojo(String userName, String empresaName, String empresaLogo) {
        this.userName = userName;
        this.empresaName = empresaName;
        this.empresaLogo = empresaLogo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmpresaName() {
        return empresaName;
    }

    public void setEmpresaName(String empresaName) {
        this.empresaName = empresaName;
    }

    public String getEmpresaLogo() {
        return empresaLogo;
    }

    public void setEmpresaLogo(String empresaLogo) {
        this.empresaLogo = empresaLogo;
    }
}
