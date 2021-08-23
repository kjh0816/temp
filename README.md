# 큰 틀
- 회원 관리
  - 최초 회원가입을 한 회원은 영업자의 권한만 가지고 있다.
    - 회원가입 정보 중 계좌 관련 정보를 입력 받아야한다.
    - 장례지도사 자격 인증, 사업자 등록을 통해서 다른 권한 레벨을 얻게 된다.
      - 이후, 다른 업종에 등록한 회원은 다른 등록은 할 수 없다.
        - 각 직업마다의 흐름이 있다.  
  - 장례지도사와 사업자는 자격 인증을 거쳐야한다.
    - 모든 인증 절차
      1) 장례지도사 - 자격증을 통한 인증에 대한 거절은 없으나, 승인을 보류할 수 있다.
      2) 다른 직업  - 승인만 존재한다. (약관 동의 및 정보 입력을 받기 위한 절차라고 할 수 있음)
  - 지역
    - 17개 시,도만 한다.
    - 회원가입 단계에서 입력받는 지역 데이터는 지역 별 영업자 수를 파악하기 위함.
  - 장례지도사
    - 장례지도사 자격증을 사진 파일로 가지고 있는다.
  - 인터셉터
    - AuthenticationStatusInterceptor를 모든 직업에 대해 통합
- 메인 페이지
  - 장례지도사 인증 버튼
  - 사업자 인증 버튼
  - 인력 정보 등록 버튼
  - 장례지도사 호출 버튼
# 함수명 템플릿
  - Insert : Insert[테이블명]
  - Select : get[테이블명]By[기준칼럼명]
  - Update : modify[테이블명]Into[칼럼명]And[칼럼명]...
  - Delete(UpdateDelStatus) : delete[테이블명]

# 구현된 것
- 회원가입
  - 정규표현식 적용 완료
  - 회원가입, 로그인 비밀번호 암호화 완료

# 구현할 것
- flower 테이블에 사진 추가하기(규격에 속하는 사진)
- 메인 페이지에서 사업자 인증 버튼 클릭 > 업종 선택 > 물품 제공 시스템 설명 페이지 > 해당 업종 관련 동의 페이지로 이동 > (이전페이지에서 동의하면) 사업자 번호 또는 사업자 등록증 사진 제출 > 승인 대기
- 장례지도사 출동 요청 페이지(고인, 상주 정보 입력 > 장례지도사 선택(검색) 또는 랜덤(지역별 리스팅))
- do로 시작하는 매소드들 AJax기능으로 변경하기
# 전달 (읽은 후 지우면 됨)



   
