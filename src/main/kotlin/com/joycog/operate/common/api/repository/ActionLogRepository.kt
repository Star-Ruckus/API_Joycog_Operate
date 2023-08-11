package com.joycog.operate.common.api.repository

import com.emotiv.api.api_BlueEnter.api.actionLog.model.*
import org.apache.ibatis.annotations.Mapper
import org.springframework.stereotype.Repository

/**
 * @fileName LogRepository
 * @author kimkihyeon
 * @since 2023/05/23
 * @version 1.0
 *
 * @Modification Information
 * @
 * @    DATE           AUTHOR          NOTE
 * @ -----------     ----------    -------------------
 * @ 2023/05/23     kimkihyeon       최초 작성
 */
@Mapper
@Repository
interface ActionLogRepository {

    fun insertLogAdmin(logAdminVo: LogAdminVo): Int

    fun insertLogAnonymous(logAnonymousVo: LogAnonymousVo): Int

    fun insertLogChild(logChildVo: LogChildVo): Int

    fun insertLogManager(logManagerVo: LogManagerVo): Int

    fun insertLogGuardian(logGuardianVo: LogGuardianVo): Int
    fun insertLogCode(logCodeEntity: LogCodeEntity): Int
}