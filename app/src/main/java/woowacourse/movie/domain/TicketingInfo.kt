package woowacourse.movie.domain

data class TicketingInfo(val title: String, val playingDate: String, val playingTime: String, val count: Int, val price: Price, val payment: String) : java.io.Serializable
