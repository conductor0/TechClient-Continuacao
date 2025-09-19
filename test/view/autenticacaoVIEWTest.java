/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package view;

import java.lang.reflect.Field;
import javax.swing.JTextField;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import view.autenticacaoVIEW;

public class autenticacaoVIEWTest {

    private autenticacaoVIEW autenticar;

    @Before
    public void setUp() {
        autenticar = new autenticacaoVIEW();
    }

    @After
    public void tearDown() {
        autenticar = null;
    }

    @Test
    public void loginTest() throws Exception {
        // Access the private JTextField via reflection
        Field field = autenticacaoVIEW.class.getDeclaredField("jTextField1");
        field.setAccessible(true);
        JTextField textField = (JTextField) field.get(autenticar);

        // Set the value to test
        textField.setText("1111");

        // Assert the value is exactly "3333"
        assertEquals("3333", textField.getText());
    }
}