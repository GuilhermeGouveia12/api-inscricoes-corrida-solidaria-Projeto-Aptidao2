package br.com.corridasolidaria.api_inscricoes;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class Inscricao {
    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "O e-mail é obrigatório")
    @Email(message = "Informe um e-mail válido")
    private String email;

    @Min(value = 14, message = "A idade mínima é 14 anos")
    private int idade;

    @NotBlank(message = "A distância é obrigatória")
    @Pattern(regexp = "KM_5|KM_10",
            message = "A distância deve ser KM_5 ou KM_10")
    private String distancia;

    public Inscricao() {
    }

    public Inscricao(String nome, String email, int idade, String distancia) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.distancia = distancia;
    }

    public boolean possuiIdadeValidaParaDistancia() {
        return !"KM_10".equals(distancia) || idade >= 18;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

}