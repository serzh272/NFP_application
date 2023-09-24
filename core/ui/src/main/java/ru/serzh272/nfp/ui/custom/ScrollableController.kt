package ru.serzh272.nfp.ui.custom

import android.graphics.Paint
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt


@Composable
fun ScrollableController(modifier: Modifier, value: Int, range: IntRange, default: Int = 0, recommendedValuePredicate: ((Int) -> Boolean)? = null, onValueChanged: (Int) -> Unit) {
    val textValueSize = 42f
    val pixelSize = with(LocalDensity.current) { 1.dp.toPx() }
    val pxPerPoint = 8 * pixelSize
    val buffer = (with(LocalConfiguration.current) { screenWidthDp * pixelSize } * 1.5f / pxPerPoint).toInt()
    val extendedRange = IntRange(range.first - buffer, range.first - 1) + range + IntRange(range.last + 1, range.last + buffer)
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

    LaunchedEffect(key1 = scrollableState.isScrollInProgress) {
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
                    Offset(0f, size.height / 2),
                    Offset(size.width, size.height / 2)
                )
                drawPath(path.apply {
                    reset()
                    moveTo(size.width / 2 - 12 * pixelSize, 0f)
                    lineTo(size.width / 2, 12 * pixelSize)
                    lineTo(size.width / 2 + 12 * pixelSize, 0f)
                    close()
                }, if (recommendedValuePredicate?.invoke(value) == false) Color.Red else Color.Black)
                extendedRange
                    .associateWith { it * pxPerPoint + offset - default * pxPerPoint + size.width / 2 }
                    .filter { it.value <= size.width && it.value >= 0f }
                    .forEach { entry ->
                        val x = entry.value
                        if (x <= size.width && x >= 0f) {
                            val color = if (recommendedValuePredicate?.invoke(entry.key) == false) Color.Red else Color.Black
                            drawLine(
                                color = color,
                                start = Offset(x, 3 * size.height / 8),
                                end = Offset(x, if (entry.key % 5 == 0) 3 * size.height / 4 else 5 * size.height / 8),
                                strokeWidth = if (entry.key % 5 == 0) 2* pixelSize else pixelSize
                            )

                            if (entry.key % 5 == 0 && entry.key in range) drawContext.canvas.nativeCanvas.apply {
                                drawText(
                                    "${entry.key}", x, size.height, Paint().apply {
                                        textSize = textValueSize
                                        textAlign = Paint.Align.CENTER
                                        this.color = color.toArgb()
                                    }
                                )
                            }
                        }
                    }
            }
        )
    }
}
