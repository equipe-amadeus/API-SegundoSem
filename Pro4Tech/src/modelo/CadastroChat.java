/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author lobat
 */
public class CadastroChat {
    public String remetente;
    public String mensagem;
    public String destinatario;
    public LocalTime hora;

     public String getRemetente() {
        return remetente;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
}
