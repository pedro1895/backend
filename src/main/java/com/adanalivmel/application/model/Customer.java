package com.adanalivmel.application.model;

import org.springframework.data.annotation.Id;

public class Customer implements Entity {
	
    private static final long serialVersionUID = -4520817576460991014L;
    
    @Id
    public String id;
    private String nome;
    private String cpf;

    public Customer(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Customer() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = 31 * result + (this.cpf == null ? 0 : this.cpf.hashCode());
        result = 31 * result + (this.id == null ? 0 : this.id.hashCode());
        result = 31 * result + (this.nome == null ? 0 : this.nome.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Customer other = (Customer)obj;
        if (this.cpf == null ? other.cpf != null : !this.cpf.equals(other.cpf)) {
            return false;
        }
        if (this.id == null ? other.id != null : !this.id.equals(other.id)) {
            return false;
        }
        return !(this.nome == null ? other.nome != null : !this.nome.equals(other.nome));
    }

    public String toString() {
        return "Customer [id=" + this.id + ", nome=" + this.nome + ", cpf=" + this.cpf + "]";
    }
}
