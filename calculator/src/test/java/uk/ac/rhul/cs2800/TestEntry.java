package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class TestEntry {

  Entry en;

  // Test 1
  // test if the constructors can be used to create new entries
  // @SupressWarnings("unused") is used to ignore the warnings "unused variable" that the lines of
  // code, from the method testConstructor, raises
  @Test
  void testConstructor() {
    @SuppressWarnings("unused")
    Entry floatEntry = new Entry((float) 1.5, Type.NUMBER);

    @SuppressWarnings("unused")
    Entry stringEntry = new Entry("Hello World!", Type.STRING);

    @SuppressWarnings("unused")
    Entry typeEntry = new Entry(Symbol.MINUS, Type.SYMBOL);
  }

  // Test 2
  @Test
  void testStringGetter() throws BadTypeException {
    en = new Entry("Hello world", Type.STRING);
    assertTrue(en.getStr().equals("Hello world"));
  }

  // Test 3
  @Test
  void testFloatGetter() throws BadTypeException {
    en = new Entry(7.35f, Type.NUMBER);
    assertEquals(en.getValue(), 7.35f,
        "The get method should return the same value as set in the constructor.");
  }

  // Test 4
  @Test
  void testSymbolGetter() throws BadTypeException {
    en = new Entry(Symbol.PLUS, Type.SYMBOL);
    assertTrue(en.getOther().toString().equals("+ is addition sign"));
  }

  // Test 5
  @Test
  void testStringException() throws BadTypeException {
    en = new Entry("hello", Type.STRING);
    assertThrows(BadTypeException.class, () -> en.getOther(), "The entry is not of type Symbol");
  }

  // Test 6 test float type error
  @Test
  void testFloatException() {
    en = new Entry(1.689f, Type.NUMBER);
    assertThrows(BadTypeException.class, () -> en.getStr(),
        "The entry is of type float, not allowed to call string getter on the entry");
  }

  // Test 7
  @Test
  void testSymbolException() {
    en = new Entry(Symbol.LEFT_BRACKET, Type.SYMBOL);
    assertThrows(BadTypeException.class, () -> en.getValue(),
        "The entry is of type Symbol, not allowed to call float getter on the entry.");
  }

  // Test 8
  @Test
  void testToStringEntry() {
    en = new Entry(Symbol.MINUS, Type.SYMBOL);
    assertTrue(en.toString().equals("The entry is of type: Symbol data type"));
  }
}
