package org.softwaretechnologies;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    void testEqualsAndHashCode() {
        EqualsVerifier.simple().forClass(Money.class).verify();
    }
}