package com.joycog.operate.api.notice.model.entity

import com.joycog.operate.api.notice.model.enumer.LanguageCode
import com.joycog.operate.api.notice.model.enumer.NoticeType
import com.joycog.operate.api.notice.model.enumer.PlatformType
import javax.management.monitor.StringMonitor

/**
 * @fileName NoticeEntity
 * @author yunjeong
 * @since  2023/08/17
 * @version 1.0
 *
 * @Modification Information
 * @
 * @  DATE          AUTHOR         NOTE
 * @ -----------   ------------   -------------------------------
 * @ 2023/08/17        yunjeong        최초 작성
 */
data class NoticeEntity(
    val noticeId : Int?= null,
    val noticeSet : Int?= null,
    val noticeType : NoticeType?= null,
    val noticeTitle : String?= null,
    val noticeContent : String?= null,
    val languageCode: LanguageCode?= null,
    val useYn : String?= null,
    val startDate : String?= null,
    val endDate : String?= null,
    val usePlatform : PlatformType?= null,
    val imageUrl : String?= null
)
