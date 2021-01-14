package com.code.algorithm.sort

import com.code.algorithm.sort.simple.bubble
import java.util.*

fun main() {
    val array = createDataArray(length = 9999)
    array.printPart()
    arrayOf(
        Sort.Merge,
        Sort.Heap,
        Sort.Quick,
    ).asSequence()
        .forEach {
            val start = System.currentTimeMillis()
            val copy = array.copyOf()
            it.invoke(copy)
            println("${it.name}...cost-->${System.currentTimeMillis() - start}")
            copy.printPart()
        }
}

enum class Sort(private val sortBlock: (IntArray) -> Unit) : (IntArray) -> Unit {
    Bubble(::bubble),
    Select(::bubble),
    Insert(::bubble),
    Shell(::bubble),
    Quick(::bubble),
    Heap(::bubble),
    Merge(::bubble);

    override fun invoke(array: IntArray) {
        sortBlock(array)
    }
}

fun IntArray.part(part: Int) = if (size > 20) copyOf(20) else this

fun IntArray.printPart() = part(20).contentToString().let(::println)

fun createDataArray(random: Random = Random(), length: Int?, vararg array: Int): IntArray {
    return length?.let { IntArray(length) { random.nextInt(length) } } ?: array
}
