package com.saasforge.keycloack.eventlistener;


import org.keycloak.events.Event;
import org.keycloak.events.EventListenerProvider;
import org.keycloak.events.admin.AdminEvent;
import org.keycloak.events.admin.AuthDetails;

import java.util.Map;

public class ChassiEventListener implements EventListenerProvider {
    @Override
    public void onEvent(Event event) {
        System.out.println(" ******************");
        Map<String, String> details = event.getDetails();

        for (String key : details.keySet()) {
            System.out.print(key.concat(":"));
            System.out.print(details.get(key));
        }
        System.out.println(" ******************");
    }

    @Override
    public void onEvent(AdminEvent adminEvent, boolean b) {
        System.out.println(" **********  ADMIN Event ********");
        AuthDetails details = adminEvent.getAuthDetails();

            System.out.println(details.getClientId());
            System.out.println(details.getIpAddress());
            System.out.println(details.getRealmId());
            System.out.println(details.getUserId());
        System.out.println(" ******************");
    }

    @Override
    public void close() {

    }
}
