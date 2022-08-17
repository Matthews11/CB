package com.evaluacion2.dto;

public class Departamento {

    private Long id;

    private String depa;

    public Departamento() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepa() {
        return depa;
    }

    public void setDepa(String depa) {
        this.depa = depa;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Departamento{");
        sb.append("id=").append(id);
        sb.append(",depa='").append(depa).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
