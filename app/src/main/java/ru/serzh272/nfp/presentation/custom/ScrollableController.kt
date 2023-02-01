package ru.serzh272.nfp.presentation.custom

import android.graphics.Paint
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt


@Composable
fun ScrollableController(modifier: Modifier, value: Int, range: IntRange, default: Int = 0, onValueChanged: (Int) -> Unit) {
    val textValueSize = 42f
    val pxPerPoint = with(LocalDensity.current) { 8.dp.toPx() }

    val buffer = (with(LocalConfiguration.current){ with(LocalDensity.current) { screenWidthDp.dp.toPx()} }*1.5f/pxPerPoint).toInt()
    val extendedRange = IntRange(range.first - buffer, range.first - 1) + range + IntRange(range.last+1, range.last + buffer)
    var offset by remember(value) {
        mutableStateOf((default - value) * pxPerPoint)
    }
    val path = Path()
    val scrollableState = rememberScrollableState { delta ->
        offset += delta
        val curValue = default - (offset / pxPerPoint).roundToInt()
        if (curValue in range) onValueChanged(curValue)
        if (curValue !in range) 0f else delta
    }

    LaunchedEffect(key1 = scrollableState.isScrollInProgress){
        if (!scrollableState.isScrollInProgress) {
            if (value < range.first) onValueChanged(range.first)
            if (value > range.last) onValueChanged(range.last)
            offset = (default - value) * pxPerPoint
        }

    }
    Card(modifier = modifier) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(2.dp)
            .clipToBounds()
            .scrollable(
                orientation = Orientation.Horizontal,
                state = scrollableState,
            )
            .drawBehind {
                drawLine(
                    Color.Black,
                    Offset((range.first - buffer) * pxPerPoint + offset - default * pxPerPoint + size.width / 2, size.height / 2),
                    Offset((range.last + buffer) * pxPerPoint + offset - default * pxPerPoint + size.width / 2, size.height / 2)
                )
                drawPath(path.apply {
                    reset()
                    moveTo(size.width / 2 - 12.dp.toPx(), 0f)
                    lineTo(size.width / 2, 12.dp.toPx())
                    lineTo(size.width / 2 + 12.dp.toPx(), 0f)
                    close()
                }, Color.Black)
                extendedRange.forEach {
                    val x = it * pxPerPoint + offset - default * pxPerPoint + size.width / 2
                    drawLine(
                        color = Color.Black,
                        start = Offset(x, 3 * size.height / 8),
                        end = Offset(x, if (it % 5 == 0) 3 * size.height / 4 else 5 * size.height / 8),
                        strokeWidth = if (it % 5 == 0) 3f else 1f
                    )

                    if (it % 5 == 0 && it in range) drawContext.canvas.nativeCanvas.apply {
                        drawText("$it", x, size.height, Paint().apply {
                            textSize = textValueSize
                            textAlign = Paint.Align.CENTER
                        })
                    }
                }
            }
        )
    }
}
