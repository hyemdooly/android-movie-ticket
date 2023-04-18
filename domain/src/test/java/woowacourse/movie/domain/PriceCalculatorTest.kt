package woowacourse.movie.domain

import junit.framework.TestCase.assertEquals
import org.junit.Test
import woowacourse.movie.domain.policy.MorningPolicy
import woowacourse.movie.domain.policy.MovieDayPolicy
import woowacourse.movie.domain.policy.NightPolicy
import woowacourse.movie.domain.ticket.Price
import woowacourse.movie.domain.ticket.PriceCalculator
import java.time.LocalDate
import java.time.LocalTime

class PriceCalculatorTest {
    @Test
    fun `조조에 해당하지만 무비데이면 무비데이 할인이 선적용된다`() {
        val policies = listOf(
            MovieDayPolicy(),
            MorningPolicy()
        )
        val calculator = PriceCalculator(policies, Price(13000))
        val actual = calculator.calculate(LocalDate.of(2023, 4, 30), LocalTime.of(9, 0), 1)
        val expected = Price(9700)
        assertEquals(actual, expected)
    }

    @Test
    fun `야간에 해당하지만 무비데이면 무비데이 할인이 선적용된다`() {
        val policies = listOf(
            MovieDayPolicy(),
            NightPolicy()
        )
        val calculator = PriceCalculator(policies, Price(13000))
        val actual = calculator.calculate(LocalDate.of(2023, 4, 30), LocalTime.of(21, 0), 1)
        val expected = Price(9700)
        assertEquals(actual, expected)
    }
}
