package br.com.mdantas.domain;

import javax.persistence.*;
import java.util.List;

/**
 * @author marcelo.dantas
 */

@Entity
@Table(name = "TB_COMPUTADOR")
public class Computador {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "computador_seq")
    @SequenceGenerator(name = "computador_seq", sequenceName = "seq_computador", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "CODIGO", length = 10, nullable = false, unique = true)
    private String codigo;

    @Column(name = "DESCRICAO", length = 100, nullable = false)
    private String descricao;

    @ManyToMany(mappedBy = "computadores")
    private List<Aluno> alunos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
