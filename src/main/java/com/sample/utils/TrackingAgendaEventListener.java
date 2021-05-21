package com.sample.utils;

import org.jboss.logging.Logger;
import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.DefaultAgendaEventListener;
import org.kie.api.event.rule.MatchCancelledEvent;
import org.kie.api.event.rule.MatchCreatedEvent;

public class TrackingAgendaEventListener extends DefaultAgendaEventListener {
    Logger log = Logger.getLogger(TrackingAgendaEventListener.class);

    public void afterMatchFired(AfterMatchFiredEvent event) {
        super.afterMatchFired(event);
        log.debug("ルール発火 : " + event.getMatch().getRule().getName() + " : " + event.getMatch().getObjects());
    }

    public void matchCreated(MatchCreatedEvent event) {
        super.matchCreated(event);
        log.debug("ルール適合 : " + event.getMatch().getRule().getName() + " : " + event.getMatch().getObjects());
    }

    public void matchCancelled(MatchCancelledEvent event) {
        super.matchCancelled(event);
        log.debug("キャンセル : " + event.getMatch().getRule().getName() + " : " + event.getMatch().getObjects());
    }
}
