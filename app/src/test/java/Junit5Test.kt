import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.condition.DisabledIf
import org.junit.jupiter.api.condition.EnabledIf

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
    @EnabledIf("enableIfCondition")
    fun enableIf() {
        println("enableIf")
    }

    @Test
    @DisabledIf("enableIfCondition")
    fun disabledIf() {
        println("disabledIf")
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

    private fun enableIfCondition(): Boolean {
        return false
    }

}