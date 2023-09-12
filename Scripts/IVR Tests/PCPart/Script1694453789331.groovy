import com.kms.katalon.core.util.KeywordUtil

CustomKeywords.'mobile.mobilekeywords.convertAudio'('C:\\Users\\pravi\\tmp\\test.aac', 'C:\\Users\\pravi\\tmp\\test.wav')

CustomKeywords.'aws.S3.putObjectToS3ViaApiGateWay'('https://m41x81k1u0.execute-api.us-east-1.amazonaws.com/test', 'katalon-bin', 
    'C:\\Users\\pravi\\tmp\\test.wav', 'test.wav')

transcription = CustomKeywords.'aws.Transcribe.startTranscribe'('s3://katalon-bin/test.wav', 'en-US', 'us-east-1', 'AKIA27AVHW745A6MFVZO', 
    '85LzVhSAyFVxtd38bX420IVT7H1+Jdj1+gj/0Ckg', 90)

KeywordUtil.markPassed("Transcription : " + transcription)