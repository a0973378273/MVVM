import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("tag1")
class Junit5Test {

    @BeforeAll
    fun beforeAll() {
        println("beforeAll")
    }

    @BeforeEach
    fun beforeEach() {
        println("beforeEach")
    }

    @Disabled
    fun disabled() {
        println("disabled")
    }

    @Test
    @DisplayName("Test1")
    fun test1() {
        assertEquals(1, 1)
    }

    @Test
    @DisplayName("Test2")
    fun test2() {
        assertEquals(2, 2)
    }

    @AfterEach
    fun afterEach() {
        println("afterEach")
    }

    @AfterAll
    fun afterAll() {
        println("afterAll")
    }

}