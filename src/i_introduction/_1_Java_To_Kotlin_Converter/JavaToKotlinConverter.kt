package i_introduction._1_Java_To_Kotlin_Converter

fun todoTask1(collection: Collection<Int>): String = "{${collection.joinToString(", ")}}"


fun task1(collection: Collection<Int>): String {
  return todoTask1(collection)
}
