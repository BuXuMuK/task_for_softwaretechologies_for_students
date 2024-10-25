package org.softwaretechnologies;

import nl.jqno.equalsverifier.EqualsVerifier;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


@SuppressWarnings("ALL")
//@Disabled
public class EqualsHashCodeTest {
    static class A {
        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        @Override
        public int hashCode() {
            return 33;
        }
    }

    static class B {
        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        @Override
        public int hashCode() {
            Random random = new Random();
            return random.nextInt();
        }
    }

    static class C {
        int a;

        @Override
        public boolean equals(Object o) {
            return a == ((C) o).a;
        }

        @Override
        public int hashCode() {
            return 77;
        }
    }

    static class D {
        int a;

        @Override
        public boolean equals(Object obj) {
            if(obj == null) return false;
            return obj instanceof D;
        }

        @Override
        public int hashCode() {
            return a;
        }
    }

    static class E {
        int a;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            E f = (E) o;

            return a == f.a;
        }

        @Override
        public int hashCode() {
            return a;
        }
    }

    @Test
    public void validate() {
        boolean a = EqualsVerifier.simple().forClass(A.class).report().isSuccessful();
        boolean b = EqualsVerifier.simple().forClass(B.class).report().isSuccessful();
        boolean c = EqualsVerifier.simple().forClass(C.class).report().isSuccessful();
        boolean d = EqualsVerifier.simple().forClass(D.class).report().isSuccessful();
        boolean e = EqualsVerifier.simple().forClass(E.class).report().isSuccessful();
        assertTrue(e);
        /*
         * Какие классы содержат верную пару equals hashCode.
         * Невалидным может быть только один из методов.
         * Встатьте нужные выражения assertTrue или assertFalse для переменных a b c d e
   */
        assertTrue(a); // A неверно
        assertFalse(b); // B неверно
        assertFalse(c);  // C правильно
        assertFalse(d); // D неверно, так как hashCode зависит от `a`, а equals не учитывает его
        assertTrue(e);  // E правильно
    }
}
