package br.com.sicredi.entrevista.assembleia.teste.servico.conversor;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractConverter<DTO, Entity> implements EntityConverter<DTO, Entity> {

    public abstract DTO toDto(Entity entity);

    public abstract Entity toEntity(DTO dto);

    public List<DTO> toDto(List<Entity> entityList) {
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<Entity> toEntity(List<DTO> dtoList) {
        return dtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }

}