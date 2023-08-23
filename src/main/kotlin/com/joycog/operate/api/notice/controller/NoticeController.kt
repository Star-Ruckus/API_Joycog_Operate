package com.joycog.operate.api.notice.controller

import com.joycog.operate.api.notice.model.NoticeInfoVo
import com.joycog.operate.api.notice.model.enumer.LanguageCode
import com.joycog.operate.api.notice.model.enumer.NoticeType
import com.joycog.operate.api.notice.model.enumer.PlatformType
import com.joycog.operate.api.notice.model.request.RequestEnrollNoticeVo
import com.joycog.operate.api.notice.model.response.ResponseEnrollNoticeVo
import com.joycog.operate.api.notice.service.NoticeService
import com.joycog.operate.common.api.controller.ResponseController
import com.joycog.operate.common.api.model.ResponseData
import io.swagger.annotations.*
import io.swagger.v3.oas.annotations.tags.Tag
import io.swagger.v3.oas.annotations.tags.Tags
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import javax.validation.Valid

/**
 * @fileName NoticeController
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
@RestController
@RequestMapping("/api/v1/notice")
@Tags(Tag(name = "공지사항", description = "운영툴 공지사항"))
class NoticeController (
    private val noticeService: NoticeService
) : ResponseController() {

    @Tag(name = "공지사항")
    @ApiResponses(
        ApiResponse(code = 200, message = "OK"),
        ApiResponse(code = 500, message = "INTERNAL SERVER ERROR")
    )
    @ApiOperation(value = "공지사항 등록", notes = "공지사항을 등록한다.")
    @PostMapping("/register", consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    fun registerNotice(@RequestPart requestEnrollNoticeVo : RequestEnrollNoticeVo, img : MultipartFile?): ResponseEntity<ResponseData<ResponseEnrollNoticeVo>> {
        val url = noticeService.registerNotice(requestEnrollNoticeVo, img)
        return getSuccessResponseEntity(ResponseEnrollNoticeVo(imgUrl = ""))
    }

    @Tag(name = "공지사항")
    @ApiResponses(
        ApiResponse(code = 200, message = "OK"),
        ApiResponse(code = 500, message = "INTERNAL SERVER ERROR")
    )
    @ApiOperation(value = "공지사항 등록", notes = "공지사항을 등록한다.")
    @PostMapping("/register1", consumes = [MediaType.MULTIPART_FORM_DATA_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun test(@RequestParam(value="noticeType",required = false) @ApiParam(value = "공지 타입", example = "S : 시스템 공지, I : 정보성 공지") noticeType : NoticeType?,
             @RequestParam(value="starDate",required = false) @ApiParam(value = "공지 시작 날짜", example = "2023-02-02 15:00:00") starDate : String?,
             @RequestParam(value="endDate",required = false) @ApiParam(value = "공지 종료 날짜", example = "2024-02-02 15:00:00") endDate : String?,
             @RequestParam(value="noticeTitle",required = false) @ApiParam(value = "공지 제목", example = "제목입니다.") noticeTitle : String?,
             @RequestParam(value="noticeContent",required = false) @ApiParam(value = "공지 내용", example = "내용입니다.") noticeContent : String?,
             @RequestParam(value="languageCode",required = false) @ApiParam(value = "언어 코드", example = "KR : 한국 , EN : 영어") languageCode : LanguageCode?,
             @RequestParam(value="usePlatform",required = false) @ApiParam(value = "플랫폼 타입", example = "ALL : 전체, AOS : 안드로이드, IOS : 애플, WEB : 웹") usePlatform : PlatformType?,
             @RequestPart(value="img", required = false)@ApiParam(value = "이미지가 있다면 첨부하세요.", example = "이미지") img : MultipartFile?): ResponseEntity<ResponseData<Boolean>> {
        val url = noticeService.test(img)
        return getSuccessResponseEntity(url)
    }
}