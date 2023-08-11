

import com.emotiv.api.api_BlueEnter.api.actionLog.model.*
import com.joycog.operate.common.api.repository.ActionLogRepository
import com.joycog.operate.common.config.exception.ErrorCode
import com.joycog.operate.common.config.exception.ErrorException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * @fileName LoggerService
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
@Service
class ActionLogService(
    private val actionLogRepository: ActionLogRepository
) {

    /**
     * 사용자 로그 정보 저장
     * @param error ErrorVo
     * @return Int
     * @throws RuntimeException
     */
    @Transactional
    @Throws(RuntimeException::class)
    fun insertLogChild(child: LogChildVo): Boolean {
        val result = actionLogRepository.insertLogChild(child)
//        if (result != 1) {
//            throw ErrorException(ErrorCode.INSERT)
//        }
        return true
    }

    /**
     * 보호자 로그 정보 저장
     * @param error ErrorVo
     * @return Int
     */
    fun insertLogGuardian(guardian: LogGuardianVo): Boolean {
        val result = actionLogRepository.insertLogGuardian(guardian)
//        if (result != 1) {
//            throw ErrorException(ErrorCode.INSERT)
//        }
        return true

    }

    /**
     * 관리자 로그 정보 저장
     * @param error ErrorVo
     * @return Int
     */
    fun insertLogManager(manager: LogManagerVo): Boolean {
        val result = actionLogRepository.insertLogManager(manager)
//        if (result != 1) {
//            throw ErrorException(ErrorCode.INSERT)
//        }
        return true
    }

    /**
     * 운영자 로그 정보 저장
     * @param error ErrorVo
     * @return Int
     */
    fun insertLogAdmin(admin: LogAdminVo): Boolean {
        val result = actionLogRepository.insertLogAdmin(admin)
//        if (result != 1) {
//            throw ErrorException(ErrorCode.INSERT)
//        }
        return true
    }

    /**
     * 익명 사용자 로그 정보 저장
     * @param error ErrorVo
     * @return Int
     */
    fun insertLogAnonymous(anonymous: LogAnonymousVo): Boolean {
        val result = actionLogRepository.insertLogAnonymous(anonymous)
//        if (result != 1) {
//            throw ErrorException(ErrorCode.INSERT)
//        }
        return true
    }

    /**
     * 로그 코드 테이블 삽입
     * @param logCodeEntity LogCodeEntity
     * @return Boolean
     */
    fun registerLogCode(logCodeEntity: LogCodeEntity): Boolean {
        val result = actionLogRepository.insertLogCode(logCodeEntity)
        return true
    }

}