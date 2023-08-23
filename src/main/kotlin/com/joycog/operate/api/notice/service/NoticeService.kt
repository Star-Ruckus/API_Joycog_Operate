package com.joycog.operate.api.notice.service

import com.joycog.operate.api.notice.model.entity.NoticeEntity
import com.joycog.operate.api.notice.model.request.RequestEnrollNoticeVo
import com.joycog.operate.api.notice.model.response.ResponseEnrollNoticeVo
import com.joycog.operate.api.notice.repository.NoticeRepository
import com.joycog.operate.api.s3Upload.service.S3UploadService
import com.joycog.operate.common.config.exception.ErrorCode
import com.joycog.operate.common.config.exception.ErrorException
import com.joycog.operate.common.util.TimezoneUtil
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

/**
 * @fileName NoticeService
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
@Service
class NoticeService (
    private val noticeRepository: NoticeRepository,
    private val s3UploadService: S3UploadService
){
    fun registerNotice(requestEnrollNoticeVo: RequestEnrollNoticeVo, img: MultipartFile?): ResponseEnrollNoticeVo {
        val maxNoticeSet = noticeRepository.getMaxNoticeSet()

        var uploadImg = ""
        if (img != null){
            uploadImg = s3UploadService.saveFile(img, "/notice")
        }
        requestEnrollNoticeVo.noticeInfo!!.forEach {
            val noticeEntity = NoticeEntity(
                noticeSet = maxNoticeSet,
                noticeType = requestEnrollNoticeVo.noticeType,
                noticeTitle = it.noticeTitle,
                noticeContent = it.noticeContent,
                languageCode = it.languageCode,
                useYn = "Y",
                startDate = requestEnrollNoticeVo.starDate,
                endDate = requestEnrollNoticeVo.endDate,
                usePlatform = it.usePlatform,
                imageUrl = uploadImg
            )
//            val insert = noticeRepository.insertNotice(noticeEntity)
//            if (insert != 1){
//                throw ErrorException(ErrorCode.INSERT)
//            }
        }

        return ResponseEnrollNoticeVo(
            imgUrl = uploadImg
        )
    }

    fun test(img: MultipartFile?): Boolean {
        var uploadImg = ""
        if (img != null){
            uploadImg = s3UploadService.saveFile(img, "/notice")
        }
        return true
    }
}