package br.com.corridasolidaria.api_inscricoes.controller;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.GetMapping;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.corridasolidaria.api_inscricoes.Inscricao;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/inscricoes")
public class InscricaoController {

    private final List<Inscricao> inscricoes = new ArrayList<>();

    @GetMapping
    public List<Inscricao> listarInscricoes() {
        return inscricoes;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarInscricao(@Valid @RequestBody Inscricao inscricao) {

        if (!inscricao.possuiIdadeValidaParaDistancia()) {
            return ResponseEntity.badRequest()
                    .body("Para participar do percurso de 10 km, é necessário ter pelo menos 18 anos.");
        }

        for (Inscricao existente : inscricoes) {
            if (existente.getEmail().equalsIgnoreCase(inscricao.getEmail())) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("Já existe uma inscrição cadastrada com este e-mail.");
            }
        }

        inscricoes.add(inscricao);

        return ResponseEntity.status(HttpStatus.CREATED).body(inscricao);
    }

    @PutMapping("/{email}")
    public ResponseEntity<?> atualizarInscricao(
            @PathVariable String email,
            @Valid @RequestBody Inscricao novaInscricao) {

        for (Inscricao inscricao : inscricoes) {

            if (inscricao.getEmail().equalsIgnoreCase(email)) {

                if (!novaInscricao.possuiIdadeValidaParaDistancia()) {
                    return ResponseEntity.badRequest()
                            .body("Para participar do percurso de 10 km, é necessário ter pelo menos 18 anos.");
                }

                inscricao.setNome(novaInscricao.getNome());
                inscricao.setIdade(novaInscricao.getIdade());
                inscricao.setDistancia(novaInscricao.getDistancia());

                return ResponseEntity.ok(inscricao);
            }
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> excluirInscricao(@PathVariable String email) {

        boolean removida = inscricoes.removeIf(inscricao ->
                inscricao.getEmail().equalsIgnoreCase(email));

        if (removida) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

}