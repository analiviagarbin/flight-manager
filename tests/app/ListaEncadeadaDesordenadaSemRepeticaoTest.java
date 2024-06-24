package tests.app;

import app.ListaEncadeadaDesordenadaSemRepeticao;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ListaEncadeadaDesordenadaSemRepeticaoTest {

    @Test
    public void testInsertionAndRemoval() {
        ListaEncadeadaDesordenadaSemRepeticao<Integer> list = new ListaEncadeadaDesordenadaSemRepeticao<>();

        // Test insertion at the beginning
        try {
            list.insiraNoInicio(1);
            assertEquals(1, list.getPrimeiro());
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }

        // Test insertion at the end
        try {
            list.insiraNoFim(2);
            assertEquals(2, list.getUltimo());
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }

        // Test removal from the beginning
        try {
            list.removaDoInicio();
            assertEquals(2, list.getPrimeiro());
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }

        // Test removal from the end
        try {
            list.removaDoFim();
            assertTrue(list.isVazia());
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }
    }

    @Test
    public void testClone() {
        ListaEncadeadaDesordenadaSemRepeticao<Integer> list1 = new ListaEncadeadaDesordenadaSemRepeticao<>();
        try {
            list1.insiraNoInicio(1);
            ListaEncadeadaDesordenadaSemRepeticao<Integer> list2 = (ListaEncadeadaDesordenadaSemRepeticao<Integer>) list1.clone();
            assertNotSame(list1, list2);
            assertEquals(list1.getPrimeiro(), list2.getPrimeiro());
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }
    }

    @Test
    public void testEquals() {
        ListaEncadeadaDesordenadaSemRepeticao<Integer> list1 = new ListaEncadeadaDesordenadaSemRepeticao<>();
        ListaEncadeadaDesordenadaSemRepeticao<Integer> list2 = new ListaEncadeadaDesordenadaSemRepeticao<>();
        try {
            list1.insiraNoInicio(1);
            list2.insiraNoInicio(1);
            assertTrue(list1.equals(list2));
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }
    }

    @Test
    public void testToString() {
        ListaEncadeadaDesordenadaSemRepeticao<Integer> list = new ListaEncadeadaDesordenadaSemRepeticao<>();
        try {
            list.insiraNoInicio(1);
            assertEquals("1", list.toString());
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }
    }
}