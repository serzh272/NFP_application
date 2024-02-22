package ru.serzh272.nfp.ui.custom

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PointsIndicator(
    size: Dp = 80.dp,
    points: List<Pair<Int, Color>>,
    minPoints: Int
) {
    val pointsSum = points.fold(0) { acc, point ->
        acc + point.first
    }
    val maximumPoints = (points.size * 120).let { if (pointsSum >= it) pointsSum + 20 else it}
    val animatedValue = remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 = pointsSum){
        animatedValue.animateTo(pointsSum.toFloat())
    }
    Box(
        modifier = Modifier
            .size(size)
            .drawBehind {
                val minLineWidth = 2.dp.toPx()
                val outerOffset = minLineWidth / 2 + 1.dp.toPx()
                val resultLineWidth = 10.dp.toPx()
                val resultLineOffset = resultLineWidth / 2 + outerOffset + minLineWidth / 2 + 2.dp.toPx()
                var currentStartAngle = -90f

                val anglePerPoint = 360f / maximumPoints
                drawCircle(Color.LightGray, this.size.width / 2)
                drawArc(
                    color = Color.Red,
                    startAngle = currentStartAngle,
                    sweepAngle = minPoints * anglePerPoint,
                    useCenter = false,
                    size = Size(this.size.width - outerOffset * 2, this.size.height - outerOffset * 2),
                    topLeft = Offset(outerOffset, outerOffset),
                    style = Stroke(width = minLineWidth)
                )
                points.forEach {
                    drawArc(
                        color = it.second,
                        startAngle = currentStartAngle,
                        sweepAngle = anglePerPoint * it.first,
                        useCenter = false,
                        size = Size(this.size.width - resultLineOffset * 2, this.size.height - resultLineOffset * 2),
                        topLeft = Offset(resultLineOffset, resultLineOffset),
                        style = Stroke(width = resultLineWidth)
                    )
                    currentStartAngle += anglePerPoint * it.first
                }

            }) {
        Text(modifier = Modifier.align(Alignment.Center), text = pointsSum.toString(), fontSize = 24.sp, fontWeight = FontWeight.Bold)
    }
}

fun DrawScope.IndicatorBackground(size: Size) {

}

@Preview(showBackground = true, widthDp = 80, heightDp = 80)
@Composable
fun PointsIndicatorPreview() {
    val points = listOf(60 to Color.Red, 70 to Color.Blue, 50 to Color.Green, 90 to Color.Gray)
    PointsIndicator(points = points, minPoints = 60)
}
