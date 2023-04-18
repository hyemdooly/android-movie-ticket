package woowacourse.movie.util

import java.time.LocalDate
import java.time.LocalTime

fun Map<LocalDate, List<LocalTime>>.getOrEmptyList(key: LocalDate): List<LocalTime> {
    return this[key] ?: emptyList()
}

fun Map<LocalDate, List<LocalTime>>.getKeyFromIndex(index: Int): LocalDate {
    return keys.toList()[index]
}
