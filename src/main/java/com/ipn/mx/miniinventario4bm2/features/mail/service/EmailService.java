package com.ipn.mx.miniinventario4bm2.features.mail.service;

public interface EmailService {
    public void enviarCorreoEelectronico(String to, String subject, String text);
}
