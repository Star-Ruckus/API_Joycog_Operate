package com.joycog.operate.common.util

import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

/**
 * @fileName TimezoneUtil
 * @author yunjeong
 * @since  2023/08/21
 * @version 1.0
 *
 * @Modification Information
 * @
 * @  DATE          AUTHOR         NOTE
 * @ -----------   ------------   -------------------------------
 * @ 2023/08/21        yunjeong        최초 작성
 */
open class TimezoneUtil {

    open fun getDown0UTC(date : String, offset : String, plusDay : Long): String {
        val zoneOffset = ZoneOffset.of(offset)
        val seoulDateTime =
            LocalDateTime.parse("$date 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))

        // 받아온 오프셋 값을 사용합니다.
        val offsetDateTime = seoulDateTime.atOffset(zoneOffset)

        val utcZonedDateTime = offsetDateTime.withOffsetSameInstant(ZoneOffset.UTC).plusDays(plusDay)

        return utcZonedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
    }
}