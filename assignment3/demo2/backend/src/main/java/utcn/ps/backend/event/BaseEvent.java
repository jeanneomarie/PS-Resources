package utcn.ps.backend.event;

import lombok.Data;

@Data
public class BaseEvent {
    private final EventType type;
}
