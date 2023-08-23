package com.joycog.operate.api.notice.model.request

import com.joycog.operate.api.notice.model.NoticeInfoVo
import com.joycog.operate.api.notice.model.enumer.NoticeType
import com.joycog.operate.api.notice.model.enumer.PlatformType
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import org.springframework.web.multipart.MultipartFile

/**
 * @fileName RequestEnrollNoticeVo
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
@ApiModel(value = "공지사항 등록", description = "")
data class RequestEnrollNoticeVo(
    @ApiModelProperty(value = "공지 타입", example = "S : 시스템 공지, I : 정보성 공지", required = true)
    val noticeType : NoticeType,
    @ApiModelProperty(value = "공지 상세", example = "", required = true)
    val noticeInfo : List<NoticeInfoVo>?,
    @ApiModelProperty(value = "공지 시작 날짜", example = "2023-02-02 15:00:00", required = true)
    val starDate : String,
    @ApiModelProperty(value = "공지 종료 날짜", example = "2024-02-02 15:00:00", required = true)
    val endDate : String,
    @ApiModelProperty(value = "이미지", example = "2024-02-02 15:00:00", required = true)
    val img : MultipartFile?
)
