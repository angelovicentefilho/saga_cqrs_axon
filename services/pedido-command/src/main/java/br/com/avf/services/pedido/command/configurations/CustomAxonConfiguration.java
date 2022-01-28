package br.com.avf.services.pedido.command.configurations;

import br.com.avf.services.pedido.command.aggregates.PedidoAggregate;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-01-28, Friday
 */
@Configuration
public class CustomAxonConfiguration {

    @Bean
    EventSourcingRepository<PedidoAggregate> pedidoAggregateEventSourcingRepository(EventStore eventStore) {
        return EventSourcingRepository
                .builder(PedidoAggregate.class)
                .eventStore(eventStore).build();
    }
}
