# spring security + jwt
### JWT(Json Web Token)
당사자 간에 정보를 JSON 개체로 안전하게 전송하기 위한 간결하고 독립적인 방법을 정의하는 개방형 표준(RFC 7519)
이 정보는 디지털 서명되어 있으므로 확인하고 신뢰 가능
JWT는 secret 또는 RSA 또는 ECDSA를 사용하는 공개/개인 키 쌍을 사용하여 서명 가능
JWT는 암호화하여 당사자 간에 비밀성을 제공

### JWT 사용 이유
- 권한 부여 : 가장 일반적인 방법, 사용자가 로그인 하면 이후에 각 요청에 JWT가 포함되어 사용자가 해당 토큰에 허용된 경로, 서비스 및 리소스에 접근 가능
- 정보 교환 : 당사자 간에 정보를 안전하게 전송 가능

### JWT 구조
(.)으로 구분된 세 부분으로 구성
- header
- payload
- signature

xxxxxxx.yyyyyyyy.zzzzzzzz

### Header
토큰유형과 사용중인 서명 알고리즘으로 구성
{
  "alg" : "HS256",
  "typ" : "JWT"
}

### Payload
3개의 클레임으로 구성
- registerd claims : iss, exp, sub, aud
- public claims
- private claims

서명된 토큰의 경우 이정보는 변조로부터 보호되지만 누구나 읽을 수 있으므로 암호화 되지 않은 경우 JWT의 페이로드 또는 헤더에 중요한 정보 입력 X

### Signature
서명 부분을 생성하기 위해 인코딩된 헤더, 인코딩된 페이로드, secret, 헤더에 지정된 알고리즘을 가져와 서명

### JWT의 사용
- 사용자 인증 성공시 JWT 반환
- 보안이 좋지 않으므로 민감한 세션데이터를 저장하면 안됨
- Bearer 스키마를 사용해서 Authorization 헤더에 JWT를 보냄
- 토큰이 너무 커지지 않도록 주의 필요

### JWT 사용 이유
JWT는 크기가 작아 HTML 및 HTTP 환경에서 전달하기 좋음
공개/개인 키 방식 사용 가능
JSON 파서는 개체에 직접 매핑되기 때문에 프로그래밍언어에 일반적


