/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_antell_security_jni_SessionPacketReader */

#ifndef _Included_com_antell_security_jni_SessionPacketReader
#define _Included_com_antell_security_jni_SessionPacketReader
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_antell_security_jni_SessionPacketReader
 * Method:    open
 * Signature: (Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_com_antell_security_jni_SessionPacketReader_open
  (JNIEnv *, jobject, jstring);

/*
 * Class:     com_antell_security_jni_SessionPacketReader
 * Method:    read
 * Signature: (Lcom/antell/security/jni/SessionPacketEntry;)I
 */
JNIEXPORT jint JNICALL Java_com_antell_security_jni_SessionPacketReader_read
  (JNIEnv *, jobject, jobject);

/*
 * Class:     com_antell_security_jni_SessionPacketReader
 * Method:    close
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_antell_security_jni_SessionPacketReader_close
  (JNIEnv *, jobject);

#ifdef __cplusplus
}
#endif
#endif
