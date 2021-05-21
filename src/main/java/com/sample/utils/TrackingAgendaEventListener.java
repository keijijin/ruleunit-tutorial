package com.sample.utils;

import org.jboss.logging.Logger;
import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.DefaultAgendaEventListener;
import org.kie.api.event.rule.MatchCancelledEvent;
import org.kie.api.event.rule.MatchCreatedEvent;
import org.kie.api.event.rule.MatchEvent;

public class TrackingAgendaEventListener extends DefaultAgendaEventListener {
    Logger log = Logger.getLogger(TrackingAgendaEventListener.class);

    public void afterMatchFired(AfterMatchFiredEvent event) {
        super.afterMatchFired(event);
        log.debug("ルール発火 : " + createMsg(event)); //event.getMatch().getRule().getName() + " : " + event.getMatch().getObjects());
    }

    public void matchCreated(MatchCreatedEvent event) {
        super.matchCreated(event);
        log.debug("ルール適合 : " + createMsg(event)); //event.getMatch().getRule().getName() + " : " + event.getMatch().getObjects());
    }

    public void matchCancelled(MatchCancelledEvent event) {
        super.matchCancelled(event);
        log.debug("キャンセル : " + createMsg(event)); //event.getMatch().getRule().getName() + " : " + event.getMatch().getObjects());
    }

    private String createMsg(MatchEvent event) {
        return event.getMatch().getRule().getName() + " : " + event.getMatch().getObjects();
    }
}
