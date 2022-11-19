package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStack {
  private Stack st;

  @BeforeEach
  void setup() {
    st = new Stack();
  }

  // Test1
  // test if a new empty stack can be created.
  // @SupressWarnings("unused") is used to ignore the warning "unused variable" that the line of
  // code, from the method test(), raises
  @Test
  void test() {
    @SuppressWarnings("unused")
    Stack st = new Stack();
  }

  // Test 2
  @Test
  void testSize() {
    assertEquals(st.size(), 0, "The size of an empty stack should be 0.");
  }

  // Test 3
  @Test
  void testPush() {
    st.push(new Entry(1.7f));
    assertEquals(st.size(), 1, "Pushing once should return stack size 1.");
  }

  // Test 4
  @Test
  void testPushAllTypes() {
    assertEquals(st.size(), 0, "There are no entries in the stack.");

    st.push(new Entry(2.67f));
    st.push(new Entry("Hello World"));
    st.push(new Entry(Symbol.PLUS));

    assertEquals(st.size(), 3, "Pushing 3 items should return stack size 3.");
  }

  // Test 5
  @Test
  void testEmptyPop() {
    assertThrows(EmptyStackException.class, () -> st.pop(), "You cannot pop an empty stack.");
  }

  // Test 6
  @Test
  void testPopAndPush() {
    assertThrows(EmptyStackException.class, () -> st.pop(),
        "There are no items in the stack, cannot pop an empty stack!");
    st.push(new Entry(74.38f));
    assertEquals(st.size(), 1, "Pushing once should give stack size 1.");
  }

  // Test 7
  @Test
  void testPushAndPop() throws BadTypeException {
    st.push(new Entry("1st entry"));
    st.push(new Entry(Symbol.TIMES));

    assertEquals(st.pop().getOther(), Symbol.TIMES,
        "Pushing twice and popping once should return the last item pushed.");
    assertEquals(st.size(), 1, "Pushing twice and popping once should give stack size 1.");
  }

  // Test 8
  @Test
  void testPushAndPopAll() throws BadTypeException {
    st.push(new Entry(Symbol.INVALID));
    st.push(new Entry(4.66f));

    assertEquals(st.pop().getValue(), 4.66f,
        "Pushing twice and popping once should return the last item pushed: 4.66.");
    assertEquals(st.size(), 1, "Pushing twice an popping once should give stack size 1.");

    assertEquals(st.pop().getOther(), Symbol.INVALID,
        "Pushing twice and popping twice should return the first item pushed.");
    assertEquals(st.size(), 0, "Pushing twice and popping twice should return stack size 0.");
  }

  // Test 9
  @Test
  void testPushOncePopTwice() throws BadTypeException {
    st.push(new Entry(Symbol.INVALID));
    assertEquals(st.size(), 1, "Pushing once should give stack size 1.");
    assertEquals(st.pop().getOther(), Symbol.INVALID,
        "Pushing once and popping once should return the pushed item.");

    assertEquals(st.size(), 0, "Pushing once and popping once should return stack size 0.");
    assertThrows(EmptyStackException.class, () -> st.pop(),
        "Pushing once and popping twice is not allowed.");
  }

  // Test 10
  @Test
  void testTop() throws BadTypeException {
    st.push(new Entry("This is the 1st item"));
    st.push(new Entry(Symbol.DIVIDE));
    st.push(new Entry(5.987f));

    assertTrue((st.top().getStr()).equals("This is the 1st item"),
        "Top should return the first item pushed in the stack.");
  }

  // Test 11
  @Test
  void testEmptyStackTop() {
    assertThrows(EmptyStackException.class, () -> st.top(),
        "An empty stack does not have a top item.");
  }
}
