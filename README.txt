## Bouncy Castle ���ι��̴� �߰�
	http://www.bouncycastle.org/latest_releases.html
	bcprov-jdk15on-150.jar �ٿ�ε�

	jar ������ �Ʒ��� ��ο� �߰�
	<JAVA_HOME>/jre/lib/ext
	<JRE_HOME>/lib/ext
	
	�Ʒ��� �� ���� ��ο� �Ʒ��� ���ι��̴��� �߰��Ѵ�.  
	���⼭ N�� �����̴�. ������ ���� 9������ ���ι��̴��� ����Ǿ� �ִٸ� 10������ Bouncy Castle ���ι��̴��� �߰��ϸ� �ȴ�.
	security.provider.N=org.bouncycastle.jce.provider.BouncyCastleProvider
	
	<JAVA_HOME>/jre/lib/security/java.security
	<JRE_HOME>/lib/security/java.security

## BouncyCastleExam, BouncyCastleExam2
	Bouncy Castle �ε� �׽�Ʈ
	
## SecureRandomEx
	SecureRandom �׽�Ʈ
	
## �׽�Ʈ �˰���	
	RSA 
		com.astraltear.basic.rsa.RSAGenKeyEx
		com.astraltear.basic.rsa.KeyFactoryEx
	
	RSA/ECB/PKCS1Padding
		
	
	SHA-256
		com.astraltear.basic.md.MessageDigestEx
		
	SHA-1
		com.astraltear.basic.password.MySqlPasswordEx
		������ SHA-1 �˰����� �̿��� �н����� �Լ� ������. 
		MySQL���� �н����带 �����ϱ� ���ؼ� ����ϴ� �������, SHA-1 �ؽ� �Լ��� �� �� ȣ���ϰ� ������ �ؽð��� 16������ ���ڿ��� �����.
	
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
		
		
	