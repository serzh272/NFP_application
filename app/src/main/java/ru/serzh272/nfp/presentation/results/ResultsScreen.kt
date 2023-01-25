package ru.serzh272.nfp.presentation.results

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.serzh272.nfp.domain.DomainDataHolder
import ru.serzh272.nfp.domain.model.Exam
import ru.serzh272.nfp.ui.theme.NFPTheme

@Composable
fun ResultsScreen(modifier: Modifier = Modifier, viewModel: ResultsViewModel = viewModel()) {
    val uiState by viewModel.resultsUiState.collectAsState()

    ResultsScreenContent(modifier, uiState, viewModel::handleCommand)
}

@Composable
fun ResultsScreenContent(modifier: Modifier = Modifier, uiState: ResultsScreenUiState, command: (ResultsViewModel.ResultsScreenCommand) -> Unit) {
    Column(modifier = modifier) {
        LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)){
            items(uiState.exams, key = {it.id}){
                ExamItem(exam = it, onClick = {})
            }
        }
    }
}

@Composable
private fun ExamItem(exam: Exam, onClick: () -> Unit) {
    Text(text = "${exam.date.time}")
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
