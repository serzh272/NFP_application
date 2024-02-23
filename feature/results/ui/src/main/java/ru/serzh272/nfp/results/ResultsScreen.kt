package ru.serzh272.nfp.results

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.serzh272.nfp.model.DomainDataHolder
import ru.serzh272.nfp.model.Exam
import ru.serzh272.nfp.model.ExerciseWithResult
import ru.serzh272.nfp.presentation.results.ResultsViewModel
import ru.serzh272.nfp.theme.NFPTheme
import ru.serzh272.nfp.ui.custom.PointsIndicator

@Composable
fun ResultsScreen(
    modifier: Modifier = Modifier,
    uiState:  ResultsScreenUiState,
    command: (ResultsViewModel.ResultsScreenCommand) -> Unit
) {

    ResultsScreenContent(modifier, uiState, command)
}

@Composable
fun ResultsScreenContent(modifier: Modifier = Modifier, uiState: ResultsScreenUiState, command: (ResultsViewModel.ResultsScreenCommand) -> Unit) {
    Column(modifier = modifier) {
        LazyColumn(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(8.dp), contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
            items(uiState.exams, key = { it.id }) {
                ExamItem(exam = it, onClick = {})
            }
        }
    }
}

@Composable
private fun ExamItem(exam: Exam, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(96.dp)
    ) {
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp), verticalAlignment = Alignment.CenterVertically) {
            Column() {
                Text(text = "text")
                Text(text = "text")
                Text(text = "text")
            }
            Spacer(modifier = Modifier.weight(1f))
            PointsIndicator(points = exam.exercises.map { ((it.result as? ExerciseWithResult.ExerciseResult.Count)?.count ?: 0) to Color.Gray }, minPoints = 30)
        }
    }
}

@Preview(device = Devices.PIXEL_4, showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun ResultsScreenPreview() {
    NFPTheme {
        ResultsScreenContent(
            modifier = Modifier
                .fillMaxSize(),
            uiState = ResultsScreenUiState(exams = DomainDataHolder.exams),
            command = {}
        )
    }
}
