package com.app.restfulprac.api;

import com.app.restfulprac.domain.dto.ApiResponseDTO;
import com.app.restfulprac.domain.dto.MemberJoinRequestDTO;
import com.app.restfulprac.domain.dto.MemberResponseDTO;
import com.app.restfulprac.domain.dto.MemberUpdateRequestDTO;
import com.app.restfulprac.domain.vo.MemberVO;
import com.app.restfulprac.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/members")
@RequiredArgsConstructor
public class MemberAPI {

    private final MemberService memberService;

    @Operation(summary = "회원가입 서비스", description = "회원 정보를 받아서 회원가입을 시켜주는 서비스")
    @ApiResponse(responseCode = "201", description = "회원가입 성공")
    @ApiResponse(responseCode = "409", description = "이메일 중복")
    @PostMapping("/join")
    public ResponseEntity<ApiResponseDTO> join(@RequestBody MemberJoinRequestDTO memberJoinRequestDTO) {
        memberService.join(memberJoinRequestDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponseDTO.of("회원 가입 성공"));
    }

    @Operation(summary = "회원 목록 조회 서비스", description = "회원 정보를 목록으로 조회해 리스트로 반환하는 서비스")
    @ApiResponse(responseCode = "200", description = "회원 목록 조회 성공")
    @ApiResponse(responseCode = "400", description = "회원 목록 조회 실패")
    @GetMapping("")
    public ResponseEntity<ApiResponseDTO> getMembers(){
        List<MemberResponseDTO> membersList = memberService.getMembers();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponseDTO.of("회원 전체 조회 성공", membersList));
    }

    @Operation(summary = "회원 단일 조회 서비스", description = "회원 조회해서 객체로 반환하는 서비스")
    @ApiResponse(responseCode = "200", description = "회원 목록 조회 성공")
    @ApiResponse(responseCode = "400", description = "회원 조회 실패")
    @Parameter(
            name = "id",
            description = "회원 번호",
            required = true,
            in = ParameterIn.PATH,
            example = "1",
            schema = @Schema(type = "number") // 스키마 타입
    )
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDTO> getMemberById(@PathVariable Long id){
        MemberResponseDTO memberResponseDTO =memberService.getMemberInfo(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponseDTO.of("회원 조회 성공", memberResponseDTO));
    }

    @Operation(summary = "로그인 서비스", description = "이메일과 비밀번호를 검증 후 로그인 서비스")
    @ApiResponse(responseCode = "200", description = "로그인 성공")
    @ApiResponse(responseCode = "401", description = "로그인 실패")
    @ApiResponse(responseCode = "401", description = "토큰 없음")
    @ApiResponse(responseCode = "403", description = "권한 없음")
    @PostMapping("/login")
    public ResponseEntity<ApiResponseDTO> login(@RequestBody MemberVO memberVO){
        MemberResponseDTO foundMember = memberService.login(memberVO);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("로그인 성공", foundMember));
    }

    @Operation(summary = "회원 정보 수정 서비스", description = "회원 정보를 업데이트 시켜주는 서비스")
    @ApiResponse(responseCode = "200", description = "회원 정보 수정 완료")
    @ApiResponse(responseCode = "400", description = "잘못된 접근")
    @ApiResponse(responseCode = "401", description = "토큰 없음")
    @ApiResponse(responseCode = "403", description = "권한 없음")
    @Parameter(
            name = "id",
            description = "회원 번호",
            required = true,
            in = ParameterIn.PATH,
            example = "1",
            schema = @Schema(type = "number") // 스키마 타입
    )
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseDTO> updateMember(
            @RequestBody MemberUpdateRequestDTO memberUpdateRequestDTO,
            @PathVariable Long id
    ){
        memberUpdateRequestDTO.setId(id);
        memberService.updateMember(memberUpdateRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("회원 정보 수정 완료"));
    }
}
