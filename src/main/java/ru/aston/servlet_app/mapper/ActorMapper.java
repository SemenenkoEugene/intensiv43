package ru.aston.servlet_app.mapper;

import lombok.NoArgsConstructor;
import ru.aston.servlet_app.dto.ActorDto;
import ru.aston.servlet_app.entity.Actor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ActorMapper implements Mapper<Actor, ActorDto> {
    private static final ActorMapper INSTANCE = new ActorMapper();

    public static ActorMapper getInstance() {
        return INSTANCE;
    }

    @Override
    public Actor mapFrom(ActorDto actorDto) {
        return Actor.builder()
                .name(actorDto.getName())
                .age(actorDto.getAge())
                .build();
    }

    @Override
    public ActorDto mapTo(Actor actor) {
        return new ActorDto(
                actor.getId(),
                actor.getName(),
                actor.getAge()
        );
    }


}
