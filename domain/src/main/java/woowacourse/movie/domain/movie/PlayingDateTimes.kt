package woowacourse.movie.domain.movie

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalTime

class PlayingDateTimes(startDate: LocalDate, endDate: LocalDate) {
    private val _times: Map<LocalDate, List<LocalTime>> = makeDates(startDate, endDate).associateWith { date -> makeTimes(date) }
    val times: Map<LocalDate, List<LocalTime>>
        get() = _times.toMap()

    private fun makeDates(startDate: LocalDate, endDate: LocalDate): List<LocalDate> {
        var date = startDate
        return buildList {
            while (date.isBefore(endDate.plusDays(ONE_DAY.toLong()))) {
                add(date)
                date = date.plusDays(ONE_DAY.toLong())
            }
        }
    }
    private fun makeTimes(date: LocalDate): List<LocalTime> {
        val startHour = getStartHour(date)
        return (startHour until MAX_HOUR step STEP).map { LocalTime.of(it, MINUTE_DEFAULT) }
    }

    private fun getStartHour(date: LocalDate): Int {
        if (isWeekends(date.dayOfWeek)) return WEEKEND_START_HOUR
        return WEEKDAY_START_HOUR
    }

    private fun isWeekends(dayOfWeek: DayOfWeek): Boolean = dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY

    companion object {
        private const val WEEKEND_START_HOUR = 9
        private const val WEEKDAY_START_HOUR = 10
        private const val MINUTE_DEFAULT = 0
        private const val MAX_HOUR = 24
        private const val STEP = 2
        private const val ONE_DAY = 1
    }
}
