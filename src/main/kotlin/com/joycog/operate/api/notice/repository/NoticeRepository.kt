package com.joycog.operate.api.notice.repository

import com.joycog.operate.api.notice.model.entity.NoticeEntity
import org.apache.ibatis.annotations.Mapper
import org.springframework.stereotype.Repository

/**
 * @fileName NoticeRepository
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
@Mapper
@Repository
interface NoticeRepository {
    fun insertNotice(noticeEntity: NoticeEntity): Int

    fun updateNotice(noticeEntity: NoticeEntity): Int

    fun getMaxNoticeSet(): Int
}