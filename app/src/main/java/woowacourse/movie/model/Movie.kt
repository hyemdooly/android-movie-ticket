package woowacourse.movie.model

data class Movie(
    val title: String,
    val playingTimes: PlayingTimes,
    val runningTime: Int,
    val description: String
)
