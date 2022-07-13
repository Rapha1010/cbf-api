package com.iec.cbfapi.connections;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RabbitMQConnection {
  private static final String NOME_EXCHANGE = "amq.direct";

  private AmqpAdmin amqpAdmin;

  public RabbitMQConnection(AmqpAdmin amqpAdmin){
    this.amqpAdmin = amqpAdmin;
  }

  private Queue queue(String queueName){
    return new Queue(queueName, true, false, false);
  }

  private DirectExchange directExchange() {
    return new DirectExchange(NOME_EXCHANGE);
  }

  private Binding relacionamento(Queue fila, DirectExchange troca){
    return new Binding(fila.getName(), Binding.DestinationType.QUEUE, troca.getName(), fila.getName(), null);
  }

  //está função é executada assim que a classe é instanciada pelo Spring, devido a anotação @Component
  @PostConstruct
  private void addQueue(){
    Queue eventos = this.queue("EVENTOS");
    Queue torneio   = this.queue("TORNEIO");

    DirectExchange exchange = this.directExchange();

    Binding ligacaoEventos = this.relacionamento(eventos, exchange);
    Binding ligacaoTorneio   = this.relacionamento(torneio, exchange);

    //Criando as filas no RabbitMQ
    this.amqpAdmin.declareQueue(eventos);
    this.amqpAdmin.declareQueue(torneio);

    this.amqpAdmin.declareExchange(exchange);

    this.amqpAdmin.declareBinding(ligacaoEventos);
    this.amqpAdmin.declareBinding(ligacaoTorneio);
  }
}