package i_introduction._2_Named_Arguments

fun todoTask2(collection: Collection<Int>): String = collection.joinToString(prefix = "{",
    postfix = "}")

fun task2(collection: Collection<Int>): String {
  return todoTask2(collection)
}
