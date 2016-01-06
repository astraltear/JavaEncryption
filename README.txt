## Bouncy Castle 프로바이더 추가
	http://www.bouncycastle.org/latest_releases.html
	bcprov-jdk15on-150.jar 다운로드

	jar 파일을 아래의 경로에 추가
	<JAVA_HOME>/jre/lib/ext
	<JRE_HOME>/lib/ext
	
	아래의 두 개의 경로에 아래의 프로바이더를 추가한다.  
	여기서 N은 순번이다. 다음과 같이 9번까지 프로바이더가 선언되어 있다면 10번으로 Bouncy Castle 프로바이더를 추가하면 된다.
	security.provider.N=org.bouncycastle.jce.provider.BouncyCastleProvider
	
	<JAVA_HOME>/jre/lib/security/java.security
	<JRE_HOME>/lib/security/java.security

## BouncyCastleExam, BouncyCastleExam2
	Bouncy Castle 로드 테스트
	
## SecureRandomEx
	SecureRandom 테스트
	
## 테스트 알고리즘	
	RSA 
		com.astraltear.basic.rsa.RSAGenKeyEx
		com.astraltear.basic.rsa.KeyFactoryEx
	
	RSA/ECB/PKCS1Padding
		
	
	SHA-256
		com.astraltear.basic.md.MessageDigestEx
		
	SHA-1
		com.astraltear.basic.password.MySqlPasswordEx
		다음은 SHA-1 알고리즘을 이용한 패스워드 함수 예제다. 
		MySQL에서 패스워드를 저장하기 위해서 사용하는 방법으로, SHA-1 해시 함수를 두 번 호출하고 생성된 해시값을 16진수의 문자열로 만든다.
	
	AES
		AES/ECB/PKCS5Padding
		com.astraltear.basic.aes.AESKeyWriteEx
		com.astraltear.basic.aes.AESEx
		com.astraltear.basic.aes.AESCipherStreamEx
		
		AES/CBC/PKCS5Padding
		com.astraltear.basic.aes.AESCBCWithIvEx
		
		AES/CFB128/NoPadding
		com.astraltear.basic.aes.AESCFBWithIvEx
		
		AES/CTR/NoPadding
		com.astraltear.basic.aes.AESCTRWithIvEx
		
		AES/CCM/NoPadding
		com.astraltear.basic.aes.AESCCMWithIvEx
		
	SEED
		SEED/CBC/PKCS5Padding
		com.astraltear.basic.seed.SeedCBCWithIvEx
		
	HmacSHA256
		com.astraltear.basic.mac.HMACEx
		
	PBEWithMD5AndDES
		com.astraltear.basic.pbes.PBE1Ex
	
	PBKDF2WithHmacSHA1,AES/ECB/PKCS5Padding
		com.astraltear.basic.pbes.PBE2Ex
		
		
	