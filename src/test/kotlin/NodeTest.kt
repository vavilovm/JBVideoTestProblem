import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class NodeTest {
    @Test
    fun simpleTest() {
        val nodes = NodeManager()
        nodes.create("root")
        nodes.create("son1")
        nodes.create("son2")
        nodes.add("root", "son1")
        nodes.add("root", "son2")

        nodes.create("root2")
        nodes.create("other")
        nodes.add("root2", "other")

        val nodes2 = NodeManager()
        nodes2.add("root", "son1", "son2")
        nodes2.add("root2", "other")


        Assertions.assertEquals(listOf("root", "son1", "son2", "root2", "other"), nodes.values())
        Assertions.assertEquals(nodes.values(), nodes2.values())
    }
}
