package conf

/**
 *packageName    :
 * fileName       : conf.InmemoryDatabase
 * author         : joy58
 * date           : 2025-03-12
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-12        joy58       최초 생성
 */
class InmemoryDatabase<T> {

    private val store: MutableList<Pair<Long, T>> = mutableListOf()
    private var id: Long = 0

    fun add(data: T): Long {
        val newId = id++
        store.add(newId to data)
        return newId
    }

    fun getList(): List<Pair<Long, T>> {
        return store
    }

    fun get(id: Long): T? {
        return store.find { it.first == id }?.second
    }

    fun update(id: Long, newData: T): Boolean {
        val index = store.indexOfFirst { it.first == id }
        if (index == -1) return false
        store[index] = id to newData
        return true
    }

    fun delete(id: Long): Boolean {
        return store.removeIf { it.first == id }
    }
}