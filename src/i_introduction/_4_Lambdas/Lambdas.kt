package i_introduction._4_Lambdas

fun todoTask4(collection: Collection<Int>): Boolean = collection.any { it % 42 == 0 }

fun task4(collection: Collection<Int>): Boolean = todoTask4(collection)




