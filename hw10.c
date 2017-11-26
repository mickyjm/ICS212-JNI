/*****************************************************************
*
* NAME: Michael Mangrobang
*
* HOMEWORK: 10
*
* CLASS: ICS 212
*
* INSTRUCTOR: Ravi Narayan
*
* DATE: December 10, 2015
*
* FILE: hw10.c
*
* DESCRIPTION: C Source file that contains Java Native Interface 
*              functions to convert fahrenheit to celsius and
*              round user input up to nearest five
*
*****************************************************************/

#include "hw10.h"
#include <jni.h>

/*****************************************************************
*
* Function name: Java_hw10_convertFtoC
*
* DESCRIPTION: C function for JNI. Converts and returns, fahrenheit
*              input to celsius
*
* Parameters: jenv (JNIEnv *):
*             jobj (jobject):
*             fahrenheit (jint): user input from java to convert
*
* Return Values: celsius (jfloat): converted fahrenheit input
*
*****************************************************************/

JNIEXPORT jfloat JNICALL Java_hw10_convertFtoC(JNIEnv *jenv, jobject jobj, jint fahrenheit)
{

	jfloat celsius;
	
	celsius = ((jfloat)fahrenheit - 32.0) * (5.0 / 9.0);
	
	return celsius;

}

/*****************************************************************
*
* Function name: Java_hw10_convertFtoC
*
* DESCRIPTION: C function for JNI. Converts and returns, fahrenheit
*              input to celsius
*
* Parameters: jenv (JNIEnv *):
*             jobj (jobject):
*             degree (jint): user input from java to round up
*
* Return Values: degree (jint): rounded up input
*
*****************************************************************/

JNIEXPORT jint JNICALL Java_hw10_roundUp(JNIEnv *jenv, jobject jobj, jint degree)
{

	if (degree % 5 == 1)
	{
		degree += 4;
	}
	else if (degree % 5 == 2)
	{
		degree += 3;
	}
	else if (degree % 5 == 3)
	{
		degree += 2;
	}
	else if (degree % 5 == 4)
	{
		degree += 1;
	}
	
	return degree;

}
