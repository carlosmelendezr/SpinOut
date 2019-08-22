package com.carlosintranets.spinout.Objetos;

public class Bloque {
    private Integer id;
    private Integer Duracion;
    private Integer Velocidad;
    private Integer Intensidad;
    private Integer PosicionDorsal;
    private Integer PosicionManubrio;

    public Bloque() {

    }

    public Bloque(Integer duracion, Integer velocidad, Integer intensidad,
                  Integer posicionDorsal, Integer posicionManubrio) {
        Duracion = duracion;
        Velocidad = velocidad;
        Intensidad = intensidad;
        PosicionDorsal = posicionDorsal;
        PosicionManubrio = posicionManubrio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDuracion() {
        return Duracion;
    }

    public void setDuracion(Integer duracion) {
        Duracion = duracion;
    }

    public Integer getVelocidad() {
        return Velocidad;
    }

    public void setVelocidad(Integer velocidad) {
        Velocidad = velocidad;
    }

    public Integer getIntensidad() {
        return Intensidad;
    }

    public void setIntensidad(Integer intensidad) {
        Intensidad = intensidad;
    }

    public Integer getPosicionDorsal() {
        return PosicionDorsal;
    }

    public void setPosicionDorsal(Integer posicionDorsal) {
        PosicionDorsal = posicionDorsal;
    }

    public Integer getPosicionManubrio() {
        return PosicionManubrio;
    }

    public void setPosicionManubrio(Integer posicionManubrio) {
        PosicionManubrio = posicionManubrio;
    }
}
