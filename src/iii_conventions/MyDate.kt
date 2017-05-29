package iii_conventions

import iii_conventions.TimeInterval.DAY

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
  override fun compareTo(other: MyDate): Int =
      when {
        year != other.year -> year - other.year
        month != other.month -> month - other.month
        else -> dayOfMonth - other.dayOfMonth
      }
}

operator fun MyDate.plus(unit: TimeInterval): MyDate = this.addTimeIntervals(unit, 1)
operator fun MyDate.plus(unit: Pair<TimeInterval, Int>): MyDate = this.addTimeIntervals(
    unit.first, unit.second)

operator fun TimeInterval.times(unit: Int): Pair<TimeInterval, Int> = Pair(this, unit)

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

enum class TimeInterval {
  DAY,
  WEEK,
  YEAR
}

class DateRange(override val start: MyDate,
    override val endInclusive: MyDate) : ClosedRange<MyDate>, Iterable<MyDate> {
  override fun iterator(): Iterator<MyDate> = MyDateIterator(this)

  override operator fun contains(d: MyDate): Boolean {
    return start < d && endInclusive >= d
  }
}

class MyDateIterator(val range: DateRange) : Iterator<MyDate> {
  var current: MyDate = range.start

  override fun next(): MyDate {
    var next = current
    current = current.addTimeIntervals(DAY, 1)
    return next
  }

  override fun hasNext(): Boolean = current <= range.endInclusive
}