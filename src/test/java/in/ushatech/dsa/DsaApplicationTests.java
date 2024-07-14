package in.ushatech.dsa;

import org.junit.jupiter.api.Assertions;
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

}
