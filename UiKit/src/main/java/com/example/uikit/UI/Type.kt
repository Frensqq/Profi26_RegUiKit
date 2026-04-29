package com.example.uikit.UI

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.uikit.R

data class Type(
    val Title1Semibold: TextStyle = TextStyle(),
    val Title1Heavy: TextStyle = TextStyle(),
    val Title2Regular: TextStyle = TextStyle(),
    val Title2Semibold: TextStyle = TextStyle(),
    val Title2Heavy: TextStyle = TextStyle(),
    val Title3RegulaR: TextStyle = TextStyle(),
    val Title3Medium: TextStyle = TextStyle(),
    val Title3Semibold: TextStyle = TextStyle(),
    val HeadlineRegular: TextStyle = TextStyle(),
    val HeadlineMedium: TextStyle = TextStyle(),
    val TextRegular: TextStyle = TextStyle(),
    val TextMedium: TextStyle = TextStyle(),
    val CaptionRegular: TextStyle = TextStyle(),
    val CaptionSemibold:TextStyle = TextStyle(),
    val Caption2Regular: TextStyle = TextStyle(),
    val Caption2Bold:TextStyle = TextStyle()

)

fun Typography(): Type {

    fun textStyle(
        fontFamily: Int,
        fontWeight:Int,
        fontSize:Int,
        lineHeight:Int,
        letterSpacing: Double = 0.00

    ) = TextStyle(
        fontFamily = FontFamily(Font(fontFamily)),
        fontWeight = FontWeight(fontWeight),
        fontSize = fontSize.sp,
        lineHeight = lineHeight.sp,
        letterSpacing = letterSpacing.sp
    )

    return  Type(
        Title1Semibold = textStyle(R.font.semibold, 600,24,28,0.33),
        Title1Heavy = textStyle(R.font.heavy, 700,24,28,0.33),
        Title2Regular = textStyle(R.font.regular, 400,20,28,0.38),
        Title2Semibold = textStyle(R.font.semibold, 600,20,28,0.38),
        Title2Heavy = textStyle(R.font.heavy, 800,20,28,0.38),
        Title3RegulaR = textStyle(R.font.regular, 400,17,24),
        Title3Medium = textStyle(R.font.medium, 500,17,24),
        Title3Semibold = textStyle(R.font.semibold, 600,17,24),
        HeadlineMedium = textStyle(R.font.medium, 500,16,20,-0.32),
        HeadlineRegular = textStyle(R.font.regular, 400,16,20,-0.32),
        TextRegular = textStyle(R.font.regular, 400,15,20),
        TextMedium = textStyle(R.font.medium, 500,15,20),
        CaptionRegular = textStyle(R.font.regular, 400,14,20),
        CaptionSemibold = textStyle(R.font.semibold, 600,14,20),
        Caption2Regular = textStyle(R.font.regular, 400,12,16),
        Caption2Bold = textStyle(R.font.bold, 700,12,20),

        )
}