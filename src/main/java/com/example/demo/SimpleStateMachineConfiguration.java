package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.stereotype.Component;

import java.util.Set;

@Configuration
@EnableStateMachineFactory
@Slf4j
public class SimpleStateMachineConfiguration extends StateMachineConfigurerAdapter<State, Event> {


    @Override
    public void configure(StateMachineConfigurationConfigurer<State, Event> config) throws Exception {
        StateMachineListenerAdapter<State, Event> adapter = new StateMachineListenerAdapter<>(){
            @Override
            public void stateChanged(org.springframework.statemachine.state.State<State, Event> from, org.springframework.statemachine.state.State<State, Event> to) {
                log.info(String.format("stateChanged(from: %s, to: %s)", from, to));
            }
        } ;
        config.withConfiguration()
                .autoStartup(true)
                .listener(adapter);
    }


    @Override
    public void configure(StateMachineStateConfigurer<State, Event> states) throws Exception {
        states
                .withStates()
                .initial(State.INIT)
                .end(State.REJECTED)
                .end(State.APPROVED)
                .states(Set.of(State.values()));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<State, Event> transitions) throws Exception {
        transitions
                .withExternal().source(State.INIT).target(State.PEER_REVIEW).event(Event.PEER_REVIEW)
                .and()
                .withExternal().source(State.INIT).target(State.PRINCIPAL_REVIEW).event(Event.PRINCIPAL_REVIEW)
                .and()
                .withExternal().source(State.PEER_REVIEW).target(State.REJECTED).event(Event.REJECT)
                .and()
                .withExternal().source(State.PEER_REVIEW).target(State.APPROVED).event(Event.APPROVE);
    }
}

@Slf4j
class StateMachineApplicationRunner implements ApplicationRunner {
    private final StateMachineFactory<State, Event> stateMachineFactory;

    @Autowired
    StateMachineApplicationRunner(StateMachineFactory<State, Event> stateMachineFactory) {
        this.stateMachineFactory = stateMachineFactory;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        StateMachine<State, Event> stateMachine = stateMachineFactory.getStateMachine("111");
        stateMachine.start();
        stateMachine.sendEvent(Event.PEER_REVIEW);
        log.info("After peer regiew {}",stateMachine.getState());

    }
}

enum State {
    INIT,
    PEER_REVIEW,
    PRINCIPAL_REVIEW,
    REJECTED,
    APPROVED
}

enum Event {
    PEER_REVIEW,
    PRINCIPAL_REVIEW,
    REJECT,
    APPROVE
}