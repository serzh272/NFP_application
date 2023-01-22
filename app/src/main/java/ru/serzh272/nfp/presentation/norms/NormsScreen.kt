package ru.serzh272.nfp.presentation.norms

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.serzh272.nfp.R
import ru.serzh272.nfp.presentation.model.DataHolder
import ru.serzh272.nfp.presentation.model.Exercise
import ru.serzh272.nfp.ui.theme.NFPTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NormsScreen(modifier: Modifier = Modifier, exercises: List<Exercise>, gridSpacing: Dp = 8.dp) {
    var searchQuery by rememberSaveable {
        mutableStateOf("")
    }

    val filteredExercises by remember(searchQuery) {
        mutableStateOf(exercises.let { exs ->
            if (searchQuery.isNotBlank()) exs.filter { ex ->
                ex.description.contains(
                    searchQuery,
                    true
                )
            } else exs
        })
    }

    val lazyGridState = rememberLazyGridState()
    Column {
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 8.dp, end = 16.dp),
            verticalAlignment = Alignment.CenterVertically){
            OutlinedTextField(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp),
                value = searchQuery,
                trailingIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_search),
                            contentDescription = stringResource(id = R.string.search)
                        )
                    }
                },
                singleLine = true,
                label = { Text(text = stringResource(id = R.string.search)) },
                onValueChange = {
                    searchQuery = it
                })
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_filter),
                    contentDescription = ""
                )
            }
        }
        LazyVerticalGrid(
            modifier = modifier,
            state = lazyGridState,
            columns = GridCells.Adaptive(96.dp),
            contentPadding = PaddingValues(start = 16.dp, top = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(gridSpacing),
            verticalArrangement = Arrangement.spacedBy(gridSpacing),
            content = {
                items(filteredExercises, key = { it.id }) {
                    Card(
                        modifier = Modifier
                            .size(96.dp, 112.dp).animateItemPlacement(),
                        backgroundColor = MaterialTheme.colors.secondaryVariant
                    ) {
                        Column(Modifier.fillMaxSize()) {
                            Icon(
                                modifier = Modifier
                                    .height(52.dp)
                                    .fillMaxWidth()
                                    .padding(start = 4.dp, top = 4.dp, end = 4.dp),
                                imageVector = ImageVector.vectorResource(id = it.exerciseType.iconRes),
                                contentDescription = "",
                                tint = MaterialTheme.colors.primary
                            )
                            Text(
                                modifier = Modifier.padding(horizontal = 4.dp),
                                text = it.description,
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }
            })
    }
}

@Preview(device = Devices.PIXEL_4, showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun NormsScreenPreview() {
    NFPTheme() {
        NormsScreen(
            modifier = Modifier
                .fillMaxSize(),
            exercises = DataHolder.exercises
        )
    }
}