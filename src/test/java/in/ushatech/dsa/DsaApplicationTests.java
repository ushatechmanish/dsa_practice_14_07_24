package in.ushatech.dsa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DsaApplicationTests {

	@Test
	void contextLoads() {
	}

	// Singly LinkedList test starts
	@Test
	public void pushMethodTest() {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
		singlyLinkedList.push(5);
		Assertions.assertEquals(1, singlyLinkedList.size);
		Assertions.assertEquals(5, singlyLinkedList.tail.value);
		Assertions.assertEquals(5, singlyLinkedList.head.value);
		singlyLinkedList.push(10);
		Assertions.assertEquals(2, singlyLinkedList.size);
		Assertions.assertEquals(10, singlyLinkedList.tail.value);
		Assertions.assertEquals(10, singlyLinkedList.head.next.value);
		Assertions.assertEquals(5, singlyLinkedList.head.value);
	}

	@Test
	public void popMethodTest() {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
		singlyLinkedList.push(5);
		singlyLinkedList.push(10);

		Assertions.assertEquals(10, singlyLinkedList.pop().value);
		Assertions.assertEquals(5, singlyLinkedList.tail.value);
		Assertions.assertEquals(1, singlyLinkedList.size);
		Assertions.assertEquals(5, singlyLinkedList.pop().value); // 5
		Assertions.assertEquals(0, singlyLinkedList.size); // 0
		Assertions.assertNull(singlyLinkedList.pop()); // The SLL does not exist
	}

	@Test
	public void insertMethodTest() {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
		Assertions.assertNotEquals(null, singlyLinkedList.push(5)); // Success
		Assertions.assertNotEquals(null, singlyLinkedList.push(10)); // Success
		Assertions.assertNotEquals(null, singlyLinkedList.push(15)); // Success
		Assertions.assertNotEquals(null, singlyLinkedList.push(20)); // Success

		Assertions.assertEquals(true, singlyLinkedList.insert(12, 2)); // True
		Assertions.assertEquals(false, singlyLinkedList.insert(13, 100)); // False
		Assertions.assertEquals(5, singlyLinkedList.size); // 5
		Assertions.assertEquals(5, singlyLinkedList.head.value); // 5
		Assertions.assertEquals(10, singlyLinkedList.head.next.value); // 10
		Assertions.assertEquals(12, singlyLinkedList.head.next.next.value); // 12
	}

	@Test
	public void testPushAndGet() {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
		singlyLinkedList.push(5);
		singlyLinkedList.push(10);
		singlyLinkedList.push(15);
		singlyLinkedList.push(20);
		assertEquals(5, singlyLinkedList.get(0).value);
		assertEquals(10, singlyLinkedList.get(1).value);
		assertEquals(15, singlyLinkedList.get(2).value);
		assertEquals(20, singlyLinkedList.get(3).value);

		assertThrows(IndexOutOfBoundsException.class, () -> {
			int valueNotExpected = singlyLinkedList.get(4).value;
		});
	}

	@Test
	@Disabled
	public void testRotate() {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
		singlyLinkedList.push(5);
		singlyLinkedList.push(10);
		singlyLinkedList.push(15);
		singlyLinkedList.push(20);
		singlyLinkedList.push(25);
		singlyLinkedList.rotate(3);

		String result = singlyLinkedList.rotate(3);
		assertEquals("20->25->5->10->15", result);

	}

	@Test
	public void testSetAtIndex() {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
		singlyLinkedList.push(1);
		singlyLinkedList.push(2);

		Assertions.assertTrue(singlyLinkedList.set(0, 10)); // True
		Assertions.assertTrue(singlyLinkedList.set(1, 20)); // True
		Assertions.assertTrue(singlyLinkedList.head.value == 10); // 10
		Assertions.assertTrue(singlyLinkedList.head.next.value == 20);// 20
	}

}
