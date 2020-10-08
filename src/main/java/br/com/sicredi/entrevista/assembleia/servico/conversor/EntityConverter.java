package br.com.sicredi.entrevista.assembleia.configuracao.converter;

import org.springframework.stereotype.Component;

import java.util.List;

/***
 * @param <D> Classe DTO
 * @param <E> Classe Entity
 */
@Component
public interface EntityMapper<D, E> {

    E toEntity(D dto);
    D toDto(E entity);
    List<E> toEntity(List<D> dtoList);
    List<D> toDto(List<E> entityList);

}